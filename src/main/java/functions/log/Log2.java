package functions.log;

import exceptions.FunctionsException;
import functions.Function;


public class Log2 extends Function {
    public Log2(double accuracy){
        super(accuracy);
    }

    public double calcLog2(double theta, double accuracy) throws FunctionsException {
        return new LogN(accuracy).calcLogN(theta, accuracy)/new LogN(accuracy).calcLogN(2, accuracy);
    }

    @Override
    public double calc(double x) throws FunctionsException{
        return this.calcLog2(x, this.accuracy);
    }

    @Override
    public String toString(){
        return "log2(x)";
    }
}