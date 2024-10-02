package org.example;

import com.beust.jcommander.*;
import com.diogonunes.jcolor.*;

import java.util.ArrayList;
import java.util.List;

//@Parameters(separators = " = ")
public class App {

//    @Parameter(names = "gender", description = "Player gender", required = true)
//    private static String gender;
//
//    @Parameter(names = "name", description = "Player name", required = true)
//    private static String name;

    public static void main(String[] args) {
         int score = 0;
         final Object lock = new Object();
         final List<Integer> generatedNumbers = new ArrayList<>();

         final List<String> guessedNumbers = new ArrayList<>();
//        System.out.println("Run the game:\n" + "`java -jar target/guess-number-game.jar gender = <boy or girl> name = <name>`");
        Boy boy = new Boy("boy", "Superman");
        Girl girl = new Girl("girl", "Alice");
        Details details = new Details();
//        details.start(boy);
//        details.start(girl);
//
//        App app = new App();
//        JCommander jc = new JCommander(app);
//        try {
//            jc.parse(args);
//        } catch (Exception e) {
//            jc.usage();
//            return;
//        }

        Thread first = new Thread(new NumbersGenerator(generatedNumbers, guessedNumbers, lock));
        Thread second = new Thread(new InputNumbers(guessedNumbers, generatedNumbers, lock, score));

//           if (gender.equals("boy")){
//               Boy boy = new Boy("boy", name);
               details.start(girl);
               Attribute winColor = details.winBack(boy);
               Attribute loseColor = details.loseBack(boy);
               System.out.println("Guess the number from 0 to 9 :)");
               first.start();
               second.start();

               try {
                   first.join();
                   second.join();
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
                   System.out.println("The main thread has been interrupted.");
               }
        System.out.println();
        System.out.println("RESULTS:");
        System.out.print("Your numbers:    ");
        for (String el: guessedNumbers) {
            String onlyDigits = el.replaceAll("\\D+", "");
            if (el.contains("T")) {
                System.out.print(String.valueOf(Ansi.colorize(" " + onlyDigits + " " , winColor, Attribute.BLACK_TEXT()) + " "));
            } else {
                System.out.print(String.valueOf(Ansi.colorize(" " + onlyDigits + " " , loseColor, Attribute.BLACK_TEXT()) + " "));
            }
        }
        System.out.println();
        System.out.print("Correct numbers: ");
        for (Integer num: generatedNumbers
        ) {

            System.out.print(String.valueOf(Ansi.colorize(" " + num + " " , Attribute.BLACK_TEXT(),Attribute.WHITE_BACK())) + " ");
        }
        System.out.println();
        System.out.println("You won " + score + " coins");

           }

    }


