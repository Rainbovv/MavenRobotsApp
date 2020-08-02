import org.junit.jupiter.api.Test;
import robo.BetaRobot;
import robo.RobotFactory;
import station.ChargingStation;
import station.StationFactory;

import static org.junit.jupiter.api.Assertions.*;

class ChargingFromStationTest {

	private BetaRobot robot = (BetaRobot)RobotFactory.getInstance()
							 .getRobot("Beta", "B124", 10, 10);

	private ChargingStation station = StationFactory.getInstance()
							.getStation(10,10,100);


	/** The robot cannot be charged if it's on the different coords from station */
	@Test
	public void chargingOnDifferentCoordsTest() {
		robot.setX(20);
		robot.setY(20);

		assertFalse(station.charge(robot), "Charging from station test failed\n" +
						   "REASON: The station is charging " +
						   "an object from another coordinates");
	}

	/** Checking if the station charge correctly*/
	@Test
	public void correctChargingTest() {
		robot.setCharge(50);

		assertFalse(!station.charge(robot) || station.getCharge() != 95 || robot.getCharge() != 100, 
			    "Charging from station test failed\nREASON: The station doesn't charge correctly.");
	}

	/** The station cannot not charge the robot more than 100% */
	@Test
	public void chargingOverflowTest() {
		robot.setCharge(100);

		assertFalse(station.charge(robot), "Charging from station test failed\n" +
						   "REASON: The station is charging an"+
						   "object with a full battery");
	}

}
