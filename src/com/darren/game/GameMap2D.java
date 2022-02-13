package com.darren.game;

import com.darren.game.directions.Direction;

public interface GameMap2D {
    int getMaxX();
    int getMaxY();
    byte getDirectionIndexBy(String directionName);
    Direction getDirectionBy(byte index);
    Direction[] getDirections();
    boolean isValidInitiation(String[] robotInitialData);
}
