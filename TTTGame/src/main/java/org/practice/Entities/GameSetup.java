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

    final Gameboard board = new Gameboard();
    final Checks checks = new Checks();
    final Movements movements = new Movements();

    public void startGame(){
        boolean won = false;
        Scanner scanner = new Scanner(System.in);
        while (!won){
            Player player = players.poll();
            System.out.println(player.getPlayerName()+"'s turn :");
            String[] input = scanner.nextLine().trim().split(",");
            Pair<Integer,Integer> move = Pair.create(Integer.valueOf(input[0]) - 1,Integer.valueOf(input[1]) - 1);
            if(checks.validMove(gameboard,move)){

               movements.makeMove(gameboard,move,player);
               board.printBoard(gameboard);
               if(checks.moveWon(gameboard,move,player)){
                   won = true;
                   System.out.println(player.getPlayerName()+" HAS WON THE GAME !!");
               }
               players.offer(player);
            }
            else {
                players.addFirst(player);
            }
        }
    }
}
