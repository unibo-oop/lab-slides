package it.unibo.oop.lab08.ex04;

public interface DrawNumberView {

    void setObserver(DrawNumberViewObserver observer);

    void start();

    void numberIncorrect();

    void limitsReached();

    void result(DrawResult res);

}
