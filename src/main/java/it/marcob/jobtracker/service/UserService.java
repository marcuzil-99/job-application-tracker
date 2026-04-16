package it.marcob.jobtracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.marcob.jobtracker.config.SecurityConfig;
import it.marcob.jobtracker.entity.Role;
import it.marcob.jobtracker.entity.User;
import it.marcob.jobtracker.repository.IRepoUser;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final IRepoUser userRepo;
	
	private final PasswordEncoder passwordEncoder;

	public void createUser(User user) {
		
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		
		user.setRole(Role.USER);
		
		userRepo.save(user);
	}

	public Optional<User> getUserById(Long id) {
		return userRepo.findById(id);
	}

	public Optional<User> getUserByEmail(String email){
		return userRepo.findByEmail(email);
	}

	public List<User> findAllUsers(){
		return userRepo.findAll();
	}

	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}
	
	public User login(User user) {
		User databaseUser = getUserByEmail(user.getEmail()).orElseThrow(() -> new RuntimeException("No user found with email: " + user.getEmail()));
		
		if(passwordEncoder.matches(user.getPassword(), databaseUser.getPassword())) return databaseUser;
		else return null;
	}
}
