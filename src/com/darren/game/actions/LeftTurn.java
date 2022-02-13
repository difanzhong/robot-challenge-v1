package com.darren.game.actions;

public class LeftTurn extends Action{
    private byte faceDirectionIndexAfterTurn;

    public LeftTurn(String actionName) {
        super.name = actionName;
    }

    @Override
    public void on() {
        try {
            printActionName();
            faceDirectionIndexAfterTurn = getFaceDirectionIndexAfterTurnLeft();
            Action.robot.setCurrentFacingDirectionIndex(faceDirectionIndexAfterTurn);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private byte getFaceDirectionIndexAfterTurnLeft() {
        /* directions are arranged in clockwise in array. eg.[N,E,S,W] */
        faceDirectionIndexAfterTurn = (byte) (Action.robot.getCurrentFacingDirectionIndex() - 1);
        return faceDirectionIndexAfterTurn < 0 ? (byte) (Action.map.getDirections().length - 1) : faceDirectionIndexAfterTurn;
    }
}
