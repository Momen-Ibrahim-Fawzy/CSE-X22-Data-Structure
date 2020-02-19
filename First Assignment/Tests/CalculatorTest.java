package SimpleCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @org.junit.jupiter.api.Test
    void add() {
        Calculator calc = new Calculator();
        assertEquals(4,calc.add(0, 4));
        assertEquals(3,calc.add(3, 0));
        assertEquals(6,calc.add(3, 3));
        assertEquals(0,calc.add(0,0));
        assertEquals(-1,calc.add(-5, 4));
        assertEquals(-1,calc.add(4, -5));
        assertEquals(-2,calc.add(3, -5));
        assertEquals(-5,calc.add(-5, 0));
        assertEquals(-5,calc.add(0, -5));
        assertEquals(0,calc.add(-5, 5));
        assertEquals(0,calc.add(5, -5));
        assertEquals(-1,calc.add(2147483647, 1));
        assertEquals(-1,calc.add(-2147483648, -1));
        assertEquals(2147483647,calc.add(1073741823, 1073741824));
        assertEquals(-2147483648,calc.add(-1073741824, -1073741824));
        assertEquals(0,calc.add(-1073741824, 1073741824));
    }

    @org.junit.jupiter.api.Test
    void divide() {
        Calculator calc = new Calculator();
        assertEquals(((float)2/3),calc.divide(2, 3));
        assertEquals(1.5,calc.divide(3, 2));
        assertEquals(((float)-5/3),calc.divide(-5, 3));
        assertEquals(((float)5/-3),calc.divide(5, -3));
        assertEquals(1,calc.divide(5, 5));
        assertEquals(-1,calc.divide(5, -5));
        assertEquals(-1,calc.divide(-5, 5));
        assertEquals(((float)2147483647/2),calc.divide(2147483647,2 ));
        assertEquals(-1073741824,calc.divide(-2147483648,2 ));
        assertEquals(0,calc.divide(0, 3));
        assertEquals(-0.0,calc.divide(0, -40));
        assertEquals(-1,calc.divide(-40, 0));
        assertEquals(-1,calc.divide(3, 0));
        assertEquals(-1,calc.divide(0,0));
    }
}