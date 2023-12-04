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

    public void startGameLoop() {

        int overallResult = 0;

        System.out.println("""
                Welcome to Rock-Paper-Scissors Game!
                If you want to play, please enter (1), otherwise enter any non-empty input.""");

        String continueGameStr = scanner.nextLine();
        boolean continueGame = continueGameStr.equals("1");

        while (continueGame) {

            for (int i = 0; i < 3; i++) {

                String userChoice;

                do {
                    userChoice = getUserInput();

                } while (!isValid(userChoice));

                GameObject botChoiceObj = getRandomObjectForBot();
                GameObject userChoiceObj = gameObjects[Integer.parseInt(userChoice) - 1];

                int result = userChoiceObj.compareTo(botChoiceObj);

                getWinner(result);

                overallResult += result;
            }

            getWinner(overallResult);

            System.out.println("If you want to continue playing, please enter 1, otherwise any non-empty input");
            continueGame = scanner.nextLine().equals("1");

            if (!continueGame)
                System.out.println("Thank you for playing!");
        }

        scanner.close();
    }

    private void getWinner(int overallResult) {

        if (overallResult > 0) {
            System.out.println("You won the game\n");
        } else if (overallResult < 0) {
            System.out.println("You lost the game\n");
        } else {
            System.out.println("Draw\n");
        }

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
                System.out.println("Invalid Input. Please enter numbers in the specified range.\n");
                return false;
            }

            System.out.println("You chose: " + gameObjects[userChoiceInt - 1]);
            return true;

        } catch (NumberFormatException e) {
            System.out.println("Invalid Input. Please enter only numbers and in the specified range.\n");
        }

        return false;

    }

    private String getUserInput() {

        System.out.println("""
                Choose and object:
                1. Rock
                2. Paper
                3. Scissors""");

        return scanner.next();
    }
}
