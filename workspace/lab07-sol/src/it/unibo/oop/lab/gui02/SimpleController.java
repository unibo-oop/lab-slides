package it.unibo.oop.lab.gui02;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *
 */
public class SimpleController implements Controller {

    private final List<String> stringHistory;
    private String nextString;

    /**
     * 
     */
    public SimpleController() {
        stringHistory = new ArrayList<>();
        nextString = "";
    }

    @Override
    public void setNextStringToPrint(final String nextString) {
        this.nextString = nextString;
    }

    @Override
    public String getNextStringToPrint() {
        return this.nextString;
    }

    @Override
    public List<String> getPrintedStringsHistory() {
        return stringHistory;
    }

    @Override
    public void printCurrentString() {
        stringHistory.add(this.nextString);
        System.out.println(this.nextString);
    }

}
