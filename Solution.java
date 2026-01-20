import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] arg) throws InterruptedException {
        Hour h = new Hour();
        Minute m = new Minute(h);
        Second s = new Second(m);

        LocalTime myObj = LocalTime.now();
        String nowString = myObj.toString();
        // System.out.println(nowString);

        int i;
        int j = 0;
        String[] parts = new String[3];
        int times = 0;

        for (i = 0; i < nowString.length(); i++) {

            if (nowString.charAt(i) == ':') {
                // parts.add(nowString.substring(j, i));
                parts[times] = nowString.substring(j, i);
                j = i + 1;
                times++;
            }
            if (nowString.charAt(i) == '.') {
                parts[times] = nowString.substring(j, i);
                break;
            }
        }
        String hString = parts[0];
        String mString = parts[1];
        String sString = parts[2];

        h.setValue(Integer.parseInt(hString));
        m.setValue(Integer.parseInt(mString));
        s.setValue(Integer.parseInt(sString));

        for (int k = 0; k < 86400; k++) {
            while (true) {
                s.move();
                Thread.sleep(1000); // wait 1 real second

                System.out.println(h.getValue() + ":" + m.getValue() + ":" + s.getValue());
            }
        }

    }
}
