import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] arg) throws InterruptedException {
        Hour h = new Hour();
        Minute m = new Minute(h);
        Second s = new Second(m);

        LocalTime myObj = LocalTime.now();
        // String nowString = myObj.toString();
        // // System.out.println(nowString);

        int i;
        int j = 0;
        String[] parts = new String[2];
        int times = 0;

        Scanner userInput = new Scanner(System.in);
        System.out.println("enter hour and minute");
        String next = userInput.nextLine();

        for (i = 0; i < next.length(); i++) {

            if (next.charAt(i) == ':') {
                parts[times] = next.substring(j, i);
                j = i + 1;
                times++;
            }
        }
        parts[times] = next.substring(j, i);

        for (String n : parts) {
            if ((Integer.parseInt(parts[0]) < 0 ||
                    Integer.parseInt(parts[0]) > 23) ||
                    (Integer.parseInt(parts[1]) < 0 ||
                            Integer.parseInt(parts[1]) > 59)) {
                System.err.println("Invalid time");
                return;
            } else {
                System.out.println(n);
            }

        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime colonTime = LocalTime.of(17, 35);
        // System.out.println(formatter.format(colonTime));

        // LocalDate parsedDate = LocalDate.parse(nowString);

        // int i;
        // int j = 0;
        // String[] parts = new String[2];
        // int times = 0;

        // for (i = 0; i < nowString.length(); i++) {

        // if (nowString.charAt(i) == ':') {
        // // parts.add(nowString.substring(j, i));
        // parts[times] = nowString.substring(j, i);
        // j = i + 1;
        // times++;
        // }
        // if (nowString.charAt(i) == '.') {
        // parts[times] = nowString.substring(j, i);
        // break;
        // }
        // }
        String hString = parts[0];
        String mString = parts[1];
        // // String sString = parts[2];

        h.setValue(Integer.parseInt(hString));
        m.setValue(Integer.parseInt(mString));
        // // s.setValue(Integer.parseInt(sString));

        for (int k = 0; k < 1400; k++) {
            while (true) {
                m.move();
                Thread.sleep(1000);
                // wait 1 real second
                Scanner timeInput = new Scanner(System.in);
                String did;
                System.out.println(h.getValue() + ":" + m.getValue() + "\r");
                if (h.getValue() == 9 && m.getValue() == 0) {

                    System.out.println("It's time to wake up.");

                    did = timeInput.nextLine();
                    if (did.equals("wake up") || did.equals("wake")) {
                        System.out.println("You're waking up");
                    } else {
                        System.out.println("You continue sleeping");
                    }
                } else if (h.getValue() == 12 && m.getValue() == 0) {

                    System.out.println("You have left over homework to do.");

                    did = timeInput.nextLine();
                    if (did.equals("do homework")) {
                        System.out.println("You're doing your homework.");
                    } else {
                        System.out.println("You're postponing your homework.");
                    }
                } else if (h.getValue() == 13 && m.getValue() == 0) {
                    System.out.println("Your dog needs to be walked.");
                    did = timeInput.nextLine();
                    if (did.equals("walk my dog")) {
                        System.out.println("You're walking your dog");
                    } else {
                        System.out.println("You're not walking your dog");
                    }

                } else if (h.getValue() == 3 && m.getValue() == 0) {
                    System.out.println("It's time to hit the driving range");
                    did = timeInput.nextLine();
                    if (did.equals("play golf")) {
                        System.out.println("You're practicing golf");
                    } else {
                        System.out.println("You're skipping practice");
                    }
                }
            }

        }

    }
}
