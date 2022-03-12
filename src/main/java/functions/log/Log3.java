package functions.log;


import exceptions.FunctionsException;
import functions.Function;


public class Log3 extends Function {
    public Log3(double accuracy){
        super(accuracy);
    }

    public double calcLog3(double theta, double accuracy) throws FunctionsException {
        return new LogN(accuracy).calcLogN(theta, accuracy)/new LogN(accuracy).calcLogN(3, accuracy);
    }

    @Override
    public double calc(double x) throws FunctionsException{
        return this.calcLog3(x, this.accuracy);
    }

    @Override
    public String toString(){
        return "log3(x)";
    }
}