package com.reimbursements.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import javax.transaction.Transactional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursements.SecurityReimbursementsApplication;
import com.reimbursements.models.Authority;
import com.reimbursements.models.User;
import com.reimbursements.reporitories.AuthorityRepository;
import com.reimbursements.reporitories.UserRepository;
import com.reimbursements.requests.CreateAuthorityRequest;
import com.reimbursements.requests.CreateUserRequest;
import com.reimbursements.requests.LoginUserRequest;

@ContextConfiguration(classes = SecurityReimbursementsApplication.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	  private ObjectMapper objectMapper;
	

	@Autowired
	  private UserRepository userRepository;
	
	@Autowired
	  private AuthorityRepository authorityRepository;
	
	
	@Test
	
	void ShouldGetAllUsersTest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/users/get-all-users"))
		.andDo(print())
		.andExpect(status().is(200))
		.andExpect(jsonPath("$").isArray())
		.andExpect(jsonPath("$", Matchers.hasSize(3)));
	}
	
	@Test
	@Transactional
    void registerTest() throws Exception {
        
		CreateUserRequest createUserRequest = new CreateUserRequest("newuser", "test", "Firstname", "Lastname", "test@wp.pl", "ROLE_ADMIN", 4);

         mockMvc.perform(post("/users/register")
        		 .contentType("application/json")
        		 .content(objectMapper.writeValueAsString(createUserRequest)))
        	     .andExpect(status().isOk());
         
         User user = userRepository.getUserByUsername("newuser");
         assertThat(user.getEmail()).isEqualTo("test@wp.pl");
       }
	
	@Test
	@Transactional
	void registerNewAuthorityTest() throws Exception {
        
		CreateAuthorityRequest createAuthorityRequest = new CreateAuthorityRequest("ROLE_ADMIN", 1);

         mockMvc.perform(post("/users/authority-registration")
        		 .contentType("application/json")
        		 .content(objectMapper.writeValueAsString(createAuthorityRequest)))
        	     .andExpect(status().isOk());
         
         Optional<Authority> authority = authorityRepository.findById(7);
         assertThat(authority.get().getAuthorityName()).isEqualTo("ROLE_ADMIN");                

    }
	
	@Test
	@Transactional
	void loginTest() throws Exception{
		LoginUserRequest loginUserRequest = new LoginUserRequest("test21", "test21");
		
		MockHttpServletResponse response = mockMvc.perform(post("/login")
				.contentType("application/x-www-form-urlencoded")
	       		.content(String.format("username=%s&password=%s", loginUserRequest.getUsername(), loginUserRequest.getPassword())))
			.andExpect(status().is3xxRedirection())
			.andReturn()
			.getResponse();
		
		assertThat(response.getStatus()).isEqualTo(302);
		assertThat(response.getHeader("Location")).isEqualTo("/");
		}
	}


