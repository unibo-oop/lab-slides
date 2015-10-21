package it.unibo.oop.lab04.robot.arms;

import it.unibo.oop.lab04.robot.base.Robot;

/**
 * Models a generic robot with two
 * {@link it.unibo.oop.lab04.robot.arms.BasicArm}
 * 
 * @author Andrea Santi
 * @author Danilo Pianini
 *
 */
public interface RobotWithArms extends Robot {

    boolean pickUp();

    boolean dropDown();

    int getItemsCarried();

}