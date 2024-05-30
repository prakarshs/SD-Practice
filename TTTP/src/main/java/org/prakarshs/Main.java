package org.prakarshs;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(3);


        Player player1 = new Player("Pari",PlayerType.P);
        Player player2 = new Player("Vasu",PlayerType.V);
        Queue<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);

        GameMachine gameMachine = new GameMachine(board, players);

        gameMachine.startGame();

    }
}