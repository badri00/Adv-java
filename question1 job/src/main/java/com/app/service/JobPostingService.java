package com.app.service;
import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.JobPostingDto;
import com.app.entities.JobPosting;


public interface JobPostingService {
	List<JobPostingDto> getAllJobPostings();
	JobPostingDto postNewJob(JobPostingDto dto);
	ApiResponse updateJobPosting(Long id,JobPosting jobposting);
	ApiResponse deleteJobPosting(Long id);
	
	

}
