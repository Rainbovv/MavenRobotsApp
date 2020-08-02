import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import robo.AlphaRobot;
import robo.RobotFactory;

import static org.junit.jupiter.api.Assertions.*;

class SimpleJunitTest {

    private AlphaRobot robot;

    @BeforeEach
    public void setUp() {
        robot = (AlphaRobot)RobotFactory.getInstance()
                                        .getRobot("Alpha", "R2D2");
    }


    /** name cannot be null */
    @Test
    public void setNullNameTest() {
        robot.setName(null);

        assertNotEquals(null, robot.getName(),"Name test failed\n" +
                                              "REASON: null name not allowed!" );
    }

    /** model cannot be null */
    @Test
    public void setNullModelTest() {
        robot.setModel(null);

        assertNotEquals(null, robot.getModel(),"Model test failed\n" +
                                               "REASON: null model not allowed!");
    }


    /** X cannot be outside 0..100 */
    @Test
    public void X_setOutOfBoundsNegativeTest() {
        robot.setX(-100);

        assertFalse(robot.getX() < 0,"X coord test failed\n" +
                                      "REASON: Values less than 0 not allowed!" );
    }

    @Test
    public void X_setOutOfBoundsPositiveTest() {
        robot.setX(1000);

        assertFalse(robot.getX() > 100,"X coord test failed\n" +
                                       "REASON: Values more than 100 not allowed!" );
    }

    /** Y cannot be outside 0..100 */
    @Test
    public void Y_setOutOfBoundsNegativeTest() {
        robot.setY(-100);

        assertFalse(robot.getY() < 0,"Y coord test failed\n" +
                                     "REASON: Values less than 0 not allowed!" );
    }

    @Test
    public void Y_setOutOfBoundsPositiveTest() {
        robot.setY(1000);

        assertFalse(robot.getY() > 100,"Y coord test failed\n" +
                                       "REASON: Values more than 100 not allowed!" );
    }

    /** MOVEMENT */

    @Test
    public void X_movingOutOfBoundsNegativeTest() {
        robot.setX(0);

        assertFalse(robot.moveLeft(),"Move test failed\n" +
                                     "REASON: moveLeft() out of bounds!");
    }

    @Test
    public void X_movingOutOfBoundsPositiveTest() {
        robot.setX(100);

        assertFalse(robot.moveRight(),"Move test failed\n" +
                                      "REASON: moveRight() out of bounds!");
    }

    @Test
    public void Y_movingOutOfBoundsNegativeTest() {
        robot.setY(0);

        assertFalse(robot.moveUp(),"Move test failed\n" +
                                   "REASON: moveUp() out of bounds!");
    }

    @Test
    public void Y_movingOutOfBoundsPositiveTest() {
        robot.setY(100);

        assertFalse(robot.moveDown(),"Move test failed\n" +
                                     "REASON: moveDown() out of bounds!");
    }
}
