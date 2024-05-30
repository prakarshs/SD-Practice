package org.prakarshs.Entities;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Ladders {
    private Integer startIndex;
    private Integer endIndex;

    public Ladders(Integer startIndex, Integer endIndex){
        this.endIndex = endIndex;
        this.startIndex = startIndex;

        if(startIndex >= endIndex){
            throw new IllegalArgumentException("The start index should always be lower for ladders");
        }
    }
}
