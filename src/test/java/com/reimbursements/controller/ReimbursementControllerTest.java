package com.reimbursements.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reimbursements.SecurityReimbursementsApplication;
import com.reimbursements.models.Reimbursement;
import com.reimbursements.models.User;
import com.reimbursements.reporitories.ReimbursementRepository;
import com.reimbursements.reporitories.StatusRepository;
import com.reimbursements.requests.CreateReimbursementRequest;
import com.reimbursements.requests.UpdateReimbursementRequest;
import com.reimbursements.services.StatusService;
import com.reimbursements.services.UserService;

@ContextConfiguration(classes = SecurityReimbursementsApplication.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ReimbursementControllerTest {
	
	@Autowired
		private MockMvc mockMvc;
	
	@Autowired
		private ReimbursementRepository reimbursementRepository;
	
	
	@Autowired
	  private ObjectMapper objectMapper;
 
	 @Test
	 void CreateReimbursementTest() throws Exception {
	        
	        CreateReimbursementRequest createReimbursementRequest = new CreateReimbursementRequest(1, 201.50, 1, "newReimbursement");

	        mockMvc.perform(post("/reimbursements/add-new-reimbursement")
	        		 .contentType("application/json")
	        		 .content(objectMapper.writeValueAsString(createReimbursementRequest)))
	        	     .andExpect(status().isOk());
	        Optional<Reimbursement> reimbursement = reimbursementRepository.getById(2);
	         assertThat(reimbursement.get().getAmount()).isEqualTo(201.50);
	       }
	      
	 @Test
	 void UpdateReimbursementTest() throws Exception {
	        
	        UpdateReimbursementRequest updateReimbursementRequest = new UpdateReimbursementRequest(1, 1, 1);

	        mockMvc.perform(put("/reimbursements/update-reimbursement")
	        		 .contentType("application/json")
	        		 .content(objectMapper.writeValueAsString(updateReimbursementRequest)))
	        	     .andExpect(status().isOk());
	        Optional<Reimbursement> reimbursement = reimbursementRepository.getById(1);
	         assertThat(reimbursement.get().getStatus()).isEqualTo(1);
	       }   
	

}
