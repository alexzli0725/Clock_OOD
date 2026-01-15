public class Minute implements Clock {
    private int value;

    public int getValue() {
        return value % 60;
    }

    @Override
    public void reset() {
        this.value = 0;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void move() {
        System.out.println("Minute hand moved");

        this.value++;

    }
}
