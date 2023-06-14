package InterfaceClasses;

public class AdditionWithUserInput implements CalculationInterface{


    NumberPrompt num = new NumberPrompt();

    public int calculation(){

        int addedValue = 0 ;
        num.prompt();
        for (int i= 0; i <num.valuesReturn().size() ; i ++)
            addedValue += num.valuesReturn().get(i) ;

        num.clear();

        return addedValue;
    }
}
