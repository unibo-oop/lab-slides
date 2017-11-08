package it.unibo.oop.lab.advanced;

/**
 * Possible outcomes of a guess.
 */
public enum DrawResult {

    /**
     * Low number.
     */
    YOURS_LOW("Your number is too low"),
    /**
     * High number.
     */
    YOURS_HIGH("Your number is too high"),
    /**
     * Correct attempt.
     */
    YOU_WON("You won"),
    /**
     * No attempts left.
     */
    YOU_LOST("You lost");

    private final String message;

    DrawResult(final String message) {
        this.message = message;
    }

    /**
     * @return a description of the draw result
     */
    public String getDescription() {
        return message;
    }
}
