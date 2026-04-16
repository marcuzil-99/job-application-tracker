package it.marcob.jobtracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.marcob.jobtracker.entity.FollowUpTask;

@Repository
public interface IRepoFollowUpTask extends JpaRepository<FollowUpTask, Long>{

}
