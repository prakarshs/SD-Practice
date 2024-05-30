package org.prakarshs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private Integer row;
    private Integer col;

    public void initialize(){
        String[][] board = new String[row][col];
        for(int i=0; i<this.row; i++){
            for(int j=0; j<this.col; j++){
                board[i][j] = "-";
            }
        }
    }
}
