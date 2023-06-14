package InterfaceClasses;

import java.util.List;

public class SubtractionWithUserInput implements CalculationInterface{

    NumberPrompt num = new NumberPrompt();
    List<Integer> values ;
    public int calculation(){

        int subtractedValue = 0;
        num.prompt();
        subtractedValue = num.valuesReturn().get(0);

        for (int i= 1; i <num.valuesReturn().size() ; i ++)

            subtractedValue -= num.valuesReturn().get(i) ;

        num.clear();

        return subtractedValue;
    }
}
