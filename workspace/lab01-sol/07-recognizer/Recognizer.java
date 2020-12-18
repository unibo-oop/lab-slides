class Recognizer {
    int nextNum;
    boolean success;

    void build() {
        nextNum = 1;
        success = true;
    }

    boolean check1(int n) {
        return check(n, 2);
    }

    boolean check2(int n) {
        return check(n, 3);
    }

    boolean check3(int n) {
        return check(n, 4);
    }

    boolean check4(int n) {
        return check(n, 1);
    }

    boolean check(int actual, int next) {
        if (actual != this.nextNum) {
            success = false;
        }
        this.nextNum = next;
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
