package robo;


import interfaces.HasBatteryInterface;

public class BetaRobot extends AlphaRobot implements HasBatteryInterface {

    // Properties
    protected byte charge;
    protected byte moves = 0;


    //////////////////  CONSTRUCTORS //////////////////
    protected BetaRobot(String name, String model) {
        super(name, model);
        setCharge(0);
    }


    //////////////////  SETTERS  //////////////////
    public void setCharge(int charge) {
        if (charge < 0 || charge > 100) printBatteryVolumeErr();

        else this.charge = (byte)charge;
    }


    //////////////////  GETTERS  //////////////////
    public byte getCharge() {
        return charge;
    }


    //////////////////  MOVING METHODS  //////////////////
    public boolean moveRight() {
        if (checkCharge() && super.moveRight()) {
            checkMove();
            return true;
        }
        return false;
    }

    public boolean moveLeft() {
        if (checkCharge() && super.moveLeft()) {
            checkMove();
            return true;
        }
        return false;
    }

    public boolean moveDown() {
        if (checkCharge() && super.moveDown()) {
            checkMove();
            return true;
        }
        return false;
    }

    public boolean moveUp() {
        if (checkCharge() && super.moveUp()) {
            checkMove();
            return true;
        }
        return false;
    }


    protected void checkMove(){
        if (moves != 0 && moves % 2 != 0) {
            charge -= 1;
        }
        moves++;
    }

    protected boolean checkCharge(){
        if (charge < 5) {
            printLowBattery();
            return false;
        }
        return true;
    }


    // Errors
    public void printMovingErr(String direction) {
        System.err.println("The robot cannot move " + direction + "! It's on the boundary!");
    }

    public void printLowBattery(){
        System.err.println("Low battery! Please charge up the robot!");
    }

    public void printBatteryVolumeErr() {
        System.err.println("You have used a non valid value! " +
                           "Use on from the range - [0 - 100]");
    }
}
