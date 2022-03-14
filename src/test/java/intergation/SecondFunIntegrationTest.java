package intergation;


import exceptions.FunctionsException;
import functions.log.Log2;
import functions.log.Log3;
import functions.log.Log5;
import functions.log.LogN;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import system.Second;

public class SecondFunIntegrationTest {
    private static final double accuracy = 10e-5;
    static Second secondF;
    static LogN logN;
    static Log2 log2;
    static Log3 log3;
    static Log5 log5;

    @BeforeAll
    static void setUp() {
        logN = Mockito.mock(LogN.class);
        log2 = Mockito.mock(Log2.class);
        log3 = Mockito.mock(Log3.class);
        log5 = Mockito.mock(Log5.class);
        secondF = new Second(accuracy);
        secondF.log2 = log2;
        secondF.log3 = log3;
        secondF.log5 = log5;
        secondF.ln = logN;
    }

    @DisplayName("Second function integration test")
    @ParameterizedTest(name = "{index}: x = {0}")
    @CsvFileSource(resources = "/csv/secondF.csv")
    void test0(double actual, double expected) throws FunctionsException {
        Mockito.when(logN.calc(actual)).thenReturn(Math.log(actual));
        Mockito.when(log2.calc(actual)).thenReturn(Math.log(actual) / Math.log(2));
        Mockito.when(log3.calc(actual)).thenReturn(Math.log(actual) / Math.log(3));
        Mockito.when(log5.calc(actual)).thenReturn(Math.log(actual) / Math.log(5));
        Assertions.assertEquals(expected, secondF.calc(actual), accuracy);
    }


    @DisplayName("Second function exceptions")
    @ParameterizedTest(name = "{index}: x = {0}")
    @ValueSource(doubles = {0.0, 0.1109929395223415, 1.0})
    void test1(double actual) {
        Assertions.assertThrows(FunctionsException.class, () -> secondF.calc(actual));
    }
}
