public class Solution {

    public static void main(String[] arg) throws InterruptedException {
        Hour h = new Hour();
        Minute m = new Minute(h);
        Second s = new Second(m);

        // for (int i = 0; i < 86400; i++) {
        while (true) {
            s.move();
            Thread.sleep(1000); // wait 1 real second

            System.out.println(h.getValue() + ":" + m.getValue() + ":" + s.getValue());
        }
        // }

        // System.out.println(h.getValue() + ":" + m.getValue() + ":" + s.getValue());
    }
}
