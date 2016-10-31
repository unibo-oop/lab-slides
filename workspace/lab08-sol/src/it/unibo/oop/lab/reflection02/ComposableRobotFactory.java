package it.unibo.oop.lab.reflection02;

import java.lang.reflect.Constructor;

/**
 *
 */
public final class ComposableRobotFactory {

    private ComposableRobotFactory() {
    }

    /**
     * 
     * @param robot
     *            robot
     * @param robotName
     *            name
     * @param batteryValue
     *            battery level
     * @return the created robot
     * @throws RobotException
     *             raised in case of trouble
     */
    public static SimpleComposableRobot createBasicComposableRobot(
            final BasicComposableRobots robot,
            final String robotName,
            final double batteryValue) throws RobotException {
        SimpleComposableRobot returnValue = null;
        Class<? extends SimpleComposableRobot> cl = null;
        final Class<?>[] constructorArgTypes = new Class<?>[] { String.class, Double.TYPE };
        Constructor<? extends SimpleComposableRobot> cons = null;
        try {
            switch (robot) {
            case WITH_HEAD:
                cl = SimpleComposableRobot.RobotWithHead.class;
                break;
            case WITH_TWO_ARMS:
                cl = SimpleComposableRobot.RobotWithTwoArms.class;
                break;
            case WITH_TWO_ARMS_AND_HEAD:
                cl = SimpleComposableRobot.RobotWithTwoArmsAndHead.class;
                break;
            default:
                throw new RobotException();
            }
            cons = cl.getConstructor(constructorArgTypes);
            returnValue = cons.newInstance(new Object[] { robotName, batteryValue });
        } catch (Exception ex) {
            throw new RobotException();
        }
        return returnValue;
    }
}