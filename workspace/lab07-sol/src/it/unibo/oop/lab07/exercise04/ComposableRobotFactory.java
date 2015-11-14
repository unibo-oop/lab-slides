package it.unibo.oop.lab07.exercise04;

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
    public static ComposableRobot createBasicComposableRobot(
            final BasicComposableRobots robot,
            final String robotName,
            final double batteryValue) throws RobotException {
        ComposableRobot returnValue = null;
        Class<? extends ComposableRobot> cl = null;
        final Class<?>[] constructorArgTypes = new Class<?>[] { String.class, Double.TYPE };
        Constructor<? extends ComposableRobot> cons = null;
        try {
            switch (robot) {
            case WITH_HEAD:
                cl = ComposableRobot.RobotWithHead.class;
                break;
            case WITH_TWO_ARMS:
                cl = ComposableRobot.RobotWithTwoArms.class;
                break;
            case WITH_TWO_ARMS_AND_HEAD:
                cl = ComposableRobot.RobotWithTwoArmsAndHead.class;
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