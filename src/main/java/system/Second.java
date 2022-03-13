package system;

import exceptions.FunctionsException;
import functions.Function;
import functions.log.*;

public class Second extends Function {
    public LogN ln;
    public Log2 log2;
    public Log3 log3;
    public Log5 log5;

    public Second(double accuracy) {
        super(accuracy);
        ln = new LogN(accuracy);
        log2 = new Log2(accuracy);
        log3 = new Log3(accuracy);
        log5 = new Log5(accuracy);
    }

    @Override
    public double calc(double x) throws FunctionsException {
        if (x <= 0
                || x == Math.exp(-(Math.pow(Math.log(3), 2) * (Math.log(2.5) + Math.log(2) * Math.log(5)))
                        / (Math.log(2) * Math.log(5)))
                ||x == 1) throw new FunctionsException("point out of range");
        return (((((Math.pow(log3.calc(x), 2)) + log5.calc(x))
                / log3.calc(x)) * log2.calc(x)) / (log2.calc(x) *
                ((ln.calc(x) - (log5.calc(x) - log2.calc(x))) + (log3.calc(x) * log3.calc(x)))));
    }

    @Override
    public String toString() {
        return "second_function(x)";
    }
}
