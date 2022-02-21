package com.darren.game.directions;

import com.darren.game.GameMap2D;
import com.darren.game.GameRobot;
import com.darren.game.exceptions.OutOfMapException;

import java.awt.*;

public class West extends Direction{
    public West() {
        name = "WEST";
    }

    @Override
    public void forward(double steps, GameRobot robot, GameMap2D map) {
        try {
            Point point = robot.getCurrentPoint();
            if ( (point.getX() - steps) < 0 )
                throw new OutOfMapException();
            point.setLocation(point.getX() - steps, point.getY());
            robot.setCurrentPoint(point);
        } catch(OutOfMapException e){
            printInvalidMoveMessage();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
