public class Solution {

    public static void main(String[] arg) {
        Hour h = new Hour();
        Minute m = new Minute(h);
        Second s = new Second(m);

        for (int i = 0; i < 86400; i++) {
            s.move();
        }

        System.out.println(h.getValue() + ":" + m.getValue() + ":" + s.getValue());
    }
}
