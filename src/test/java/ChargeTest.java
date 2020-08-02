import org.junit.jupiter.api.Test;
import robo.BetaRobot;
import robo.RobotFactory;

import static org.junit.jupiter.api.Assertions.*;

class ChargeTest {

	private BetaRobot robot = (BetaRobot)RobotFactory.getInstance().getRobot("Beta", "B123");

	@Test
	public void negativeChargeTest() {
		robot.setCharge(-100);
		assertFalse(robot.getCharge() < 0,"Charge test failed\nREASON: Values les than 0 not allowed!");
	}

	@Test
	public void chargeOverflowTest(){
		robot.setCharge(1000);
		assertFalse(robot.getCharge() > 100,"Charge test failed\nREASON: Values more than 0 not allowed!");
	}

	@Test
	public void batteryDischargingInMoving() {
		robot.setCharge(50);
		while(robot.moveRight());
		assertFalse(robot.getCharge() != 4 || robot.getX() != 92,"Charge test failed\n" +
			    						 "REASON: The moving system should be calibrated!" ) ;
	}
}
