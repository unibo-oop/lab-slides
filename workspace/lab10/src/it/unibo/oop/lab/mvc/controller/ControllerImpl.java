package it.unibo.oop.lab.mvc.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import it.unibo.oop.lab.mvc.model.Counter;
import it.unibo.oop.lab.mvc.view.CounterView;

/**
 * Reactive gui controller.
 *
 */
public class ControllerImpl implements CounterController {

    private final Counter counter;
    /*
     * Thread-safe!
     */
    private final Collection<CounterView> views = Collections.synchronizedCollection(new LinkedList<>());
    private Agent agent;

    /**
     * Construct a new controller.
     * 
     * @param counter
     *            the counter model
     */
    public ControllerImpl(final Counter counter) {
        this.counter = counter;
    }

    @Override
    public synchronized void start() {
        if (agent == null) {
            counter.reset();
            views.forEach(CounterView::init);
            this.agent = new Agent();
            this.agent.start();
        } else {
            throw new IllegalStateException();
        }
    }

    @Override
    public synchronized void stop() {
        if (agent == null) {
            throw new IllegalStateException();
        }
        views.forEach(CounterView::terminate);
        this.agent.stopCounting();
        try {
            this.agent.join();
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        agent = null;
    }

    @Override
    public void registerView(final CounterView view) {
        views.add(view);
    }

    private void updateViews() {
        final int value = counter.getValue();
        views.forEach(v -> v.update(value));
    }

    private class Agent extends Thread {
        private volatile boolean stop;
        public void run() {
            while (!this.stop) {
                try {
                    ControllerImpl.this.counter.increment();
                    updateViews();
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    throw new IllegalStateException("Counting has been interrupted", ex);
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
