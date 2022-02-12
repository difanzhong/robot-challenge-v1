package com.darren.game;

import java.awt.*;

public class Robot implements GameRobot{
    private Point currentPoint;
    private byte currentFacingDirectionIndex;

    public Robot(Point point, byte facingDirectionIndex) {
        currentPoint = point;
        currentFacingDirectionIndex = facingDirectionIndex;
    }

    public Point getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Point currentPoint) {
        this.currentPoint = currentPoint;
    }

    public byte getCurrentFacingDirectionIndex() {
        return currentFacingDirectionIndex;
    }

    public void setCurrentFacingDirectionIndex(byte currentFacingDirectionIndex) {
        this.currentFacingDirectionIndex = currentFacingDirectionIndex;
    }
}
