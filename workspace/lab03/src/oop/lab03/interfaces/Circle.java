package oop.lab03.interfaces;

public class Circle implements Shape {

    private double radius;

    public Circle(final double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double getPerimeter() {
        // TODO
        return 0;
    }
}