package lastpencil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PencilsGame {

    private int pencilsNumber;
    private List<String> moves;
    private static final String PLAYER = "John";
    private static final String BOT = "Jack";

    public PencilsGame(int pencilsNumber) {
        this.pencilsNumber = pencilsNumber;
        this.moves = new ArrayList<>();
    }

    private void printPencils() {
        for (int i = 0; i < pencilsNumber; i++) {
            System.out.print("|");
        }
        System.out.println();
    }

    private void inputPencils() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many pencils would you like to use:");
        while (true) {
            String input = scanner.nextLine();
            if (!input.matches("\\d+") || input.contains("-")) {
                System.out.println("The number of pencils should be numeric");
            } else {
                int pencils = Integer.parseInt(input);
                if (pencils <= 0) {
                    System.out.println("The number of pencils should be positive");
                } else {
                    pencilsNumber = pencils;
                    break;
                }
            }
        }
    }

    private void firstMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Who will be the first (%s, %s):\n", PLAYER, BOT);
        while (true) {
            String name = scanner.nextLine();
            if (name.equals(PLAYER) || name.equals(BOT)) {
                moves.add(name);
                break;
            } else {
                System.out.println("Choose between 'John' and 'Jack'");
            }
        }
    }

    private void playersMove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int num = Integer.parseInt(scanner.nextLine());
                if (num < 1 || num > 3) {
                    System.out.println("Possible values: '1', '2', or '3'");
                } else if (num > pencilsNumber) {
                    System.out.println("Too many pencils were taken");
                } else {
                    pencilsNumber -= num;
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Possible values: '1', '2', or '3'");
            }
        }
    }

    private void botsMove() {
        if (pencilsNumber % 4 == 0) {
            System.out.println("3");
            pencilsNumber -= 3;
        } else if (pencilsNumber % 4 == 3) {
            System.out.println("2");
            pencilsNumber -= 2;
        } else if (pencilsNumber % 4 == 2) {
            System.out.println("1");
            pencilsNumber -= 1;
        } else if (pencilsNumber % 4 == 1 && pencilsNumber != 1) {
            int botMove = new Random().nextInt(3) + 1;
            System.out.println(botMove);
            pencilsNumber -= botMove;
        } else if (pencilsNumber == 1) {
            System.out.println("1");
            pencilsNumber -= 1;
        }
    }

    private void printWinner() {
        System.out.println(moves.get(moves.size() - 1) + " won!");
    }

    public void play() {
        inputPencils();
        firstMove();
        while (pencilsNumber > 0) {
            printPencils();
            if (moves.get(moves.size() - 1).equals(PLAYER)) {
                System.out.printf("%s's turn:\n", PLAYER);
                playersMove();
                moves.add(BOT);
            } else {
                System.out.printf("%s's turn:\n", BOT);
                botsMove();
                moves.add(PLAYER);
            }
        }
        printWinner();
    }

    public static void main(String[] args) {
        PencilsGame game = new PencilsGame(0); // Initialize with 0 pencils
        game.play();
    }
}
