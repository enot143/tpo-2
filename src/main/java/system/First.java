package system;

import exceptions.FunctionsException;
import functions.Function;
import functions.trig.Cosec;
import functions.trig.Sinus;

public class First extends Function {
    public Cosec csc;
    public Sinus sin;

    public First(double accuracy){
        super(accuracy);
        csc = new Cosec(accuracy);
        sin = new Sinus(accuracy);
    }

    @Override
    public double calc(double x) throws FunctionsException {
        return Math.pow((sin.calc(x) / csc.calc(x)), 18);
    }

    @Override
    public String toString(){
        return "first_function(x)";
    }
}