package exercises1and2;

import java.util.Random;

class Robot2 extends Robot1 {

    private Random rand = new Random();

    private String[] sayings;

    void setSayings(String[] sayings) {
        this.sayings = sayings;
    }

    void speak() {
        int n = rand.nextInt(sayings.length);
        System.out.println(sayings[n]);
        }
    }
