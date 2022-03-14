package unit;

import exceptions.FunctionsException;
import functions.Function;
import functions.log.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LnUnitTest {
    private final double accuracy = 1e-8;
    private LogN logarithmN = new LogN(accuracy);


    @Test
    @DisplayName("Ln: The accuracy < 0")
    void test1() {
        double value = 2.543;
        assertThrows(FunctionsException.class, () -> logarithmN.calcLogN(value, -1));
    }

    @Test
    @DisplayName("Ln: The accuracy = 0")
    void test2() throws FunctionsException {
        double value = 2.543;
        assertThrows(FunctionsException.class, () -> logarithmN.calcLogN(value, 0));
    }

    @DisplayName("Ln: params")
    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(doubles = {2.0, 3.02, 17.043, 3.324, 12.2, 1.23, 10.21313})
    void test3(double value) throws FunctionsException {
        assertEquals(Math.log(value), logarithmN.calcLogN(value, accuracy), accuracy);
    }

    @DisplayName("Ln: exceptions")
    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(doubles = {-1.456, -3.590403, 0.0})
    void test4(double value) throws FunctionsException {
        assertThrows(FunctionsException.class, () -> logarithmN.calcLogN(value, accuracy));
    }
}