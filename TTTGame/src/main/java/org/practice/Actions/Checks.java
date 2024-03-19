package org.practice.Actions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.graalvm.collections.Pair;
import org.practice.Entities.Player;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Checks {

    public boolean validMove(String[][] board, Pair<Integer,Integer> move){
        for (int rows = 0; rows < board.length; rows++){
            for (int cols = 0; cols < board.length; cols++){
                if(move.getLeft() == rows && move.getRight() == cols){
                    if(board[rows][cols]!="-"){
                        System.out.println("!! Cell Is Not Empty. Make A Different Move !!");
                        return false;
                    }
                    else return true;
                }
            }
        }
        System.out.println("!! Entered Move Is Invalid !!");
        return false;
    }


    public boolean moveWon(String[][] board, Pair<Integer,Integer> move, Player player){
        int flag = 0;
        boolean rowWon = false;
        boolean colWon = false;

        for (int cells = 0; cells < board.length; cells++){
           if(board[move.getLeft()][cells] != String.valueOf(player.getPlayerPiece())){
               flag = 1;
               break;
           }
        }
        if(flag==0){
            rowWon = true;
            return rowWon;
        }
        flag = 0;
        for (int cells = 0; cells < board.length; cells++){
            if(board[cells][move.getRight()] != String.valueOf(player.getPlayerPiece())){
                flag = 1;
                break;
            }
        }
        if(flag==0){
            colWon = true;
            return colWon;
        }


        return false;
    }
}
