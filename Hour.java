public class Hour implements Clock {
    private int value;

    public int getValue() {
        return value;
    }

    @Override
    public void reset() {
        this.value = 0;
    }

    @Override
    public void move() {
        value++;
        if (value == 24) {
            reset();
        }
    }
}
