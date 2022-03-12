package functions.trig;

import exceptions.FunctionsException;
import functions.Function;

public class Cosec extends Function {
    public Cosec(double accuracy){
        super(accuracy);
    }

    public double calcCsc(double x, double accuracy) throws FunctionsException {
        double sin = new Sinus(accuracy).calcSin(x, accuracy);
        if (Math.abs(sin) <= accuracy) throw new FunctionsException("Division by 0");
        return 1/sin;
    }

    @Override
    public double calc(double x) throws FunctionsException {
        return this.calcCsc(x, this.accuracy);
    }

    @Override
    public String toString(){
        return "csc(x)";
    }
}