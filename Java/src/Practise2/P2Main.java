package Practise2;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import java.lang.Math;

public class P2Main {
    public static void main(String[] args) {

        double firstValue = randomGenerator();
        double secondValue = randomGenerator();


        //       printAllResults();

        //       System.out.println(mainRandom);

    }

    public static double randomGenerator(){
        double rand = Math.random();
        rand *= 10;
        rand = (rand%10) + 50;

        return rand;
    }

    public static void printAllResults(double value1, double value2){

        //     System.out.println("doubleFirstValue: " + value1 + "/n" +
//                "doubleSecondValue: " + value2 + "/n" +
                //          "longFirstFirstValue: " + value1 + "/n" +
                //             "longSecondValue: " + value2 + "/n" +
                //              "doubleFirstValue: " + value + "/n" +
                        //              "doubleFirstValue: " + value + "/n" +
                //               "doubleFirstValue: " + value + "/n" +
//                "doubleFirstValue: " + value + "/n" +
//                "doubleFirstValue: " + value + "/n" +
//                "doubleFirstValue: " + value + "/n" +
  //              "doubleFirstValue: " + value + "/n" +);
//        System.out.println("doubleFirstValue: " + value);
    }
}