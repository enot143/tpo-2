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
    public String toString(){
        return "((((sin(x) / csc(x)) ^ 3) ^ 3) ^ 2)_if_x<=0_ (((((log_3(x) ^ 2) + log_5(x)) / log_3(x)) * log_2(x)) / (log_2(x) * ((ln(x) - (log_5(x) - log_2(x))) + (log_3(x) * log_3(x)))))_if_x>0";
    }
}