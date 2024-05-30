package org.prakarshs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prakarshs.Entities.Board;
import org.prakarshs.Entities.Dice;
import org.prakarshs.Entities.Player;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameMachine {
    private Board board;
    private Queue<Player> playerList;
    private Map<Integer,Integer> snakes;
    private Map<Integer,Integer> ladders;
    private Dice dice;

    void startGame() throws InterruptedException {
        System.out.println("!! Let The Game Begin !!");
        List<Player> winnerList = new ArrayList<>();
        while (playerList.size() != 1) {
            boolean won = false;
            Player player = playerList.poll();
            System.out.println("It is " + player.getName() + "'s Turn !");
            Integer diceValue = dice.roll();
            System.out.println(player.getName() + " Rolls a " + diceValue);
            Thread.sleep(00);
            Integer newPosition = diceValue+player.getCurrPosition();

            if(newPosition > board.getBoardSize()){
                System.out.println(player.getName()+" Has Won !");
                Thread.sleep(00);
                winnerList.add(player);
                won = true;
            }
            else if(snakes.containsKey(newPosition)){
                player.setCurrPosition(snakes.get(newPosition));
                System.out.println(player.getName() + " Bitten By A snake. Goes Down To " + player.getCurrPosition());
                Thread.sleep(00);
            }
            else if(ladders.containsKey(newPosition)){
                player.setCurrPosition(ladders.get(newPosition));
                System.out.println(player.getName() + " Climbed A Ladder! Goes Up To " + player.getCurrPosition());
                Thread.sleep(00);
            }
            else{
                player.setCurrPosition(newPosition);
                System.out.println(player.getName()+" Is Now On " + newPosition);
                Thread.sleep(00);
            }

            if(!won){
                playerList.add(player);
            }
        }
        System.out.println("\n\nHere Are The Winners !!");
        int pos=1;
        for(var i : winnerList){
            System.out.println(i.getName() + " is on position "+pos+" with goti "+i.getPlayerSymbol());
            pos++;
        }
    }
}
