package com.app.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.dto.JobPostingDto;
import com.app.entities.JobPosting;
import com.app.repository.JobPostingRepo;
@Service
@Transactional

public class JobPostingServiceImpl implements JobPostingService{
	@Autowired
	private JobPostingRepo jobPostingRepo;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<JobPostingDto> getAllJobPostings()
	{
		System.out.println("in get all jobpositngs service impl!!");
		List<JobPosting> jobPostings=jobPostingRepo.findAll();
		List<JobPostingDto> jobPostingDtos=new ArrayList<>();
		for (JobPosting jobPosting : jobPostings ) {
			JobPostingDto jobPostingDto=modelMapper.map(jobPosting,JobPostingDto.class);
			jobPostingDtos.add(jobPostingDto);
		
		}
		return jobPostingDtos;
		
	}
	
	@Override
	public JobPostingDto postNewJob(JobPostingDto dto) {
		System.out.println("in post new job service");
		JobPosting jobPosting =modelMapper.map(dto,JobPosting.class);
		JobPosting jobPosting2=jobPostingRepo.save(jobPosting);
		return modelMapper.map(jobPosting2,JobPostingDto.class);
		
	}
	
	@Override
	public ApiResponse updateJobPosting(Long id ,JobPosting jobPosting ) {
		System.out.println("update job service");
		String msg="failed to update !";
		jobPosting.setId(id);
		if (jobPostingRepo.existsById(id)) {

			jobPostingRepo.save(jobPosting);
			msg="successfully updated details";
		}
		else
			throw new ResourceNotFoundException(
					"Invalid Jobposting id");
		return new ApiResponse(msg);
		
		
}
	@Override
	public ApiResponse deleteJobPosting(Long id) {
		System.out.println("in delete job service");
		String msg="failed to delete!!";
		if(jobPostingRepo.existsById(id)) {
			jobPostingRepo.deleteById(id);
			msg="successfully deleted details";
		}
		else 
			throw new ResourceNotFoundException(
					"Invalid JobPosting id ");
		
		return new ApiResponse(msg);
	}


}
