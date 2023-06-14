package InterfaceClasses;

import java.util.List;

public class DivisionWithUserInput implements CalculationInterface{
    private int dividedValue;
    NumberPrompt num = new NumberPrompt();
    List<Integer> values;
    public int calculation(){

//        values = num.prompt();
        for (int i= 0; i < values.toArray().length; i ++)
//            if (values.get(i) !=0)

        dividedValue /= values.get(i);
        return dividedValue;
    }
}
