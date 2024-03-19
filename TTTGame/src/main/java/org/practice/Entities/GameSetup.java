package org.practice.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Deque;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameSetup {
    private Deque<Player> players;
    private String[][] gameboard;


    
}
