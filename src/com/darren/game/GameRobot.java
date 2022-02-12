package com.darren.game;

import java.awt.*;
public interface GameRobot {
    void setCurrentPoint(Point point);
    Point getCurrentPoint();

    void setCurrentFacingDirectionIndex(byte currentFacingDirectionIndex);
    byte getCurrentFacingDirectionIndex();
}
