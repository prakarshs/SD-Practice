package org.prakarshs;

import org.prakarshs.Entities.*;
import org.prakarshs.Enums.PlayerSymbols;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board(100);
        Player player1 = new Player("Vasu", PlayerSymbols.P,0);
        Player player2 = new Player("Raju", PlayerSymbols.R,0);
        Player player3 = new Player("Shyam", PlayerSymbols.S,0);
        Player player4 = new Player("Baburao", PlayerSymbols.B,0);

        Queue<Player> playerList = new LinkedList<>();
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);

        Map<Integer,Integer> snakeList = new LinkedHashMap<>();
        Snakes snake1 = new Snakes(99,4);
        Snakes snake2 = new Snakes(82,12);
        Snakes snake3 = new Snakes(56,30);
        Snakes snake4 = new Snakes(20,7);

        snakeList.put(snake1.getStartIndex(), snake1.getEndIndex());
        snakeList.put(snake2.getStartIndex(), snake2.getEndIndex());
        snakeList.put(snake3.getStartIndex(), snake3.getEndIndex());
        snakeList.put(snake4.getStartIndex(), snake4.getEndIndex());


        Map<Integer,Integer> ladderList = new LinkedHashMap<>();

        Ladders ladder1 = new Ladders(14,88);
        Ladders ladder2 = new Ladders(76,96);
        Ladders ladder3 = new Ladders(10,60);
        Ladders ladder4 = new Ladders(36,77);

        ladderList.put(ladder1.getStartIndex(), ladder1.getEndIndex());
        ladderList.put(ladder2.getStartIndex(), ladder2.getEndIndex());
        ladderList.put(ladder3.getStartIndex(), ladder3.getEndIndex());
        ladderList.put(ladder4.getStartIndex(), ladder4.getEndIndex());


        Dice dice = new Dice(6);

        GameMachine gameMachine = new GameMachine(board, playerList, snakeList, ladderList, dice);

        gameMachine.startGame();
    }
}