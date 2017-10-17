package exercises1and2;

class Robot1 {

    private double batteryCharge = 5.0;

    void batteryReCharge(double c) {
        this.batteryCharge += c;
        System.out.println("Battery charge is: " + batteryCharge);
    }

    void move(int distance) {
        for (int i = 1; i <= distance; i++) {
            if (batteryCharge >= 0.5) {
                this.batteryCharge -= 0.5;
                System.out.print(i + " ");
            } else {
                System.out.println("Out of power!");
            }
        }
    }

}