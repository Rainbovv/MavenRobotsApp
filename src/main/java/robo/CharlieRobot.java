package robo;

import interfaces.DiagonalMovableInterface;

public class CharlieRobot extends BetaRobot implements DiagonalMovableInterface {

    //////////////////  CONSTRUCTORS //////////////////
    protected CharlieRobot(String name, String model) {
        super(name, model);
    }


    //////////////////  MOVING METHODS  //////////////////
    public boolean moveDownRight(){
        if (checkCharge() && checkAxis("down") && checkAxis("right")) {
            setX(getX() + 1);
            setY(getY() + 1);
            checkMove();
            return true;
        }
        return false;
    }

    public boolean moveUpRight(){
        if (checkCharge() && checkAxis("up") && checkAxis("right")) {
            setX(getX() + 1);
            setY(getY() - 1);
            checkMove();
            return true;
        }
        return false;
    }

    public boolean moveDownLeft(){
        if (checkCharge() && checkAxis("down") && checkAxis("left")) {
            setX(getX() - 1);
            setY(getY() + 1);
            checkMove();
            return true;
        }
        return false;
    }

    public boolean moveUpLeft(){
        if (checkCharge() && checkAxis("up") && checkAxis("left")) {
            setX(getX() - 1);
            setY(getY() - 1);
            checkMove();
            return true;
        }
        return false;
    }
}
