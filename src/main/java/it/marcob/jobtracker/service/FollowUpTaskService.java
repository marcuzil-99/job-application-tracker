package it.marcob.jobtracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.marcob.jobtracker.entity.FollowUpTask;
import it.marcob.jobtracker.repository.IRepoFollowUpTask;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FollowUpTaskService {
	
	private final IRepoFollowUpTask taskRepo;

	public void createFollowUpTask(FollowUpTask task) {
		taskRepo.save(task);
	}

	public Optional<FollowUpTask> getFollowUpTaskById(Long id) {
		return taskRepo.findById(id);
	}

	public List<FollowUpTask> getAllFollowUpTasks() {
		return taskRepo.findAll();
	}

	public void updateFollowUpTask(Long id, FollowUpTask updated) {
		FollowUpTask existing = taskRepo.findById(id)
		        .orElseThrow(() -> new RuntimeException("FollowUpTask not found with id: " + id));

		    existing.setTitle(updated.getTitle());
		    existing.setDescription(updated.getDescription());
		    existing.setDueDate(updated.getDueDate());
		    existing.setJobApplication(updated.getJobApplication());
		    existing.updateStatus();

		    taskRepo.save(existing);
	}

	public void deleteFollowUpTask(Long id) {
		taskRepo.deleteById(id);
	}
}
