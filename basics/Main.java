// package basics;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        int dogCount = 1;
        System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");

        int catCount = 2;
        System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");

        int turtleCount = 0;
        System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

        flipNHeads(3);
        clock();

    }

    public static String pluralize(String word, int count) {
        if (count == 1) {
            return word;
        }
        return word + "s";
    }

    public static void flipNHeads(int heads) {
        int trails = 0;
        int headsCount = 0;
        while (headsCount < heads) {
            trails++;
            if (Math.random() >= 0.5) {
                headsCount++;
                System.out.println("heads");
                continue;
            }
            System.out.println("tails");
            headsCount = 0;
        }
        System.out.println("It took " + trails + " flips to flip " + headsCount + " head in a row.");

    }

    public static void clock() {
        LocalDateTime now = LocalDateTime.now();
        int previous = now.getSecond();
        double cycle = 0;
        while (true) {

            if (previous != now.getSecond()) {
                System.out.println((now.getHour() < 10 ? "0" + now.getHour() : now.getHour()) + ":"
                        + (now.getMinute() < 10 ? "0" + now.getMinute() : now.getMinute()) + ":"
                        + (now.getSecond() < 10 ? "0" + now.getSecond() : now.getSecond()) + " " + cycle / 1_000_000
                        + " MHz");
                previous = now.getSecond();
                cycle = 0;
            }
            now = LocalDateTime.now();
            cycle++;

        }
    }
}
