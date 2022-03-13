package intergation;

import exceptions.FunctionsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import system.First;
import system.Second;
import system.System;


public class SystemIntegrationTest {
    private static final double accuracy = 10e-5;
    static System system;
    private static First firstFMock;
    private static Second secondFMock;


    @BeforeAll
    static void setUp() throws FunctionsException {
        firstFMock = Mockito.mock(First.class);
        secondFMock = Mockito.mock(Second.class);
        Mockito.when(firstFMock.calc(0.0)).thenThrow(new FunctionsException(""));
        Mockito.when(firstFMock.calc(-Math.PI)).thenThrow(new FunctionsException(""));
        Mockito.when(firstFMock.calc(-1.777777777)).thenReturn(0.459915);
        Mockito.when(firstFMock.calc(-1.584839)).thenReturn(0.996457);
        Mockito.when(firstFMock.calc(-0.898673955795)).thenReturn(0.00014637779581);
        Mockito.when(firstFMock.calc(-0.28940332)).thenReturn(0.0);
        Mockito.when(secondFMock.calc(0.02894994)).thenReturn(-0.644412);
        Mockito.when(secondFMock.calc(0.05677773)).thenReturn(-1.21048);
        Mockito.when(secondFMock.calc(0.1109929395223415)).thenThrow(new FunctionsException(""));
        Mockito.when(secondFMock.calc(0.157847747)).thenReturn(1.85238);
        Mockito.when(secondFMock.calc(0.4724)).thenReturn(0.0);
        Mockito.when(secondFMock.calc(0.8488838104)).thenReturn(-1.93178);
        Mockito.when(secondFMock.calc(1.0)).thenThrow(new FunctionsException(""));
        Mockito.when(secondFMock.calc(1.219638059939)).thenReturn(2.18953168670);
        Mockito.when(secondFMock.calc(4.8390375833)).thenReturn(0.4294393854);
        system = new System(accuracy);
        system.firstF = firstFMock;
        system.secondF = secondFMock;
    }

    @DisplayName("System integration test exceptions")
    @ParameterizedTest(name = "{index}: x = {0}")
    @ValueSource(doubles = {-Math.PI, 0.0, 0.1109929395223415, 1.0})
    void test1(Double x)  {
        Assertions.assertThrows(FunctionsException.class,() -> system.calc(x));
    }

    @DisplayName("System integration test")
    @ParameterizedTest(name = "{index}: x = {0}")
    @CsvFileSource(resources = "/csv/system.csv")
    void test2(Double actual, Double expected) throws FunctionsException {
        Assertions.assertEquals(expected, system.calc(actual), accuracy);
    }
}
