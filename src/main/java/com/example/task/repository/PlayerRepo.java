package com.example.task.repository;

import com.example.task.model.Player;
import com.example.task.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepo extends JpaRepository<Player,Integer> {
    Optional<Player> findByPlayerId(Integer playerId);
}
