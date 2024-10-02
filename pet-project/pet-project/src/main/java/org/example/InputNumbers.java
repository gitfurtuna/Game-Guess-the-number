package org.example;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;

import java.util.List;
import java.util.Scanner;

public class InputNumbers implements Runnable {

    private static int score = 0;
    private Object lock = new Object();
    private final List<String> guessedNumbers;
    private final List<Integer> generatedNumbers;

    public InputNumbers(List<String> guessedNumbers,List<Integer> generatedNumbers, Object lock, int score ){
        this.guessedNumbers = guessedNumbers;
        this.generatedNumbers = generatedNumbers;
        this.lock = lock;
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) {
                while (generatedNumbers.size() == guessedNumbers.size()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                int generatedNumber = generatedNumbers.get(generatedNumbers.size() - 1);
                Scanner scanner = new Scanner(System.in);
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    guessedNumbers.add(String.valueOf(userGuess) + "T");
                    score += 100;
                    System.out.println(Ansi.colorize("You guessed the number :) ", Attribute.BRIGHT_YELLOW_TEXT()));
                } else {
                    guessedNumbers.add(String.valueOf(userGuess) + "F");
                    System.out.println(Ansi.colorize("Wrong number !", Attribute.RED_TEXT()));
                }

                System.out.print("Correct number: ");
                System.out.println(String.valueOf(Ansi.colorize(" " + generatedNumber + " " , Attribute.BLACK_TEXT(),Attribute.WHITE_BACK())) + " ");
                lock.notify();
                    }

            }
        }
    }


