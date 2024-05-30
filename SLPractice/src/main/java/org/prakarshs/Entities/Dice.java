package org.prakarshs.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dice {
    private Integer numberOfSides;

    public Integer roll(){
        Random random = new Random();
        return random.nextInt(this.numberOfSides) + 1;
    }
}
