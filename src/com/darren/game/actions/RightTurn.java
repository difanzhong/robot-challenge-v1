package com.darren.game.actions;

public class RightTurn extends Action{
    private byte faceDirectionIndexAfterTurn;

    public RightTurn(String actionName) {
        super.name = actionName;
    }

    @Override
    public void on() {
        try {
            printActionName();
            faceDirectionIndexAfterTurn = getFaceDirectionIndexAfterTurnRight();
            Action.robot.setCurrentFacingDirectionIndex(faceDirectionIndexAfterTurn);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private byte getFaceDirectionIndexAfterTurnRight() {
        /* directions are arranged in clockwise in array. eg.[N,E,S,W] */
        faceDirectionIndexAfterTurn = (byte) (Action.robot.getCurrentFacingDirectionIndex() + 1);
        return faceDirectionIndexAfterTurn >= Action.map.getDirections().length ? 0 : faceDirectionIndexAfterTurn;
    }
}
