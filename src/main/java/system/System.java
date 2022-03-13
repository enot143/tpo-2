package system;

import exceptions.FunctionsException;
import functions.Function;

public class System extends Function {

    public First firstF;
    public Second secondF;

    public System(double accuracy){
        firstF = new First(accuracy);
        secondF = new Second(accuracy);
    }

    @Override
    public double calc(double x) throws FunctionsException {
        if (x <= 0) return firstF.calc(x);
        else return secondF.calc(x);
    }

    @Override
    public String toString() {
        return "system(x)";
    }
}