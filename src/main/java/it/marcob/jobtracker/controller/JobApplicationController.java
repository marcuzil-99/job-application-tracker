package it.marcob.jobtracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import it.marcob.jobtracker.entity.JobApplication;
import it.marcob.jobtracker.service.JobApplicationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/job-applications")
@RequiredArgsConstructor
public class JobApplicationController {
	
	private final JobApplicationService jService;
	
	@PostMapping
	public void createJobApplication(@RequestBody JobApplication jobApplication) {
		jService.createJobApplication(jobApplication);
	}

	@GetMapping("/{id}")
	public JobApplication getJobApplicationById(@PathVariable Long id) {
		return jService.getJobApplicationById(id).orElseThrow(() -> new RuntimeException("JobApplication not found with id: "+id));
	}

	@GetMapping
	public List<JobApplication> getAllJobApplications() {
		return jService.getAllJobApplications();
	}

	@PutMapping("/{id}")
	public void updateJobApplication(@PathVariable Long id, @RequestBody JobApplication updated) {
		jService.updateJobApplication(id, updated);
	}

	@DeleteMapping("/{id}")
	public void deleteJobApplication(@PathVariable Long id) {
		jService.deleteJobApplication(id);
	}

}
