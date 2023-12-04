package com.ilkhamjumatov;

import com.ilkhamjumatov.entities.GameObject;
import com.ilkhamjumatov.entities.Paper;
import com.ilkhamjumatov.entities.Rock;
import com.ilkhamjumatov.entities.Scissors;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private final Scanner scanner = new Scanner(System.in);
    private final GameObject[] gameObjects = {new Rock(), new Paper(), new Scissors()};

    public void run() {
        startGameLoop();
    }

    public void startGameLoop(){

        for (int i = 0; i < 3; i++) {

            String userChoice;

            do {
                userChoice = getUserInput();

            } while (!isValid(userChoice));

            GameObject botChoiceObj = getRandomObjectForBot();
            GameObject userChoiceObj = gameObjects[Integer.parseInt(userChoice) - 1];

            int result = userChoiceObj.compareTo(botChoiceObj);

            if (result > 0) {
                System.out.println("You won");
            } else if (result < 0) {
                System.out.println("Bot won");
            } else {
                System.out.println("Draw");
            }

        }

        // print who won after each round
        //
        // after the loop ended check overall game state and print

    }

    private GameObject getRandomObjectForBot() {

        Random random = new Random();

        GameObject randomObj = gameObjects[random.nextInt(3)];
        System.out.println("Bot chose: " + randomObj);

        return randomObj;
    }

    private boolean isValid(String userChoice) {

        try {
            int userChoiceInt = Integer.parseInt(userChoice);

            if (userChoiceInt < 0 || userChoiceInt > 3) {
                throw new IncorrectUserInputException("Please enter only values between 1 and 3.");
            }

            System.out.println("You chose: " + gameObjects[userChoiceInt - 1]);
            return true;

        } catch (IncorrectUserInputException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please enter only numbers and in the specified range.");
        }

        return false;

    }

    private String getUserInput() {

        System.out.println("""
                Choose and object:
                1. Rock
                2. Paper
                3. Scissors""");

        String userInput = scanner.next();

        return userInput;
    }
}
