package com.darren.game;

import com.darren.game.directions.Direction;

public interface GameMap2D {
    int getMaxX();
    int getMaxY();
    Direction[] getDirections();
    boolean isValidPointOnMap(double x, double y);
    boolean isValidDirectionIndex(byte index);
}
