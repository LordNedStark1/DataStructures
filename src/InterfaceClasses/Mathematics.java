package InterfaceClasses;

public abstract class Mathematics {

    CalculationInterface cal;

    public int mathCalculations(){
       return cal.calculation();
    }
    public void setCal(CalculationInterface cal){
        this.cal = cal;

    }

}
