package org.practice.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.practice.Constants.PlayerPiece;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    private String playerName;
    private PlayerPiece playerPiece;
}
