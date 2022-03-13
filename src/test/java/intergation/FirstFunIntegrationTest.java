package intergation;

import exceptions.FunctionsException;
import functions.trig.Cosec;
import functions.trig.Sinus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import system.First;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FirstFunIntegrationTest {
    private static final double accuracy = 10e-5;
    static First firstF;
    static Sinus sin;
    static Cosec csc;

    @BeforeAll
    static void setUp() {
        sin = Mockito.mock(Sinus.class);
        csc = Mockito.mock(Cosec.class);
        firstF = new First(accuracy);
        firstF.sin = sin;
        firstF.csc = csc;
    }

    @DisplayName("First function integration test")
    @ParameterizedTest(name = "{index}: x = {0}")
    @CsvFileSource(resources = "/csv/firstF.csv")
    void test0(double actual, double expected) throws FunctionsException {
        Mockito.when(sin.calcSin(actual, accuracy)).thenReturn(Math.sin(actual));
        Mockito.when(csc.calcCsc(actual, accuracy)).thenReturn(1 / Math.sin(actual));
        Assertions.assertEquals(expected, firstF.calc(actual), accuracy);
    }

    @DisplayName("first function exceptions")
    @ParameterizedTest(name = "{index}: x = {0}")
    @ValueSource(doubles = {0.0, -PI, PI, -5 * PI, 3 * PI})
    void test2(Double actual) throws FunctionsException {
        Mockito.when(sin.calcSin(actual, accuracy)).thenReturn(Math.sin(actual));
        Mockito.when(csc.calcCsc(actual, accuracy)).thenThrow(FunctionsException.class);
        assertThrows(FunctionsException.class, ()-> firstF.calc(actual));
    }
}