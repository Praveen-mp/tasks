package com.example.task.controller;

import com.example.task.model.Player;
import com.example.task.service.ApiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ApiController {
    @Autowired
    private ApiService apiService;

    @PostMapping("/team")
    public ResponseEntity<String> saveStudent(@RequestBody Player dto) {
        boolean isRegistered = apiService.playerRegistration(dto);

        return isRegistered ? ResponseEntity.ok("User registered successfully")
                : ResponseEntity.badRequest().body("Something went wrong!");
    }


    @DeleteMapping("/delete/{teamId}")
    public boolean deleteByUserId(@PathVariable Integer teamId){
        System.out.println(teamId);
        return apiService.deleteUser(teamId);
    }

    @GetMapping("/team/{teamId}")
    public Optional<Player> getUserByID(@PathVariable Integer teamId){
        System.out.println(teamId);
        return Optional.ofNullable(apiService.getUserById(teamId));
    }
    @GetMapping("/team")
    public List<Player> getUserAll(){
        return apiService.getUser();
    }

}
