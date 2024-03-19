package org.practice.Actions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.graalvm.collections.Pair;
import org.practice.Entities.Player;

@AllArgsConstructor
@Data
public class Movements {

    public String[][] makeMove(String[][] board, Pair<Integer,Integer> move, Player player){
        board[move.getLeft()][move.getRight()] = String.valueOf(player.getPlayerPiece());
        return board;
    }

}
