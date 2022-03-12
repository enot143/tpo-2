package unit;

import exceptions.FunctionsException;
import functions.trig.Sinus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinUnitTest {
    private static final double accuracy = 10e-5;
    private Sinus sin = new Sinus(accuracy);

    @Test
    @DisplayName("Ln: The accuracy < 0")
    void test1() {
        double value = 2.543;
        assertThrows(FunctionsException.class, () -> sin.calcSin(value, -1));
    }

    @DisplayName("Sin: [0;pi)")
    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(doubles = {0d, Math.PI /6, Math.PI / 4, Math.PI / 3, Math.PI / 2, 3 * Math.PI / 7})
    void test2(double value) throws FunctionsException {
        assertEquals(Math.sin(value), sin.calcSin(value, accuracy), accuracy);
    }

    @DisplayName("Sin: (-p;0)")
    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(doubles = {-Math.PI /6, -Math.PI / 4, -Math.PI / 3, -Math.PI / 2, -3 * Math.PI / 7})
    void test3(double value) throws FunctionsException {
        assertEquals(Math.sin(value), sin.calcSin(value, accuracy), accuracy);
    }

    @DisplayName("Sin: граничные значения")
    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(doubles = {-Math.PI, Math.PI})
    void test4(double value) throws FunctionsException {
        assertEquals(Math.sin(value), sin.calcSin(value, accuracy), accuracy);
    }

    @DisplayName("Sin: за границами +-pi")
    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(doubles = {-7*Math.PI / 6, 7*Math.PI / 6})
    void test5(double value) throws FunctionsException {
        assertEquals(Math.sin(value), sin.calcSin(value, accuracy), accuracy);
    }

    @DisplayName("Sin: Nan, Inf")
    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(doubles = {Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY})
    void test6(double value) throws FunctionsException {
        assertEquals(Math.sin(value), sin.calcSin(value, accuracy), accuracy);
    }
}