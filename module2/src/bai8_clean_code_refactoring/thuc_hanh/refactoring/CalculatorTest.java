package bai8_clean_code_refactoring.thuc_hanh.refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {


    @Test
    @DisplayName("Testing addition")
    void testCalculateAdd() {
        int tach_bien = 1;
        int b = 1;
        char o = '+';
        int expected = 2;

        int result = Calculator.calculate(tach_bien, b, o);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing subtraction")
    void testCalculateSub() {
        int tach_bien = 2;
        int b = 1;
        char o = '-';
        int expected = 1;

        int result = Calculator.calculate(tach_bien, b, o);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing multiplication")
    void testCalculateMul() {
        int tach_bien = 2;
        int b = 2;
        char o = '*';
        int expected = 4;

        int result = Calculator.calculate(tach_bien, b, o);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division")
    void testCalculateDiv() {
        int tach_bien = 6;
        int b = 3;
        char o = '/';
        int expected = 2;

        int result = Calculator.calculate(tach_bien, b, o);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division by zero")
    void testCalculateDivByZero() {
        int tach_bien = 2;
        int b = 0;
        char o = '/';

        assertThrows(RuntimeException.class,
                () -> {
                    Calculator.calculate(tach_bien, b, o);
                });
    }

    @Test
    @DisplayName("Testing wrong operator")
    void testCalculateWrongOperator() {
        int tach_bien = 2;
        int b = 0;
        char o = '=';

        assertThrows(RuntimeException.class,
                () -> {
                    Calculator.calculate(tach_bien, b, o);
                });
    }
}
