package it.unibo.oop.rguis.mvc.controller;

import it.unibo.oop.rguis.mvc.model.Counter;
import it.unibo.oop.rguis.mvc.view.CounterView;
import it.unibo.oop.rguis.mvc.view.CounterViewObserver;

/**
 * Reactive gui controller.
 *
 */
public class Controller {

    private final Counter counter;
    private final CounterView view;
    private Agent agent;

    /**
     * Construct a new controller.
     * 
     * @param counter
     *            the counter model
     * @param view
     *            the view
     */
    public Controller(final Counter counter, final CounterView view) {
        this.counter = counter;
        this.view = view;
        this.view.addCounterViewObserver(new CounterViewObserver() {
            @Override
            public void stop() {
                if (agent != null) {
                    agent.stopCounting();
                }
            }
        });
        view.initView();
    }

    /**
     * Starts counting when invoked.
     */
    public void start() {
        if (agent != null) {
            throw new IllegalStateException();
        }
        this.agent = this.new Agent();
        new Thread(this.agent).start();
    }

    private class Agent implements Runnable {

        // stop viene modificato "da fuori": sia volatile!!
        private volatile boolean stop;

        /**
         * Behavior of thread.
         */
        public void run() {
            while (!this.stop) {
                try {
                    Controller.this.view.updateCounter(Controller.this.counter.getValue());
                    Controller.this.counter.increment();
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    System.out.println("Counting has been interrupted " + ex);
                }
            }
        }

        /**
         * External command to stop counting.
         */
        public void stopCounting() {
            this.stop = true;
        }
    }
}
