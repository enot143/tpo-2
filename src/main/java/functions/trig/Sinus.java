package functions.trig;


import exceptions.FunctionsException;
import functions.Function;

import static java.lang.Math.*;

public class Sinus extends Function {

    public Sinus(double accuracy) {
        super(accuracy);
    }

    private double shortenRange(double x) {
        if (x > PI || x < -PI) {
            double k = x % (2 * PI);
            if (k < -PI) {
                return k + 2 * PI;
            }
            if (k > PI) {
                return k - 2 * PI;
            }
            return k;
        } else {
            return x;
        }
    }

    private double sinTailor(double val, int n) {
        return pow(-1, n) * pow(val, 2 * n + 1) / factorial(2L * n + 1);
    }

    public double calcSin(double x, double accuracy) throws FunctionsException {
        x = shortenRange(x);
        if (accuracy <= 0)
            throw new FunctionsException("accuracy must be > 0");
        double result = x;
        double current = x;
        double prev;
        int n = 1;
        do {
            prev = current;
            current = current * (x * x) / ((2 * n) * (2 * n + 1));
            if (n % 2 == 0){
                result += current;
            }
            else result -= current;
            n++;
        }while (Math.abs(prev - current) >= accuracy);
        return result;
    }

    @Override
    public double calc(double x) throws FunctionsException {
        return this.calcSin(x, this.accuracy);
    }

    private long factorial(long val) {
        if (val <= 1)
            return 1;
        else
            return val * (factorial(val - 1));
    }

    @Override
    public String toString() {
        return "sin(x)";
    }
}

