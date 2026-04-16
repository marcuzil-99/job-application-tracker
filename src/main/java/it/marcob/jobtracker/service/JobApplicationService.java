package it.marcob.jobtracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.marcob.jobtracker.entity.JobApplication;
import it.marcob.jobtracker.repository.IRepoJobApplication;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
	
	private final IRepoJobApplication jaRepo;
	
	public void createJobApplication(JobApplication jobApplication) {
		jaRepo.save(jobApplication);
	}

	public Optional<JobApplication> getJobApplicationById(Long id) {
		return jaRepo.findById(id);
	}

	public List<JobApplication> getAllJobApplications() {
		return jaRepo.findAll();
	}

	public void updateJobApplication(Long id, JobApplication updated) {
		JobApplication existing = jaRepo.findById(id)
		        .orElseThrow(() -> new RuntimeException("JobApplication not found with id: " + id));

		    existing.setCompany(updated.getCompany());
		    existing.setUrl(updated.getUrl());
		    existing.setStatus(updated.getStatus());
		    existing.setApplicationDate(updated.getApplicationDate());
		    existing.setUser(updated.getUser());

		    jaRepo.save(existing);
	}

	public void deleteJobApplication(Long id) {
		jaRepo.deleteById(id);
	}

}
