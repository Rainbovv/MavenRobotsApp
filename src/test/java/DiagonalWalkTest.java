import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import robo.CharlieRobot;
import robo.RobotFactory;

import static org.junit.jupiter.api.Assertions.*;

class DiagonalWalkTest {
	private CharlieRobot robot = (CharlieRobot)RobotFactory.getInstance()
															.getRobot("Charlie", "B124", 50, 50);


	@BeforeEach
	public void setCharge() {
		robot.setCharge(10);
	}

	/** Y cannot be more than 100 */
	@Test
	public void outOfBoundsMovingTest1() {
		robot.setY(100);

		assertFalse(robot.moveDownRight(), "Diagonal moving test failed\n" +
												   "REASON: moveDownRight() out of bounds!");
	}

	@Test
	public void outOfBoundsMovingTest2() {
		robot.setY(100);

		assertFalse(robot.moveDownLeft(), "Diagonal moving test failed\n" +
												  "REASON: moveDownLeft() out of bounds!");
	}

	/** Y cannot be less than 0 */
	@Test
	public void outOfBoundsMovingTest3() {
		robot.setY(0);

		assertFalse(robot.moveUpRight(), "Diagonal moving test failed\n" +
												 "REASON: moveUpRight() out of bounds!");
	}

	@Test
	public void outOfBoundsMovingTest4() {
		robot.setY(0);

		assertFalse(robot.moveUpLeft(), "Diagonal moving test failed\n" +
												"REASON: moveUpLeft() out of bounds!");
	}

	/** X cannot be more than 100 */
	@Test
	public void outOfBoundsMovingTest5() {
		robot.setX(100);

		assertFalse(robot.moveDownRight(), "Diagonal moving test failed\n" +
											       "REASON: moveDownRight() out of bounds!");
	}

	@Test
	public void outOfBoundsMovingTest6() {
		robot.setX(100);

		assertFalse(robot.moveUpRight(), "Diagonal moving test failed\n" +
							                     "REASON: moveUpRight() out of bounds!");
	}

	/** X cannot be less than 0 */
	@Test
	public void outOfBoundsMovingTest7() {
		robot.setX(0);

		assertFalse(robot.moveUpLeft(), "Diagonal moving test failed\n" +
									            "REASON: moveUpLeft() out of bounds!");
	}

	@Test
	public void outOfBoundsMovingTest8() {
		robot.setX(0);

		assertFalse(robot.moveDownLeft(), "Diagonal moving test failed\n" +
										          "REASON: moveDownLeft() out of bounds!");
	}

	/** Checking if robot is moving correctly */
	@Test
	public void moveDownLeftTest1() {
		while(robot.moveDownLeft());

		assertFalse(robot.getCharge() != 4 || robot.getX() != 38 || robot.getY() != 62,
					"Charge test failed\nREASON: The moving system should be calibrated!");
	}

	@Test
	public void moveUpLeftTest2() {
		while(robot.moveUpLeft());

		assertFalse(robot.getCharge() != 4 || robot.getX() != 38 || robot.getY() != 38,
					"Charge test failed\nREASON: The moving system should be calibrated!");
	}

	@Test
	public void moveDownRightTest3() {
		while(robot.moveDownRight());

		assertFalse(robot.getCharge() != 4 || robot.getX() != 62 || robot.getY() != 62,
					"Charge test failed\nREASON: The moving system should be calibrated!");
	}

	@Test
	public void moveUpRightTest4() {
		while(robot.moveUpRight());

		assertFalse(robot.getCharge() != 4 || robot.getX() != 62 || robot.getY() != 38,
					"Charge test failed\nREASON: The moving system should be calibrated!");
	}

}