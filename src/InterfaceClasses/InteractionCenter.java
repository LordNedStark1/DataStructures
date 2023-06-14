package InterfaceClasses;

import java.security.SecureRandom;
import java.util.Scanner;

public class InteractionCenter {
    Mathematics math = new MathematicsCalculator();
    Scanner scan = new Scanner(System.in);
    SecureRandom random = new  SecureRandom();

    public void calQuestionsLoop(){
        initialPrompt();
        int anyKey = scan.nextInt();

        if (anyKey == 1) {
            initialUseOrChangeCalculation();

            initialPrompt();
             anyKey = scan.nextInt();
        }
        else if (anyKey== 2){
            betweenGameAndCal();
        }
        while (anyKey == 1){

            useOrChangeCalculation();

            initialPrompt();
             anyKey = scan.nextInt();
             if(anyKey == 2){
                 break;
             }
        }
        if (anyKey== 2){
            betweenGameAndCal();
        }
    }
    public void betweenGameAndCal(){
        System.out.println("""
                welcome to Calculations Menu
                Press 1 for normal calculations
                -->  2 for game\s""");
        int number = scan.nextInt();
        switch (number) {
            case 1 -> calQuestionsLoop();
            case 2 -> gameDevLoop();
            default -> {
                System.out.println("invalid option");
                betweenGameAndCal();
            }
        }
    }
    public void initialUseOrChangeCalculation(){
        System.out.println("""
                press 1 to select a calculation to perform            
                --> 2 to go back to selection between game and normal calculations\s""");

        int option = scan.nextInt();
        switch(option) {
            case 1:
                userMethodSelection();
                break;
            case 2:
                betweenGameAndCal();
                break;
            default:
                System.out.println("Invalid option");
        }
    }
    public void useOrChangeCalculation(){
        selectOrUsePrompt();
        int option = scan.nextInt();
        switch(option) {
            case 1:
                  System.out.println("Result:  " + math.mathCalculations());
                break;
            case 2:
               userMethodSelection();
                break;
            case 3:
                betweenGameAndCal();
                break;
            default:
                System.out.println("Invalid option");
        }
    }
    public void selectOrUsePrompt(){
        System.out.println("""
                press 1 to perform the calculation
                --> 2 to select a different calculation to perform
                --> 3 to go back to Menu\s""");
    }
    public void initialPrompt(){
        System.out.println("""                     
                press 1 to continue
                --> 2 to go back to Menu
                --> any number to end""");
    }
    public void userMethodSelection(){
        System.out.println("""
                press 1 for addition calculation
                --> 2 for subtraction calculation
                --> 3 for division calculation
                --> 4 for multiplication calculation
                --> 5 to go back to the beginning:\s""");
        int option = scan.nextInt();

//        JOptionPane.showInputDialog



        switch (option){
            case 1:
                System.out.println("Welcome to addition calculation");
                additionCal();
                break;
            case 2:
                System.out.println("Welcome to subtraction calculation");
                subtractionCal();
                break;
            case 3:
                System.out.println("Welcome to division calculation");
                divisionCal();
                break;
            case 4:
                System.out.println("Welcome to multiplication calculation");
                multiplicationCal();
                break;
            case 5:
                calQuestionsLoop();
                break;
            case 6:
                betweenGameAndCal();
            default:
                System.out.println("Not a valid number!");
        }
    }
    public void additionCal(){
        math.setCal(new AdditionWithUserInput() );
    }
    public void divisionCal(){
        math.setCal(new DivisionWithUserInput() );
    }
    public void subtractionCal(){
        math.setCal(new SubtractionWithUserInput() );
    }
    public void multiplicationCal(){
        math.setCal(new MultiplicationWithUserInput() );
    }
    public void gameDevLoop(){
        System.out.println("press 1 to play calculations game!!!\n" +
                            "--> any number to end");
        int number= scan.nextInt();

        while (number==1){

            gameDevelopedUsage();

            System.out.println("press 1 to play calculations game!!!\n" +
                    "--> any number to end");
             number= scan.nextInt();
        }
    }
    public void gameDevelopedUsage(){
        int number = 1+ random.nextInt(4);
        switch (number) {
            case 1 -> {
                System.out.println("Addition Game!!!");
                additionGame();
                math.mathCalculations();
            }
            case 2 -> {
                System.out.println("Subtraction Game!!!");
                subtractionGame();
                math.mathCalculations();
            }
            case 3 -> {
                System.out.println("Multiplication Game!!!");
                multiplicationGame();
                math.mathCalculations();
            }
            case 4 -> {
                System.out.println("Division Game");
                divisionGame();
                math.mathCalculations();
            }
            default -> {
                System.out.println("invalid option");
                System.out.println(number);
            }
        }
    }
    public void additionGame(){
        math.setCal(new AdditionWithRandomNumbers() );
    }
    public void divisionGame(){
        math.setCal(new DivisionWithUserInput() );
    }
    public void subtractionGame(){
        math.setCal(new SubtractionWithRandomNumbers() );
    }
    public void multiplicationGame(){
        math.setCal(new MultiplicationWithUserInput() );
    }
}