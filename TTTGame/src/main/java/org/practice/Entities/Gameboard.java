package org.practice.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Gameboard {

    public String[][] generateGameboard(Integer size){
        String[][] board = new String[size][size];

        for(int rows = 0; rows < size; rows++){
            for (int cols = 0; cols < size; cols++){
                board[rows][cols] = "-";
            }
        }
       return board;
    }

    public void printBoard(String[][] board){
        for(int rows = 0; rows < board.length; rows++) {
            for (int cols = 0; cols < board.length; cols++) {
                System.out.print(board[rows][cols]+" ");
            }
            System.out.println();
        }
    }
}
