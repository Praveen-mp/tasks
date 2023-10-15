package com.example.task.service;

import com.example.task.model.Player;
import com.example.task.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class ApiService {
    @Autowired
    PlayerRepo playerRepo;
    public Player getUserById(Integer userId) {
        System.out.println(playerRepo.findByPlayerId(userId));
        return playerRepo.findById(userId)
                .orElseThrow();
    }

    public boolean playerRegistration(Player dto) {
        Optional<Player> isUserExists = playerRepo.findByPlayerId(dto.getPlayerId());
        if (isUserExists.isEmpty()) {
            System.out.println("Hello");
            var user = Player.builder()
                    .playerId(dto.getPlayerId())
                    .playerName(dto.getPlayerName())
                    .playerAge(dto.getPlayerAge())// Set isEnabled to tru
                    .build();

            playerRepo.save(user);
            return true;
        } else {
            return false;
        }
    }
    public boolean deleteUser(Integer user_id) {
        playerRepo.deleteById(user_id);
        return false;
    }

    public List<Player> getUser() {
        List<Player> userList = playerRepo.findAll();
        return userList.stream()
                .map(this::mapUserToUserResponse)
                .collect(Collectors.toList());
    }
    private Player mapUserToUserResponse(Player dto) {
        return  Player.builder()
                .playerId(dto.getPlayerId())
                .playerName(dto.getPlayerName())
                .playerAge(dto.getPlayerAge())// Set isEnabled to tru
                .build();
    }
}
