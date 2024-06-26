package org.prakarshs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameMachine {
    private Board board;
    private Queue<Player> playerList;

    void startGame() {
        System.out.println("The Game Begins Now!!");
        String[][] gboard = board.initialize();
        Scanner sc = new Scanner(System.in);
        List<String> winners = new ArrayList<>();
        while (playerList.size() != 1) {
            board.print(gboard);
            if (!board.boardFull(gboard)) {
            Player player = playerList.poll();
            System.out.println(player.getPlayerName() + "'s Chance! Enter Your Cordinates!");
            String[] move = sc.nextLine().trim().split(",");
                while (!board.valid(move, gboard)) {
                    System.out.println("Your Move is Invalid. Try With a Move Within The Playing Board.");
                    move = sc.nextLine().trim().split(",");
                }
                while (!board.canMove(move, gboard)) {
                    System.out.println("You Cant Move An Already Checked Cell. Try With a Move Amongst The Empty Cells.");
                    move = sc.nextLine().trim().split(",");
                }
                gboard = board.makeMove(move, player, gboard);
                if (board.hasWon(move, player, gboard)) {
                    gboard = board.makeMove(move, player, gboard);
                    System.out.println(player.getPlayerName() + " Has Won With The Piece " + player.getPlayerType() + " !!");
                    winners.add(player.getPlayerName());
                } else {
                    playerList.add(player);
                }
            } else {
                System.out.println("The Board Has No More Empty Cells. Khichadi pak gayi !!");
                break;
            }
        }
        if (!winners.isEmpty()) {
            Integer pos = 1;
            for (var i : winners) {
                System.out.println(i + " Is At Position : " + pos + " !!");
                pos++;
            }
        }
    }
}
