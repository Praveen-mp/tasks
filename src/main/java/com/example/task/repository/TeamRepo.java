package com.example.task.repository;

import com.example.task.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepo extends JpaRepository<Team,Integer> {
    Optional<Team> findByTeamId(Integer teamId);
}
