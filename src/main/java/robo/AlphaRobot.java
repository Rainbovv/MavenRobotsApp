package robo;

import interfaces.Has2DCoordinatesInterface;
import interfaces.Movable2DInterface;

public class AlphaRobot extends AbstractRobot implements Has2DCoordinatesInterface, Movable2DInterface {

    // Properties
    private String name;
    private String model;
    private int x;
    private int y;


    //////////////////  CONSTRUCTORS  //////////////////
    protected AlphaRobot(){}

    protected AlphaRobot(String name, String model) {
        setName(name);
        setModel(model);
        setX(0);
        setY(0);
    }


    //////////////////  SETTERS  //////////////////
    public void setName(String name) {
        if (name == null) printNameModelErr("Name");
        else this.name = name;
    }

    public void setModel(String model) {
        if (model == null) printNameModelErr("Model");
        else this.model = model;
    }

    public void setX(int x) {
        if (x < 0 || x > 100) printCoordsErr("x");
        else this.x = x;
    }

    public void setY(int y) {
        if (y < 0 || y > 100) printCoordsErr("y");
        else this.y = y;
    }

    public void setCharge(int charge) {}

    
    //////////////////  GETTERS  //////////////////
    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public byte getCharge() {
        return 0;
    }


    //////////////////  MOVING METHODS  //////////////////
    public boolean moveRight() {
        if (checkAxis("right")) {setX(getX() + 1); return true;}
        return false;
    }

    public boolean moveLeft() {
        if (checkAxis("left")) {setX(getX() - 1); return true;}
        return false;
    }

    public boolean moveDown() {
        if (checkAxis("down")) {setY(getY() + 1); return true;}
        return false;
    }

    public boolean moveUp() {
        if (checkAxis("up")) {setY(getY() - 1); return true;}
        return false;
    }


    protected boolean checkAxis(String direction){
        switch(direction){
            case "down":
                if (y < 100) return true;
                printMovingErr(direction); return false;
            
            case "up":
                if (y > 0) return true;
                printMovingErr(direction); return false;
            
            case "right":
                if (x < 100) return true;
                printMovingErr(direction); return false;
            
            case "left":
                if (x > 0) return true;
                printMovingErr(direction); return false;
            
            default:
                return false;
        }
    }

    // Errors
    public void printNameModelErr(String property) {
        System.err.println("You cannot use null for the property \"" + property +
                           "\"! Please use a valid value!");
    }

    public void printCoordsErr(String axis){
        System.err.println("You cannot use this coordinate on the " + axis +
                           "-axis! Please use one from the range [0 - 100]");
    }

    public void printMovingErr(String direction) {
        System.err.println("The robot cannot move " + direction + "! It's on the boundary!");
    }
}
