package eg.edu.alexu.csd.datastructure.stack59;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * it is the test class of the implementation of the expressionEvaluator
 * using some types of situations of the expressionEvaluator
 *
 */
public class expressionEvaluatorTest {
    @Test
    public void infixToPostfixTestZero(){
        expressionEvaluator e= new expressionEvaluator();
        String u=null;
        assertThrows(NullPointerException.class,()->e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestOne(){
        expressionEvaluator e= new expressionEvaluator();
        String u="";
        assertEquals("",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestTwo(){
        expressionEvaluator e= new expressionEvaluator();
        String u="2 + 3 * 4";
        assertEquals("2 3 4 * +",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestThere(){
        expressionEvaluator e= new expressionEvaluator();
        String u="a * b + 5";
        assertEquals("a b * 5 +",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestFour(){
        expressionEvaluator e= new expressionEvaluator();
        String u="(1 + 2) * 7";
        assertEquals("1 2 + 7 *",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestFive(){
        expressionEvaluator e= new expressionEvaluator();
        String u="a * b / c";
        assertEquals("a b c / *",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestsix(){
        expressionEvaluator e= new expressionEvaluator();
        String u="(a / (b - c + d)) * (e - a) * c";
        assertEquals("a b c - d + / e a - c * *",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestSeven(){
        expressionEvaluator e= new expressionEvaluator();
        String u="a / b - c + d * e - a * c";
        assertEquals("a b / c - d e * + a c * -",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestEight(){
        expressionEvaluator e= new expressionEvaluator();
        String u="a          * b     /      c";
        assertEquals("a b c / *",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestnNine(){
        expressionEvaluator e= new expressionEvaluator();
        String u="a * 3b / c--5";
        assertEquals("a 3 b c / * * 0 5 - -",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestnTen(){
        expressionEvaluator e= new expressionEvaluator();
        String u="a * 3abcd / c--4";
        assertEquals("a 3 a b c d c / * * 0 4 - -",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestEleven(){
        expressionEvaluator e= new expressionEvaluator();
        String u="a */ 3abcd / c--4";
        assertThrows(RuntimeException.class,()->e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestTwelve(){
        expressionEvaluator e= new expressionEvaluator();
        String u="-a * +++3abcd / c--4";
        assertThrows(RuntimeException.class,()->e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestTherteen(){
        expressionEvaluator e= new expressionEvaluator();
        String u="-a * ++3abcd / c--4";
        assertThrows(RuntimeException.class,()->e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestFourteen(){
        expressionEvaluator e= new expressionEvaluator();
        String u="-a * +3abcd / c--4";
        assertEquals("0 a - 0 3 a * + b c d c / * 0 4 - -",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestFifteen(){
        expressionEvaluator e= new expressionEvaluator();
        String u="-a * +33abcd / c--44";
        assertEquals("0 a - 0 33 a * + b c d c / * 0 44 - -",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestSixteen(){
        expressionEvaluator e= new expressionEvaluator();
        String u="-(a * +3abcd) / (c--4)";
        assertEquals("0 a 0 3 a * + b c d * - c 0 4 - - /",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestSeventeen(){
        expressionEvaluator e= new expressionEvaluator();
        String u="(-a * +3abcd / c--4";
        assertThrows(RuntimeException.class,()->e.infixToPostfix(u));
    }

    @Test
    public void infixToPostfixTestEighteen(){
        expressionEvaluator e= new expressionEvaluator();
        String u="(-a * +3abcd / c--4))";
        assertThrows(RuntimeException.class,()->e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestNineteen(){
        expressionEvaluator e= new expressionEvaluator();
        String u="(-a * +3abc)*(d / c--4)";
        assertEquals("a 0 3 a * + b c * - d c / 0 4 - - *",e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestTwenty(){
        expressionEvaluator e= new expressionEvaluator();
        String u="*-a * +3abcd / c--4";
        assertThrows(RuntimeException.class,()->e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestTwentyOne(){
        expressionEvaluator e= new expressionEvaluator();
        String u="/-a * +3abcd / c--4";
        assertThrows(RuntimeException.class,()->e.infixToPostfix(u));
    }
    @Test
    public void infixToPostfixTestTwentytwo(){
        expressionEvaluator e= new expressionEvaluator();
        String u="+a * +3abc*d / c--4";
        assertEquals("0 a + 0 3 a * + b c d c / * * 0 4 - -",e.infixToPostfix(u));
    }

    @Test
    public void evaluateTestZero(){
        expressionEvaluator e= new expressionEvaluator();
        String u=null;
        assertThrows(NullPointerException.class,()->e.evaluate(u));
    }
    @Test
    public void evaluateTestOne(){
        expressionEvaluator e= new expressionEvaluator();
        String u="";
        assertEquals(0,e.evaluate(e.infixToPostfix(u)));
    }
    @Test
    public void evaluateTestTwo(){
        expressionEvaluator e= new expressionEvaluator();
        String u="500";
        assertEquals(500,e.evaluate(e.infixToPostfix(u)));
    }
    @Test
    public void evaluateTestThere(){
        expressionEvaluator e= new expressionEvaluator();
        String u="2 + 3 * 4";
        assertEquals(14,e.evaluate(e.infixToPostfix(u)));
        u="2 3 4 * +";
        assertEquals(14,e.evaluate(u));
    }
    @Test
    public void evaluateTestFour(){
        expressionEvaluator e= new expressionEvaluator();
        String u;
        u="a * b + 5";
        String finalU = u;
        assertThrows(RuntimeException.class,()->e.evaluate(e.infixToPostfix(finalU)));
        u="a * b / c";
        String finalU1 = u;
        assertThrows(RuntimeException.class,()->e.evaluate(e.infixToPostfix(finalU1)));
        u="(a / (b - c + d)) * (e - a) * c";
        String finalU2 = u;
        assertThrows(RuntimeException.class,()->e.evaluate(e.infixToPostfix(finalU2)));
        u="a / b - c + d * e - a * c";
        String finalU3 = u;
        assertThrows(RuntimeException.class,()->e.evaluate(e.infixToPostfix(finalU3)));
    }
    @Test
    public void evaluateTestFive(){
        expressionEvaluator e= new expressionEvaluator();
        String u="(1 + 2) * 7";
        assertEquals(21,e.evaluate(e.infixToPostfix(u)));
    }
    @Test
    public void evaluateTestSix(){
        expressionEvaluator e= new expressionEvaluator();
        String u="6 2 / 3 - 4 2 * +";
        assertEquals(8,e.evaluate(u));
    }
    @Test
    public void evaluateTestSeven() {
        expressionEvaluator e = new expressionEvaluator();
        String u;
        u = "abc";
        assertThrows(RuntimeException.class, () -> e.evaluate(u));
    }
    @Test
    public void evaluateTestEight(){
        expressionEvaluator e= new expressionEvaluator();
        String u ="3/-5+20";
        assertEquals(19,e.evaluate(e.infixToPostfix(u)));
    }
    @Test
    public void evaluateTestNine(){
        expressionEvaluator e= new expressionEvaluator();
        String u ="3/0+20";
        assertThrows(RuntimeException.class, () -> e.evaluate(e.infixToPostfix(u)));
    }
    @Test
    public void evaluateTestTen(){
        expressionEvaluator e= new expressionEvaluator();
        String u ="0/-5+20";
        assertEquals(20,e.evaluate(e.infixToPostfix(u)));
    }
    @Test
    public void evaluateTestEleven(){
        expressionEvaluator e= new expressionEvaluator();
        String u ="5/+5+20";
        assertEquals(21,e.evaluate(e.infixToPostfix(u)));
    }
}
