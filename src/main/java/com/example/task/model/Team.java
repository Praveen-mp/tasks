package com.example.task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Teams")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {
      Integer teamId;
      String teamName;
      String sportsName;
      List<Player> players = new ArrayList<>();
}
