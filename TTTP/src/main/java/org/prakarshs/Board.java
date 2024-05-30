package org.prakarshs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Integer size;

    public String[][] initialize(){
        String[][] board = new String[size][size];
        for(int i=0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                board[i][j] = "-";
            }
        }
        return board;
    }

    public void print(String[][] board){
        for(int i=0; i< board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public boolean valid(String[] move, String[][] gboard) {
        Integer rowM = Integer.valueOf(move[0]) ;
        Integer colM = Integer.valueOf(move[1]) ;

        return rowM<=gboard.length && colM<=gboard.length;
    }

    public boolean canMove(String[] move, String[][] gboard) {
        Integer rowM = Integer.valueOf(move[0]) - 1;
        Integer colM = Integer.valueOf(move[1]) - 1;

        return gboard[rowM][colM].equals("-");
    }

    public boolean hasWon(String[] move,Player player, String[][] gboard) {
        Integer rowM = Integer.valueOf(move[0]) - 1;
        Integer colM = Integer.valueOf(move[1]) - 1;

        boolean rowWon = true;
        boolean colWon = true;
        boolean ldiaWon = true;
        boolean rdiaWon = true;

        //checking row victory
        for (int i = 0; i<gboard.length; i++){
            if(!gboard[rowM][i].equals(player.getPlayerType().toString())) {
                rowWon = false;
                break;
            }
        }
        if(rowWon)return true;

        //checking col victory
        for (int i = 0; i<gboard.length; i++){
            if(!gboard[i][colM].equals(player.getPlayerType().toString())) {
                colWon = false;
                break;
            }
        }
        if(colWon)return true;

        //checking \dia victory
        for (int i = 0; i<gboard.length; i++){
            if(!gboard[i][i].equals(player.getPlayerType().toString())) {
                ldiaWon = false;
                break;
            }
        }
        if(ldiaWon)return true;

        //checking /dia victory
        for (int i = gboard.length - 1; i>=0; i--){
            if(!gboard[gboard.length - i - 1][i].equals(player.getPlayerType().toString())) {
                rdiaWon = false;
                break;
            }
        }
        if(rdiaWon)return true;

        return false;
    }
}