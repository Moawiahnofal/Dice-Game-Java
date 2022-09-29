package assignment4_000875260;

public class DiceCollection {

    private int[] numberOfSidesArray;
    private Die[] dicesArray;

    // constructor receive an array of number of sides
    public DiceCollection(int[] numberOfSidesArray) {
        this.numberOfSidesArray = numberOfSidesArray;
        dicesArray = new Die[numberOfSidesArray.length];
        for (int i = 0; i < numberOfSidesArray.length; i++) {
            int numShowingRandom = (int) (Math.random() * numberOfSidesArray[i] + 1);   // create a random number for side showing
            Die die = new Die(numberOfSidesArray[i], numShowingRandom);
            dicesArray[i] = die;
        }
    }

    public Die[] getDicesArray() {
        return dicesArray;
    }

    // this method return the sum of numbers showing on all dice sides
    public int sumSides() {
        int sum = 0;
        for (int i = 0; i < dicesArray.length; i++) {
            sum = sum + dicesArray[i].getSideShowing();
        }
        return sum;
    }

    // this method return the minimum possible sum of numbers showing on all dice sides
    public int minimumSumSides() {
        return dicesArray.length;   // the min number of side showing = 1
    }

    /* this method return the maximum possible sum of numbers showing on all dice sides
     max number for every dice is equal to the number of sides the single dice have*/
    public int maximumSumSides() {
        int sum = 0;
        for (int i = 0; i < numberOfSidesArray.length; i++) {
            sum = sum + numberOfSidesArray[i];
        }
        return sum;
    }


    public int[] histogram(int numberRolls) {
        int[] histogram = new int[numberRolls];
        for (int i = 0; i < numberRolls; i++) {
            int sum = 0;
            for (int j = 0; j < dicesArray.length; j++) {
                dicesArray[j].rollDie();                       // roll the dice to get a random side number showing
                sum = sum + dicesArray[j].getSideShowing();   // add the sides showing for all the dice collection
            }
            histogram[sum] = histogram[sum] + 1;
        }
        return histogram;
    }


    @Override
    public String toString() {
        return "My dices = " + dicesArray
                + "- Sum of sides showing = " + sumSides()
                + "- Min number of sides showing = " + minimumSumSides()
                + "- Max number of sides showing = " + maximumSumSides();
    }

}
