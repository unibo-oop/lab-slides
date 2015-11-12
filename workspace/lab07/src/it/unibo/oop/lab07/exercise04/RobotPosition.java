package it.unibo.oop.lab07.exercise04;

/**
 * Models a (x,y) position for a {@link it.unibo.oop.lab07.exercise04.Robot}.
 * 
 * @author Andrea Santi
 * @author Matteo Casadei
 *
 */
public class RobotPosition {

	private int x;
	private int y;
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public RobotPosition(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * 
	 * @return X position
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * 
	 * @param x
	 */
	public void setX(final int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return Y position
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * 
	 * @param y
	 */
	public void setY(final int y) {
		this.y = y;
	}	
}