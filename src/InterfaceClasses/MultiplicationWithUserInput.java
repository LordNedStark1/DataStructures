package InterfaceClasses;

import java.util.List;

public class MultiplicationWithUserInput implements CalculationInterface {
    private int multipliedValue;

    NumberPrompt num = new NumberPrompt();
    List<Integer> values;

    public int calculation(){
//        values =num.prompt();
       multipliedValue = values.get(0) * values.get(1);
        return multipliedValue;
    }
}
