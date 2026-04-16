package it.marcob.jobtracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.marcob.jobtracker.entity.User;
import it.marcob.jobtracker.repository.IRepoUser;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	private final IRepoUser userRepo;

	public void createUser(User user) {
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
}
