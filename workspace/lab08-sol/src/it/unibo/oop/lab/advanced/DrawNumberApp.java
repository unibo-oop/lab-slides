package it.unibo.oop.lab.advanced;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 */
public final class DrawNumberApp implements DrawNumberViewObserver {

    private static final int MIN = 0;
    private static final int MAX = 100;
    private static final int ATTEMPTS = 10;
    private static final int MIN_IDX = 0;
    private static final int MAX_IDX = 1;
    private static final int ATTEMPTS_IDX = 2;
    private final DrawNumber model;
    private final List<DrawNumberView> views;

    /**
     * @param configFile
     *            the configuration file path
     * @param views
     *            the views to attach
     */
    public DrawNumberApp(final String configFile, final DrawNumberView... views) {
        /*
         * Side-effect proof
         */
        this.views = Arrays.asList(Arrays.copyOf(views, views.length));
        int[] config = new int[3];
        try {
            for (final String configLine: Files.readAllLines(Paths.get(configFile))) {
                final String[] lineElements = configLine.split(":");
                if (lineElements.length == 2) {
                    if (lineElements[0].contains("max")) {
                        config[MAX_IDX] = Integer.parseInt(lineElements[1].trim());
                    } else if (lineElements[0].contains("min")) {
                        config[MIN_IDX] = Integer.parseInt(lineElements[1].trim());
                    } else if (lineElements[0].contains("attempts")) {
                        config[ATTEMPTS_IDX] = Integer.parseInt(lineElements[1].trim());
                    }
                } else {
                    configError(config);
                }
            }
        } catch (IOException | NumberFormatException e) {
            configError(config);
        }
        if (configIsInconsistent(config)) {
            displayError("Inconsistent configuration: "
                    + "min: " + config[MIN_IDX] + ", "
                    + "max: " + config[MAX_IDX] + ", "
                    + "attempts: " + config[ATTEMPTS_IDX] + ".");
            defaultConfig(config);
        }
        this.model = new DrawNumberImpl(config[MIN_IDX], config[MAX_IDX], config[ATTEMPTS_IDX]);
        for (final DrawNumberView view: views) {
            view.setObserver(this);
            view.start();
        }
    }

    private boolean configIsInconsistent(final int[] config) {
        return config[ATTEMPTS_IDX] < 0 || config[MIN_IDX] > config[MAX_IDX];
    }

    private void defaultConfig(final int[] conf) {
        conf[MIN_IDX] = MIN;
        conf[MAX_IDX] = MAX;
        conf[ATTEMPTS_IDX] = ATTEMPTS;
    }

    private void configError(final int[] config) {
        defaultConfig(config);
        displayError("Unable to load configuration. Reverting to defaults ("
                + "min: " + MIN + ", "
                + "max: " + MAX + ", "
                + "attempts: " + ATTEMPTS + ")");
    }

    private void displayError(final String err) {
        for (final DrawNumberView view: views) {
            view.displayError(err);
        }
    }

    @Override
    public void newAttempt(final int n) {
        try {
            final DrawResult result = model.attempt(n);
            for (final DrawNumberView view: views) {
                view.result(result);
            }
        } catch (IllegalArgumentException e) {
            for (final DrawNumberView view: views) {
                view.numberIncorrect();
            }
        }
    }

    @Override
    public void resetGame() {
        this.model.reset();
    }

    @Override
    public void quit() {
        System.exit(0);
    }

    /**
     * @param args
     *            ignored
     * @throws FileNotFoundException 
     */
    public static void main(final String... args) throws FileNotFoundException {
        new DrawNumberApp("res/config.yml",
                new DrawNumberViewImpl(),
                new DrawNumberViewImpl(),
                new PrintStreamView(System.out),
                new PrintStreamView("output.log"));
    }

}
