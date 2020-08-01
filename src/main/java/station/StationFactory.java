package station;

import robo.RobotFactory;

public class StationFactory {

    private StationFactory(){};

    public ChargingStation getStation(int x, int y, int charge){
        return new ChargingStation(x , y, charge);
    }

    private static class SingletonHolder {
        private final static StationFactory INSTANCE = new StationFactory();
    }

    public static StationFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
