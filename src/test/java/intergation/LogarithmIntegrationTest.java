package intergation;

import exceptions.FunctionsException;
import functions.log.Log2;
import functions.log.Log3;
import functions.log.Log5;
import functions.log.LogN;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.lang.Math.log;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LogarithmIntegrationTest {

    private static final double accuracy = 10e-5;
    static Log2 log2;
    static LogN logN;
    static Log3 log3;
    static Log5 log5;

    @BeforeAll
    static void SetUp() {
        logN = Mockito.mock(LogN.class);
        log2 = new Log2(accuracy);
        log3 = new Log3(accuracy);
        log5 = new Log5(accuracy);
    }


    @DisplayName("Log2")
    @ParameterizedTest(name = "{index}: x = {0}")
    @CsvFileSource(resources = "/csv/log2.csv")
    void test2(Double value, Double expected) throws FunctionsException {
        when(logN.calcLogN(value, accuracy)).thenReturn(log(value));
        assertEquals(expected, log2.calcLog2(value, accuracy), accuracy);
    }

    @DisplayName("Log3")
    @ParameterizedTest(name = "{index}: x = {0}")
    @CsvFileSource(resources = "/csv/log3.csv")
    void test3(Double value, Double expected) throws FunctionsException {
        when(logN.calcLogN(value, accuracy)).thenReturn(log(value));
        assertEquals(expected, log3.calcLog3(value, accuracy), accuracy);
    }

    @DisplayName("Log5")
    @ParameterizedTest(name = "{index}: x = {0}")
    @CsvFileSource(resources = "/csv/log5.csv")
    void test4(Double actual, Double expected) throws FunctionsException {
        when(logN.calcLogN(actual, accuracy)).thenReturn(log(actual));
        assertEquals(expected, log5.calcLog5(actual, accuracy), accuracy);
    }

    @DisplayName("Exceptions")
    @ParameterizedTest(name = "{index}: x = {0}")
    @ValueSource(doubles = {-1, -2.4, 0})
    void test5(Double actual) throws FunctionsException {
        when(logN.calcLogN(actual, accuracy)).thenThrow(FunctionsException.class);
        assertThrows(FunctionsException.class, () -> log2.calcLog2(actual, accuracy));
        assertThrows(FunctionsException.class, () -> log3.calcLog3(actual, accuracy));
        assertThrows(FunctionsException.class, () -> log5.calcLog5(actual, accuracy));
    }
}