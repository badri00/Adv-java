package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.JobPostingDto;
import com.app.entities.JobPosting;
import com.app.service.JobPostingService;



@RestController
@RequestMapping("/jobposting")
public class JobPostingController {
	
	@Autowired
	private JobPostingService jobPostingService;
	
	@GetMapping 
	public ResponseEntity<?> listAllJobPostings(){
		System.out.println("in job positng controller");
		return ResponseEntity.status(HttpStatus.OK).body(jobPostingService.getAllJobPostings());
		
	}
	
	@PostMapping
	public ResponseEntity<?> postNewJob(@RequestBody JobPostingDto dto){
	System.out.println("in post new job controller");
	return ResponseEntity.status(HttpStatus.CREATED).body(jobPostingService.postNewJob(dto));
	
		
	}
	@PutMapping("/{jobid}")
	public ResponseEntity<?> updateJobPostingDetails(@PathVariable Long jobid,@RequestBody JobPosting jobPosting){
		System.out.println("in update id:"+jobid+" "+jobPosting);
		return ResponseEntity.status(HttpStatus.OK).body(jobPostingService.updateJobPosting(jobid,jobPosting));
		
	}
	
	@DeleteMapping("/{jobid}")
	public ResponseEntity<?> deleteJobPostingDetails(@PathVariable Long jobid){
		System.out.println("in delete job posting controller");
		return ResponseEntity.status(HttpStatus.OK).body(jobPostingService.deleteJobPosting(jobid));
		
	}
	
}
