package org.prakarshs.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.prakarshs.Enums.PlayerSymbols;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private String name;
    private PlayerSymbols playerSymbol;
    private Integer currPosition;
}
