package com.darren.game.directions;

import com.darren.game.GameMap2D;
import com.darren.game.GameRobot;
import com.darren.game.exceptions.OutOfMapException;

import java.awt.*;

public class South extends Direction{
    public South() {
        name = "SOUTH";
    }

    @Override
    public void forward(double steps, GameRobot robot, GameMap2D map) {
        try {
            Point point = robot.getCurrentPoint();
            if ( (point.getY() - steps) < 0 )
                throw new OutOfMapException();
            point.setLocation(point.getX(), point.getY() - steps);
            robot.setCurrentPoint(point);
        } catch(OutOfMapException e){
            System.out.println(e.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
