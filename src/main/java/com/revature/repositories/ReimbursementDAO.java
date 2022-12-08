package com.revature.repositories;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementDAO extends JpaRepository<Reimbursement, Integer>{

	
//	public Optional<Reimbursement> getByType(String type);
//	public Optional<Reimbursement> getByStatus(String status);
	public Optional<List<Reimbursement>> getByAuthor(User author);
	public Optional<Reimbursement> getById(int reimbursementID);
	
}
