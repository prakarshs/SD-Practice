package org.practice.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.graalvm.collections.Pair;

import java.util.Deque;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameSetup {
    private Deque<Player> players;
    private String[][] gameboard;


    void startGame(){
        boolean won = false;
        Scanner scanner = new Scanner(System.in);
        while (!won){
            String[] input = scanner.nextLine().trim().split(",");
            Pair<Integer,Integer> move = Pair.create(Integer.valueOf(input[0]),Integer.valueOf(input[1]));
            if()
        }
    }
}
