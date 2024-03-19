package org.practice.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.graalvm.collections.Pair;
import org.practice.Actions.Checks;
import org.practice.Actions.Movements;

import java.util.Deque;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameSetup {
    private Deque<Player> players;
    private String[][] gameboard;

    Gameboard board = new Gameboard();
    Checks checks = new Checks();
    Movements movements = new Movements();

    void startGame(){
        boolean won = false;
        Scanner scanner = new Scanner(System.in);
        while (!won){
            Player player = players.poll();
            System.out.println(player.getPlayerName()+"'s turn :");
            String[] input = scanner.nextLine().trim().split(",");
            Pair<Integer,Integer> move = Pair.create(Integer.valueOf(input[0]),Integer.valueOf(input[1]));
            if(checks.validMove(gameboard,move)){

               movements.makeMove(gameboard,move,player);

               if(checks.moveWon(gameboard,move,player)){
                   won = true;
                   System.out.println(player.getPlayerName()+" HAS WON THE GAME !!");
               }
               board.printBoard(gameboard);
               players.offer(player);
            }
            else {
                players.addFirst(player);
            }
        }
    }
}
