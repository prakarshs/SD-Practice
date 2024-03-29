package org.practice.Actions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.graalvm.collections.Pair;
import org.practice.Entities.Player;

@Data
@AllArgsConstructor
public class Checks {

    public boolean emptyCellsLeft(String[][] board) {
        for (int rows = 0; rows < board.length; rows++) {
            for (int cols = 0; cols < board.length; cols++) {
                if (board[rows][cols] == "-") {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validMove(String[][] board, Pair<Integer, Integer> move) {
        for (int rows = 0; rows < board.length; rows++) {
            for (int cols = 0; cols < board.length; cols++) {
                if (move.getLeft() == rows && move.getRight() == cols) {
                    if (board[rows][cols] != "-") {
                        System.out.println("\uD83D\uDEA8 Cell Is Not Empty. Make A Different Move \uD83D\uDEA8");
                        return false;
                    } else return true;
                }
            }
        }
        System.out.println("\uD83D\uDEA8 Entered Move Is Invalid \uD83D\uDEA8");
        return false;
    }


    public boolean moveWon(String[][] board, Pair<Integer, Integer> move, Player player) {
        int flag = 0;

        for (int cells = 0; cells < board.length; cells++) {
            if (board[move.getLeft()][cells] != String.valueOf(player.getPlayerPiece())) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            return true;
        }
        flag = 0;
        for (int cells = 0; cells < board.length; cells++) {
            if (board[cells][move.getRight()] != String.valueOf(player.getPlayerPiece())) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            return true;
        }
        flag = 0;
        if (move.getLeft() == move.getRight()) {
            for (int cells = 0; cells < board.length; cells++) {
                if (board[cells][cells] != String.valueOf(player.getPlayerPiece())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return true;
            }
        }
        flag = 0;
        if (move.getLeft() + move.getRight() + 1 == board.length) {
            for (int cells = 0, antiCells = board.length - 1; cells < board.length; cells++, antiCells--) {
                if (board[cells][antiCells] != String.valueOf(player.getPlayerPiece())) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                return true;
            }
        }
        return false;
    }
}
