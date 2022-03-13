package intergation;

import exceptions.FunctionsException;
import functions.trig.Cosec;
import functions.trig.Sinus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TrigIntegrationTest {

    private static final double accuracy = 10e-5;
    static Sinus sinus;
    static Cosec csc;

    @BeforeAll
    static void SetUp() {
        sinus = Mockito.mock(Sinus.class);
        csc = new Cosec(accuracy);
    }

    @DisplayName("Cosec")
    @ParameterizedTest(name = "{index}: x = {0}")
    @CsvFileSource(resources = "/csv/csc.csv")
    void test1(Double actual, Double expected) throws FunctionsException {
        Mockito.when(sinus.calcSin(actual, accuracy)).thenReturn(Math.sin(actual));
        assertEquals(expected, csc.calcCsc(actual, accuracy), accuracy);
    }

    @DisplayName("Cosec exceptions")
    @ParameterizedTest(name = "{index}: x = {0}")
    @ValueSource(doubles = {0.0, -PI, PI, -5 * PI, 3 * PI})
    void test2(Double actual) throws FunctionsException {
        Mockito.when(sinus.calcSin(actual, accuracy)).thenReturn(Math.sin(actual));
        assertThrows(FunctionsException.class, ()-> csc.calcCsc(actual, accuracy));
    }
}