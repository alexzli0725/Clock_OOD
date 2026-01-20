class Second implements Clock {
    private int value;
    private Minute minute; // reference to the minute hand

    public Second(Minute minute) {
        this.minute = minute;
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
            minute.move(); // advance the minute
        }
    }
}