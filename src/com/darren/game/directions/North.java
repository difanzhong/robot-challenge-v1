package com.darren.game.directions;

import com.darren.game.GameMap2D;
import com.darren.game.GameRobot;
import com.darren.game.exceptions.OutOfMapException;

import java.awt.*;

public class North extends Direction{
    public North() {
        name = "NORTH";
    }

    @Override
    public void forward(double steps, GameRobot robot, GameMap2D map) {
        try {
            Point point = robot.getCurrentPoint();
            if ((point.getY() + steps) > map.getMaxY())
                throw new OutOfMapException();
            point.setLocation(point.getX(), point.getY() + steps);
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
