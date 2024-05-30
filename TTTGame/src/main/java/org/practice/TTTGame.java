package org.practice;


import org.practice.Constants.PlayerPiece;
import org.practice.Entities.GameSetup;
import org.practice.Entities.Gameboard;
import org.practice.Entities.Player;

import java.util.ArrayDeque;
import java.util.Deque;

public class TTTGame {
    public static void main(String[] args) {

        Gameboard gameboard = new Gameboard();
        String[][] board = gameboard.generateGameboard(3);

        Player player1 = Player.builder()
                .playerName("Vasu")
                .playerPiece(PlayerPiece.V)
                .build();
        Player player2 = Player.builder()
                .playerName("Pari")
                .playerPiece(PlayerPiece.P)
                .build();

        Deque<Player> players = new ArrayDeque<>();
        players.add(player1);
        players.add(player2);

        GameSetup gameSetup = GameSetup.builder()
                .gameboard(board)
                .players(players)
                .build();

        gameSetup.startGame();

    }
}