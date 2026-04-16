package it.marcob.jobtracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.marcob.jobtracker.entity.User;

@Repository
public interface IRepoUser extends JpaRepository<User, Long>{
	
	public Optional<User> findByEmail(String email);

}
