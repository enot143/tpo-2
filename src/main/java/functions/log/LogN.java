package functions.log;

import exceptions.FunctionsException;
import functions.Function;

public class LogN extends Function {

    public LogN(double accuracy){
        super(accuracy);
    }

    public double calcLogN(double x, double accuracy) throws FunctionsException {
        if (x <= 0){
            throw new FunctionsException("x must be > 0");
        }
        if (accuracy <= 0){
            throw new FunctionsException("accuracy must be > 0");
        }
        double result = 0;
        double multiplier = (x - 1)/(x + 1);
        double step = multiplier * 2;
        int i = 1;
        while (Math.abs(step) * 2 >= accuracy) {
            step = 2 / (float) (i) * Math.pow(multiplier, i);
            result += step;
            if (!Double.isFinite(result) || !Double.isFinite(multiplier)) {
                throw new FunctionsException("Can't reach the accuracy");
            }
            i += 2;
            if (i == Integer.MAX_VALUE || !Double.isFinite(result)) {
                throw new FunctionsException("Can't reach the accuracy");
            }
        }
        return result;
    }

    @Override
    public double calc(double x) throws FunctionsException {
        return this.calcLogN(x, this.accuracy);
    }

    @Override
    public String toString(){
        return "logN(x)";
    }
}