package it.marcob.jobtracker.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import it.marcob.jobtracker.entity.User;
import it.marcob.jobtracker.service.UserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService uService;
	
	@GetMapping
	public List<User> getAllUsers(){
		return uService.findAllUsers();
	}
	
	@PostMapping("/register")
	public void createUser(@RequestBody User user) {
		uService.createUser(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		uService.deleteUser(id);
	}
	
	@PostMapping("/login")
	public void login(@RequestBody User user) {
		uService.login(user);
	}

}
