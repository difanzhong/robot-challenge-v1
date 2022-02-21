package com.darren.game;

import java.awt.*;

public class Robot implements GameRobot{
    private Point currentPoint;
    private byte currentFacingDirectionIndex;

    public Robot() {
        currentPoint = new Point(0, 0);
        currentFacingDirectionIndex = 0;
    }

    public Robot(Point point, byte facingDirectionIndex) {
        currentPoint = point;
        currentFacingDirectionIndex = facingDirectionIndex;
    }

    @Override
    public Point getCurrentPoint() {
        return currentPoint;
    }

    @Override
    public void setCurrentPoint(Point currentPoint) {
        this.currentPoint = currentPoint;
    }

    @Override
    public byte getCurrentFacingDirectionIndex() {
        return currentFacingDirectionIndex;
    }

    @Override
    public void setCurrentFacingDirectionIndex(byte currentFacingDirectionIndex) {
        this.currentFacingDirectionIndex = currentFacingDirectionIndex;
    }

    @Override
    public boolean equals(Object o) {
        try {
            final Robot other = (Robot)o;
            return other.getCurrentPoint().equals(this.getCurrentPoint());
        } catch (Exception e) {
            return false;
        }
    }
}
