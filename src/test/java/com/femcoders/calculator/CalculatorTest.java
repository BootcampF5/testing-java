package com.femcoders.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


// testSum_WhenFourIsAddeddToTwo_ShouldReturnSix

public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setupBeforeAll(){
        System.out.println("Se ejecuta antes de TODOS los tests");
    }

    @BeforeEach
    void setupBeforeEach() {
        System.out.println("se ejecuta antes de CADA test");
        calculator = new Calculator();
    }

    @AfterAll
    static void cleanupAfterAll(){
        System.out.println("se ejecuta al final de TODOS los tests");
    }

    @AfterEach
    void cleanupAfterEach() {
        System.out.println("se ejecuta despues de CADA test");
    }

    @ParameterizedTest
    @CsvSource({
        "4, 2, 6",
        "5, 5, 10",
        "3, 5, 8",
        "2, 1, 3"
    })
    void shouldReturnSumBetweenTwoNumbers(int num1, int num2, int expectedResult) {
        //arrange/given

        //act/when
        int actualResult = calculator.sum(num1, num2);
        //assert/then
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
        "4, 2, 2",
        "10, 5, 2",
        "10, 0, 0"
    })
    void shouldReturnDivisionBetweenTwoNumbers(int patata1, int patata2, int expected) {

        assertEquals(expected, calculator.divide(patata1, patata2));
    }

    
    @Test
    public void shouldThrowAnExceptionWhenANumberIsDividedByZero() {
        int num1 = 10;
        int num2 = 0;
        String expectedExceptionMessage = " / by zero";

        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> calculator.divide(num1, num2));
        
        assertEquals(expectedExceptionMessage, actualException);
    }

    
}
