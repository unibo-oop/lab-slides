public class Recognizer {
    int nextNum;
    boolean success;

    void build() {
        nextNum = 1;
        success = true;
    }

    boolean check1(int n) {
        nextNum = 2;
        if (n != 1) {
            success = false;
        }
        return success;
    }

    boolean check2(int n) {
        nextNum = 3;
        if (n != 2) {
            success = false;
        }
        return success;
    }

    boolean check3(int n) {
        nextNum = 4;
        if (n != 3) {
            success = false;
        }
        return success;
    }

    boolean check4(int n) {
        nextNum = 1;
        if (n != 4) {
            success = false;
        }
        return success;
    }

    void reset() {
        nextNum = 1;
        success = true;
    }

    int nextExpectedInt() {
        return nextNum;
    }
}
