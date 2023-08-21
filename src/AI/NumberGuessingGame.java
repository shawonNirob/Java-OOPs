package AI;

import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I've selected a random number between " + minRange + " and " + maxRange + ".");
        System.out.println("Try to guess the number.");

        int attempts = 0;
        int guess = -1;

        while (guess != targetNumber) {
            int mid = minRange + (maxRange - minRange) / 2;

            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess == targetNumber) {
                System.out.println("Congratulations! You've guessed the number " + targetNumber +
                        " in " + attempts + " attempts.");
                break;
            } else if (guess > targetNumber) {
                System.out.println("Too high! Try a lower number.");
                maxRange = mid - 1;
            } else {
                System.out.println("Too low! Try a higher number.");
                minRange = mid + 1;
            }
        }
        scanner.close();
    }
}
