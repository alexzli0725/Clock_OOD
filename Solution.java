import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static boolean sleep_continue(int h, int m, String did, Scanner timeInput, boolean isSleeping) {
        if (h >= 9 && m == 0) {

            System.out.println("It's time to wake up.");

            did = timeInput.nextLine();
            if (did.equals("wake up") || did.equals("wake")) {

                System.out.println("You're waking up.");
                return false;
            } else if (did.equals("sleep")) {
                System.out.println("You continue sleeping.");
            } else {
                System.out.println("Invalid command. Try again!");
                isSleeping = sleep_continue(h, m, did, timeInput, isSleeping);

            }
        }
        return isSleeping;
    }

    public static void repeat(int h, int m, int hNum, int mNum, Scanner timeInput, String did,
            String itsTime, String does, String yes, String no) {
        if (h == hNum && m == mNum) {

            System.out.println(itsTime);

            did = timeInput.nextLine();
            if (did.equals(does)) {
                System.out.println(yes);
            } else {
                System.out.println("Invalid command. Try again!");
                repeat(h, m, hNum, mNum, timeInput, did, itsTime, does, yes, no);
            }
        }
    }

    @SuppressWarnings("resource")
    public static void main(String[] arg) throws InterruptedException {
        Hour h = new Hour();
        Minute m = new Minute(h);

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

        String hString = parts[0];
        String mString = parts[1];
        // // String sString = parts[2];

        h.setValue(Integer.parseInt(hString));
        m.setValue(Integer.parseInt(mString));
        // // s.setValue(Integer.parseInt(sString));
        boolean isSleeping = true;

        while (true) {
            m.move();
            Thread.sleep(1000);
            // wait 1 real second
            Scanner timeInput = new Scanner(System.in);
            String did = null;
            System.out.println(h.getValue() + ":" + m.getValue() + "\r");

            if (isSleeping == true) {
                isSleeping = sleep_continue(h.getValue(), m.getValue(), did, timeInput, isSleeping);
                if (h.getValue() == 23 && m.getValue() == 59) {
                    System.out.println("You did nothing this whole day.");
                    return;
                }
            } else {
                repeat(h.getValue(),
                        m.getValue(),
                        9,
                        15,
                        timeInput,
                        did,
                        "You dog needs his breakfast.",
                        "feed dog",
                        "You're feeding your dog.",
                        "You're starving your dog.");
                repeat(h.getValue(),
                        m.getValue(),
                        10,
                        0,
                        timeInput,
                        did,
                        "It's time to read some news articles.",
                        "read news",
                        "You're reading news.",
                        "You're not reading news.");
                repeat(h.getValue(),
                        m.getValue(),
                        11,
                        0,
                        timeInput,
                        did,
                        "You have left over homework to do.",
                        "do homework",
                        "You're doing your homework.",
                        "You're postponing your homework.");
                repeat(h.getValue(),
                        m.getValue(),
                        13,
                        0,
                        timeInput,
                        did,
                        "Your dog needs to be walked.",
                        "walk dog",
                        "You're walking your dog.",
                        "You're letting your dog stay still.");
                repeat(h.getValue(),
                        m.getValue(),
                        15,
                        0,
                        timeInput,
                        did,
                        "It's time to hit the driving range.",
                        "play golf",
                        "You're practicing golf.",
                        "You're skipping practice.");
                repeat(h.getValue(),
                        m.getValue(),
                        17,
                        0,
                        timeInput,
                        did,
                        "Your car needs to increase its mileage.",
                        "drive car",
                        "You're driving your car",
                        "Your car stays parked.");
                repeat(h.getValue(),
                        m.getValue(),
                        21,
                        0,
                        timeInput,
                        did,
                        "It's time to apply for jobs.",
                        "apply for jobs",
                        "You're submitting resume.",
                        "You're not applying today.");
                repeat(h.getValue(),
                        m.getValue(),
                        22,
                        0,
                        timeInput,
                        did,
                        "It's time to practice leetcode questions.",
                        "practice leetcode",
                        "You're practicing leetcode.",
                        "You're skipping leetcode.");
                if (h.getValue() == 23 && m.getValue() == 59) {
                    System.out.println("You've done () today.");
                    return;
                }
            }
        }
    }
}
