package com.example.task.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@Entity
@Table(name = "Teams")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {
     private Integer playerId;
     private String playerName;
     private Integer playerAge;
     private Long mobileNumber;
     private Team team;
}
