package assignment4_000875260;

public class Die {
    private int numberSides = 0;
    private int sideShowing = 1;

    public Die(int numberSides, int sideShowing) {
        this.numberSides = numberSides;
        this.sideShowing = sideShowing;
    }

    public int getSideShowing() {
        return sideShowing;
    }

    public int getNumberSides() {
        return numberSides;
    }

    public int rollDie() {   // it will return a number(sideShowing) from 1 to n (n = numberSides)
        int randomNum = (int) (Math.random() * numberSides + 1);
        this.sideShowing = randomNum;
        return randomNum;
    }

    @Override
    public String toString() {
        return "number of sides : " + numberSides + ", side showing: " + sideShowing;
    }
}
