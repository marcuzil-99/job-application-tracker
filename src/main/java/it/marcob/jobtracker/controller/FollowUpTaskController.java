package it.marcob.jobtracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import it.marcob.jobtracker.entity.FollowUpTask;
import it.marcob.jobtracker.service.FollowUpTaskService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/follow-up-tasks")
@RequiredArgsConstructor
public class FollowUpTaskController {
	
	private final FollowUpTaskService tService;

	@PostMapping
	public void createFollowUpTask(@RequestBody FollowUpTask task) {
		tService.createFollowUpTask(task);
	}

	@GetMapping("/{id}")
	public FollowUpTask getFollowUpTaskById(@PathVariable Long id) {
		return tService.getFollowUpTaskById(id).orElseThrow(() -> new RuntimeException("FollowUpTask not found with id: "+id));
	}

	@GetMapping
	public List<FollowUpTask> getAllFollowUpTasks() {
		return tService.getAllFollowUpTasks();
	}

	@PutMapping("/{id}")
	public void updateFollowUpTask(@PathVariable Long id, @RequestBody FollowUpTask updated) {
		tService.updateFollowUpTask(id, updated);
	}

	@DeleteMapping("/{id}")
	public void deleteFollowUpTask(@PathVariable Long id) {
		tService.deleteFollowUpTask(id);
	}

}
