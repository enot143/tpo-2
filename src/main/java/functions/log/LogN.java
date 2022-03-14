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
        double sum = 10d;
        while (Math.abs(step) > accuracy || Math.abs(sum)  > accuracy) {

            step = ((double) 2 / (double) (i)) * Math.pow(multiplier, i);
            System.out.println("step:" + step + " , degree:" + i + " , multiplier:" + multiplier);
            result += step;
            if (!Double.isFinite(result) || !Double.isFinite(multiplier)) {
                throw new FunctionsException("Can't reach the accuracy");
            }
            i += 2;
            if (i == Integer.MAX_VALUE || !Double.isFinite(result)) {
                throw new FunctionsException("Can't reach the accuracy");
            }
            sum = Math.pow(multiplier, i) * (2.0 / i) * (1 / (1 - multiplier * multiplier));
            System.out.println(sum);
        }
        System.out.println("");
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