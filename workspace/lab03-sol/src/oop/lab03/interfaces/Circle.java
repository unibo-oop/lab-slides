package oop.lab03.interfaces;

public class Circle implements IShape {

	private final double radius;

	public Circle(final double radius) {
		this.radius = radius;
	}

	public double getArea() {
		/*
		 * Math.pow() could be used, but is much slower, altough more precise.
		 */
		return Math.PI * this.radius * this.radius;
	}

	public double getPerimeter() {
		return 2 * Math.PI * this.radius;
	}
}