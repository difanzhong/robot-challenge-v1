package com.darren.game;

import com.darren.game.directions.*;

public class SquareMapSize5 implements GameMap2D{
    private int maxX = 5;
    private int maxY = 5;

    private final Direction[] directions = {new North(), new East(), new South(), new West()};

    @Override
    public int getMaxX() {
        return maxX;
    }

    @Override
    public int getMaxY() {
        return maxY;
    }

    @Override
    public Direction[] getDirections() {
        return directions;
    }

    @Override
    public boolean isValidPointOnMap(double x, double y) {
        return isValidValueX(x) && isValidValueY(y);
    }

    @Override
    public boolean isValidDirectionIndex(byte index) {
        return index > 0 && index < directions.length-1;
    }

    private boolean isValidValueX(double x) {
        return x >= 0 && x <= this.maxX;
    }

    private boolean isValidValueY(double y) {
        return y >= 0 && y <= this.maxY;
    }
}