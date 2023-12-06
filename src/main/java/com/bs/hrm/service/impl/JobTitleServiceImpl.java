package com.bs.hrm.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bs.hrm.entity.JobTitle;
import com.bs.hrm.repos.JobTitleRepo;
import com.bs.hrm.service.JobTitleService;

@Service
public class JobTitleServiceImpl implements JobTitleService{

	@Autowired JobTitleRepo 	jobTitleRepo;
	
	@Override
	public JobTitle addJobTitle(JobTitle jobTitle) {
		// set create date time 
		jobTitle.setCreatedDate(LocalDateTime.now()); 
		jobTitleRepo.saveAndFlush(jobTitle);
		return null;
	}

	@Override
	public JobTitle updateJobTitle(JobTitle jobTitle) {
		Optional<JobTitle> savedJobTitle = jobTitleRepo.findById(jobTitle.getJobId());
		if(savedJobTitle.isPresent()) {
			JobTitle jobTitleToUpdate = savedJobTitle.get();
			/*** set fields updated values ***/
			jobTitleToUpdate.setTitle(jobTitle.getTitle());
			jobTitleToUpdate.setDescription(jobTitle.getDescription());
			jobTitleToUpdate.setResponsibility(jobTitle.getResponsibility());
			jobTitleToUpdate.setStatus(jobTitle.getStatus());
			// set update date time 
			jobTitleToUpdate.setUpdatedDate(LocalDateTime.now());
			/*** update jobTitle***/
			JobTitle updatedJobTitle = jobTitleRepo.saveAndFlush(jobTitleToUpdate);
			return updatedJobTitle;
		}
		else return null;
	}

	@Override
	public JobTitle getJobTitle(Integer jobId) {
		JobTitle jobTitle = jobTitleRepo.findById(jobId).get();
		return jobTitle;
	}

	@Override
	public List<JobTitle> getAllJobTitle() {
		List<JobTitle> allJobTitle = jobTitleRepo.findAll();
		if(allJobTitle.isEmpty())
			return null;
		else
			return allJobTitle;
	}

}
