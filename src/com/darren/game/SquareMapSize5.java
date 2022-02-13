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
    public Direction getDirectionBy(byte index) {
        return directions[index];
    }

    @Override
    public Direction[] getDirections() {
        return directions;
    }

    @Override
    public byte getDirectionIndexBy(String directionName) {
        for (byte i=0; i<directions.length; i++)
            if (directions[i].getName().equals(directionName)) return i;
        return -1;
    }

    @Override
    public boolean isValidInitiation(String[] robotInitialData) {
        if (robotInitialData.length < 3) return false;
        return isValidDirection(robotInitialData[2])
                && isValidValueX(Double.parseDouble(robotInitialData[0]))
                && isValidValueY(Double.parseDouble(robotInitialData[1]));
    }

    private boolean isValidValueX(double x) {
        return x >= 0 && x <= this.maxX;
    }

    private boolean isValidValueY(double y) {
        return y >= 0 && y <= this.maxY;
    }

    private boolean isValidDirection(String directionName) {
        for (Direction direction: directions)
            if (directionName.equals(direction.getName())) return true;
        return false;
    }
}