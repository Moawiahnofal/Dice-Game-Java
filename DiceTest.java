package assignment4_000875260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* @author Moawial Nofal - 000875260 */

public class DiceTest {

    public static void main(String[] args) throws IOException {
        // get number of dices from the user.
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many dice? ");
        int numberOfDice = scanner.nextInt();

        // used BufferedReader to get input from the user separated by spaces - get number of sides
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfSidesArray[] = new int[numberOfDice];
        String[] strNumberOfSides;
        System.out.print("Enter the number of sides of each die: ");
        // convert string input into array of string
        strNumberOfSides = bufferedReader.readLine().split(" ");
        for (int i = 0; i < strNumberOfSides.length; i++) {
            numberOfSidesArray[i] = Integer.parseInt(strNumberOfSides[i]);
        }


        System.out.println();

        // Create assignment4_000875260.DiceCollection object - create array of assignment4_000875260.DiceCollection
        DiceCollection diceCollection = new DiceCollection(numberOfSidesArray);
        Die[] evaluatedDiceArray = diceCollection.getDicesArray();
        String[] outputDices = new String[numberOfSidesArray.length];     // create a new array for the output
        for (int i = 0; i < evaluatedDiceArray.length; i++) {
            outputDices[i] = "d" + evaluatedDiceArray[i].getNumberSides() + "=" + evaluatedDiceArray[i].getSideShowing();
        }


        boolean loopExit = true;   // variable to exit the while loop when set to false.
        while (loopExit) {
            // print output of the current dice collection
            System.out.print("Dice collection: ");
            for (int i = 0; i < evaluatedDiceArray.length; i++) {
                outputDices[i] = "d" + evaluatedDiceArray[i].getNumberSides() + "=" + evaluatedDiceArray[i].getSideShowing();
                System.out.print(outputDices[i] + " ");
            }

            System.out.println();
            System.out.println("Min= " + diceCollection.minimumSumSides()
                    + "  Max= " + diceCollection.maximumSumSides()
                    + "  Current= " + diceCollection.sumSides());

            System.out.println();
            System.out.print("1=roll once, 2=roll 100000 times, 3=quit: ");

            int userChoice = scanner.nextInt();
            System.out.println();
            switch (userChoice) {
                case 1:   // roll once
                    for (int i = 0; i < evaluatedDiceArray.length; i++) {
                        evaluatedDiceArray[i].rollDie();
                    }
                    break;
                case 2:   // roll 1000 time
                    int[] histogram = diceCollection.histogram(100000);
                    for (int i = 5; i < 20; i++) {
                        System.out.println(i + ": " + histogram[i]);
                    }
                    System.out.println();
                    break;
                case 3:   //exit
                    System.out.print("Bye!!");
                    loopExit = false;
                    break;
            }
        }
    }
}
