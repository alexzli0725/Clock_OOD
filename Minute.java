public class Minute implements Clock {
    private int value;
    private Hour hour;

    public Minute(Hour hour) {
        this.hour = hour;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void reset() {
        this.value = 0;
    }

    @Override
    public void move() {
        value++;
        if (value == 60) {
            reset();
            hour.move();
        }

    }
}
