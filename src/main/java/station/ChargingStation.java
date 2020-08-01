package station;

import interfaces.*;

public class ChargingStation implements Has2DCoordinatesInterface, HasBatteryInterface {

    // Properties
    private int x;
    private int y;
    private byte charge;
    private byte chargeDivider = 0;

    protected ChargingStation(int x, int y, int charge){
        setX(x);
        setY(y);
        setCharge(charge);
    }

    //////////////////  SETTERS  //////////////////
    public void setX(int x) {
        if (x < 0 || x > 100) printCoordsErr("x");
        else this.x = x;
    }

    public void setY(int y) {
        if (y < 0 || y > 100) printCoordsErr("y");
        else this.y = y;
    }

    public void setCharge(int charge) {
        if (charge < 0 || charge > 100) printBatteryVolumeErr();
        else this.charge = (byte)charge;
    }


    //////////////////  GETTERS  //////////////////
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public byte getCharge() {
        return charge;
    }


    //////////////////  CHARGE METHODS  //////////////////
    public boolean charge(HasBatteryInterface chargeable){
        if (checkCoords((Has2DCoordinatesInterface)chargeable) && checkCharge() && checkObjectsCharge(chargeable)){

            while (chargeable.getCharge() < 100) {
                chargeable.setCharge(chargeable.getCharge() + 1); 
                divideCharge();
            }
            return true;
        }
        return false;
    }

    private boolean checkCharge(){
        if (charge < 5) {
            printLowBattery();
            return false;
        }
        return true;
    }

    private boolean checkCoords(Has2DCoordinatesInterface chargeable){
        if ( chargeable.getX() != this.getX() || chargeable.getY() != this.getY()){
            printChargingCoordsErr();
            return false;
        }
        return true;
    }

    private boolean checkObjectsCharge(HasBatteryInterface chargeable) {
        if (chargeable.getCharge() == 100){
            printFullBattery();
            return false;
        }
        return true;
    }

    private void divideCharge(){
        chargeDivider++;
        if (chargeDivider % 10 == 0){
            charge -= 1;}
    }

    // Errors
    public void printLowBattery(){
        System.err.println("Low battery! Please charge up the station!");
    }

    public void printChargingCoordsErr(){
        System.err.println("The object is not on the same coordinates as station");
    }

    public void printFullBattery(){
        System.err.println("The chargeable battery is full");
    }

    public void printBatteryVolumeErr() {
        System.err.println("You have used a non valid value! " +
                           "Use on from the range - [0 - 100]");
    }

    public void printCoordsErr(String axis){
        System.err.println("You cannot use this coordinate on the " + axis +
                           "-axis! Please use one from the range [0 - 100]");
    }
}
