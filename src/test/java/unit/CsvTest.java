package unit;

import functions.CSVWriter;
import functions.Function;
import functions.log.Log2;
import functions.log.Log3;
import functions.log.Log5;
import functions.log.LogN;
import functions.trig.Cosec;
import functions.trig.Sinus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CsvTest {

    double start = -Math.PI;
    double finish = Math.PI;
    double step = 0.1;

    @Test
    @DisplayName("test ln function")
    void testLn() {
        Function function = new LogN(0.01);
        CSVWriter.writeCSV(function, start, finish, step);
    }

    @Test
    @DisplayName("test log2 function")
    void testLog2() {
        Function function = new Log2(0.01);
        CSVWriter.writeCSV(function, start, finish, step);
    }

    @Test
    @DisplayName("test log3 function")
    void testLog3() {
        Function function = new Log3(0.01);
        CSVWriter.writeCSV(function, start, finish, step);
    }

    @Test
    @DisplayName("test log5 function")
    void testLog5() {
        Function function = new Log5(0.01);
        CSVWriter.writeCSV(function, start, finish, step);
    }

    @Test
    @DisplayName("test ln function")
    void testLN() {
        Function function = new LogN(0.01);
        CSVWriter.writeCSV(function, start, finish, step);
    }

    @Test
    @DisplayName("test sin function")
    void testSin() {
        Function function = new Sinus(0.01);
        CSVWriter.writeCSV(function, start, finish, step);
    }

    @Test
    @DisplayName("test cosec function")
    void testSec() {
        Function function = new Cosec(0.01);
        CSVWriter.writeCSV(function, start, finish, step);
    }

}
