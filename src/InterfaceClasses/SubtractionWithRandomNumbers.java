package InterfaceClasses;

import java.security.SecureRandom;
import java.util.Scanner;

public class SubtractionWithRandomNumbers implements CalculationInterface{

    Scanner input =new Scanner(System.in);
    public int calculation(){
        int failedAnswerCount = 1;

        SecureRandom random = new SecureRandom();
        int value1 = 1 + random.nextInt (100);
        int value2 = 1 + random.nextInt(100);
        int answer = value1 - value2;

        System.out.println(value1 + "  -  " + value2 + " =  ?" );
        int userAnswer = input.nextInt();

        if (userAnswer == answer){
            System.out.println("So fast, what a great job");
        }

        while (userAnswer != answer) {
            System.out.println("try again");
            System.out.println(value1 + "  -  " + value2 + " =  ?" );
            userAnswer = input.nextInt();

            failedAnswerCount++;

            if (failedAnswerCount == 20 && userAnswer != answer){
                System.out.println("I think this is quiet hard for u, chose a less difficulty");
                break;
            }
        }


        if (failedAnswerCount < 10 && userAnswer ==answer){
            System.out.println("so smart. less than 10 trials");
            System.out.println(value1 + "  -  " + value2 + " =  " + answer );
            System.out.println("total amount of trials is " + failedAnswerCount);
        }

        if ( failedAnswerCount == 10 && userAnswer == answer) {
            System.out.println("it took you 10 trials");
            System.out.println(value1 + "  -  " + value2 + " =  " + answer );
        }
        if ( failedAnswerCount > 10 && userAnswer == answer) {
            System.out.println("it took you more 10 trials?!");
            System.out.println(value1 + "  -  " + value2 + " =  " + answer );
        }

        return failedAnswerCount;
    }

}
