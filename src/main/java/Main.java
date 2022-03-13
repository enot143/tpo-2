import functions.Function;
import functions.log.Log2;
import functions.log.Log3;
import functions.log.Log5;
import functions.log.LogN;
import functions.trig.Cosec;
import functions.trig.Sinus;
import system.CSVWriter;
import system.First;
import system.Second;
import system.System;

public class Main {
    public static void main(String[] args) {
        double start = -Math.PI;
        double finish = Math.PI;
        double step = 0.1;
        double acc = 0.01;


        Function function = new LogN(acc);
        CSVWriter.writeCSV(function, start, finish, step);

        function = new Log2(acc);
        CSVWriter.writeCSV(function, start, finish, step);

        function = new Log3(acc);
        CSVWriter.writeCSV(function, start, finish, step);

        function = new Log5(acc);
        CSVWriter.writeCSV(function, start, finish, step);

        function = new LogN(acc);
        CSVWriter.writeCSV(function, start, finish, step);

        function = new Sinus(acc);
        CSVWriter.writeCSV(function, start, finish, step);

        function = new Cosec(acc);
        CSVWriter.writeCSV(function, start, finish, step);

        function = new First(acc);
        CSVWriter.writeCSV(function, start, finish, step);

        function = new Second(acc);
        CSVWriter.writeCSV(function, start, finish, step);

        function = new System(acc);
        CSVWriter.writeCSV(function, start, finish, step);

    }
}
