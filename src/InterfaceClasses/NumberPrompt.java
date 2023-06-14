package InterfaceClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberPrompt {
    static Scanner scan = new Scanner(System.in);
    List<Integer> values = new ArrayList<>();
//    int number;
    public void prompt() {

//        values.removeAll(values);
//       if (values.get(0) > 0) {
//           values.clear();
//       }
        System.out.println("Enter number to calculate or enter no to end");
        String number1 = scan.next();


           int number = Integer.parseInt(number1);
            values.add(number);



        while (!number1.equals("no")) {

            System.out.println("Enter number to calculate or enter no to end");
            number1 = scan.next();

            if (!number1.equalsIgnoreCase("no")) {
                number = Integer.parseInt(number1);
                values.add(number);
            }

        }
    }
    public  List<Integer> valuesReturn(){

        return values;

    }


    public void clear() {
        values.clear();
//        intArrayList.removeAll(intArrayList);
    }




//    public static void main(String[] args) {
//
//
//        Scanner input = new Scanner(System.in);
//        List<Integer> values = new ArrayList<>();
//       for (int i =1; i <20; i++){
//           values.add(i+4);
//       }
//        System.out.print(values);
//        values.removeAll(values);
//        System.out.println(values);

//    }
}