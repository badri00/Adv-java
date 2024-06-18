package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.entities.JobPosting;
public interface JobPostingRepo extends JpaRepository<JobPosting, Long>{
	

}
