package functions.log;


import exceptions.FunctionsException;
import functions.Function;


public class Log5 extends Function {
    public Log5(double accuracy){
        super(accuracy);
    }

    public double calcLog5(double theta, double accuracy) throws FunctionsException {
        return new LogN(accuracy).calcLogN(theta, accuracy)/new LogN(accuracy).calcLogN(5, accuracy);
    }

    @Override
    public double calc(double x) throws FunctionsException{
        return this.calcLog5(x, this.accuracy);
    }

    @Override
    public String toString(){
        return "log5(x)";
    }
}
