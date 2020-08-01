package main;

import robo.*;
import station.ChargingStation;
import station.StationFactory;

import java.util.ArrayList;


public class Application {
    public static void main(String[] args){

        AbstractRobot robot = RobotFactory.getInstance().getRobot("Beta", "R2D2");

        ChargingStation station = StationFactory.getInstance().getStation(0,0,0);

        AbstractRobot vasilii = RobotFactory.getInstance().getRobot("Charlie","Vasilii");

        System.out.println(station);
        System.out.println(robot);
        System.out.println(vasilii);


    }

}