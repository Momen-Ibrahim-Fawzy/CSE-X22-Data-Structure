package eg.edu.alexu.csd.datastructure.stack59;

/**
 * that class is expressionEvaluator
 * it can convert the infix notation to postfix notation
 * and it can calculate the value of that expression
 *
 */
public class expressionEvaluator implements IExpressionEvaluator{

    /**
     * Takes a symbolic/numeric infix expression as input and check if it is wrong
     * adjusting the Expression
     * in form "1 + -2 + 3 + 5 * a + 231"
     *
     * @param expression
     * @param isInFix
     * @return  String the expression after adjusting
     */
    public static String adjustingExpression(String expression,boolean isInFix) {
        String exp = "";
        int i=0;
        for (i=0;i<expression.length();i++){
            if (!Character.isWhitespace(expression.charAt(i))){
                exp+=expression.charAt(i);
            }
        }
        //check the correctness of the expression
        if (isInFix) {
            for (i = 0; i < exp.length() - 2; i++) {
                if (exp.charAt(i) == '*' | exp.charAt(i) == '/') {
                    if (exp.charAt(i + 1) == '*' | exp.charAt(i + 1) == '/') {
                        RuntimeException Runtime = new RuntimeException();
                        throw Runtime;
                    } else if (exp.charAt(i + 1) == '+' | exp.charAt(i + 1) == '-') {
                        if (exp.charAt(i + 2) == '+' | exp.charAt(i + 2) == '-') {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                    }
                } else if (exp.charAt(i) == '-' | exp.charAt(i) == '+') {
                    if (exp.charAt(i + 1) == '+' | exp.charAt(i + 1) == '-') {
                        if (exp.charAt(i + 2) == '+' | exp.charAt(i + 2) == '-') {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        }
                    } else if (exp.charAt(i + 1) == '*' | exp.charAt(i + 1) == '/') {
                        RuntimeException Runtime = new RuntimeException();
                        throw Runtime;
                    }
                }
            }
        }
        for (i=0;i<exp.length();i++){
            if (!Character.isLetter(exp.charAt(i))&!Character.isDigit(exp.charAt(i))&exp.charAt(i)!='*'&exp.charAt(i)!='/'&exp.charAt(i)!='+'&exp.charAt(i)!='-'&exp.charAt(i)!='('&exp.charAt(i)!=')'){
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        if (isInFix) {
            if (exp.charAt(exp.length() - 1) == '*' | exp.charAt(exp.length() - 1) == '/' | exp.charAt(exp.length() - 1) == '+' | exp.charAt(exp.length() - 1) == '-') {
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        //adjusting the Expression
        //in form "1 + -2 + 3 + 5 * a + 231"
        if(exp.length()>1) {
            boolean numericalOberator = false;
            String temp = "";
            if (exp.charAt(0) == '*' | exp.charAt(0) == '/') {
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
            if (exp.charAt(0) == '+' | exp.charAt(0) == '-') {
                temp += exp.charAt(0);
            } else {
                if (Character.isDigit(exp.charAt(1)) | Character.isLetter(exp.charAt(1))) {
                    numericalOberator = true;
                } else {
                    numericalOberator = false;
                }
                if (numericalOberator == false) {
                    temp += exp.charAt(0);
                    temp += ' ';
                } else {
                    if (Character.isDigit(exp.charAt(0))) {
                        temp += exp.charAt(0);
                    }
                    else {
                        temp += exp.charAt(0);
                        temp += ' ';
                    }
                }
            }
            boolean binaryOberator = false;
            numericalOberator = false;
            for (i = 1; i < exp.length() - 1; i++) {
                if (exp.charAt(i) == '*' | exp.charAt(i) == '/' | exp.charAt(i) == '+' | exp.charAt(i) == '-') {
                    if (binaryOberator == false) {
                        temp += exp.charAt(i);
                        temp += ' ';
                    } else {
                        temp += exp.charAt(i);
                    }
                    if (exp.charAt(i + 1) == '*' | exp.charAt(i + 1) == '/' | exp.charAt(i + 1) == '+' | exp.charAt(i + 1) == '-') {
                        binaryOberator = true;
                    } else {
                        binaryOberator = false;
                    }
                } else if (exp.charAt(i) == '(' | exp.charAt(i) == ')') {
                    temp += exp.charAt(i);
                    temp += ' ';
                } else {
                    if (Character.isDigit(exp.charAt(i + 1)) | Character.isLetter(exp.charAt(i + 1))) {
                        numericalOberator = true;
                    } else {
                        numericalOberator = false;
                    }
                    if (numericalOberator == false) {
                        temp += exp.charAt(i);
                        temp += ' ';
                    } else {
                        if (Character.isDigit(exp.charAt(i))) {
                            temp += exp.charAt(i);
                        }
                        else {
                            temp += exp.charAt(i);
                            temp += ' ';
                        }
                    }
                }
            }
            temp += exp.charAt(i);
            exp = temp;
        }
        return exp;
    }

    /**
     * Takes a symbolic/numeric infix expression as input and
     * convert negative exprition to dummyZero
     * lik: -5 -> (0-5)
     * and if there more than letter and number multiplied it expand it
     * like: 2ab -> 2*a*b
     *
     * @param expression
     * @return
     */
    private static String dummyZero(String expression) {
        String exp="";
        exp=adjustingExpression(expression,true);
        String[] temp = exp.split(" ");
        boolean largTermOfSympols=false;
        int i=0;
        for (i=0;i<temp.length;i++){
            if (temp[i].length()>1){
                if ((temp[i].charAt(0))=='-'|(temp[i].charAt(0))=='+'){
                    String tempo="(0";
                    tempo+=(temp[i].charAt(0));
                    for (int j=1;j<temp[i].length();j++){
                        tempo+=(temp[i].charAt(j));
                    }
                    tempo+=")";
                    temp[i]=tempo;
                }
            }
        }
        String newTemp="";
        for (i=0;i<temp.length;i++){
            newTemp+=temp[i];
        }
        newTemp=adjustingExpression(newTemp,true);
        temp=newTemp.split(" ");
        for (i=0;i<temp.length;i++) {
            if (temp[i].length()>1) {
                for (int j = 0; j < temp[i].length(); j++) {
                    if (Character.isLetter(temp[i].charAt(j))) {
                        largTermOfSympols = true;
                    }
                }
                if (largTermOfSympols == true) {
                    largTermOfSympols = false;

                    String tempo="";
                    for (int j=0 ; j<temp[i].length()-1;j++){
                        if (Character.isDigit(temp[i].charAt(j))&Character.isDigit(temp[i].charAt(j+1))){
                            tempo+=temp[i].charAt(j);
                        }
                        else {
                            tempo += temp[i].charAt(j);
                            tempo += "*";
                        }
                    }
                    tempo+=temp[i].charAt(temp[i].length()-1);
                    temp[i]=tempo;
                }
            }
        }
        String newExp="";
        for (i=0;i<temp.length;i++){
            newExp+=temp[i];
        }
        newExp=adjustingExpression(newExp,true);
        return newExp;
    }

    /**
     * Takes a symbolic/numeric infix expression as input and converts it to
     * postfix notation. There is no assumption on spaces between terms or the
     * length of the term (e.g., two digits symbolic or numeric term)
     *
     * @param expression
     * infix expression
     * @return postfix expression
     */
    @Override
    public String infixToPostfix(String expression) {
        String[] infixExpression;
        String[] postfixExpression;
        int inPostfix=0;
        Stack stack=new Stack();
        if (expression!=null&&expression.length()!=0) {
            infixExpression = dummyZero(expression).split(" ");
            int numOfparanses = 0;
            for (int i = 0; i < infixExpression.length; i++) {
                if (infixExpression[i].length() == 1) {
                    if (infixExpression[i].charAt(0) == '(' | infixExpression[i].charAt(0) == ')') {
                        numOfparanses++;
                    }
                }
            }
            postfixExpression = new String[infixExpression.length - numOfparanses];
            boolean endIndex = false;
            for (int i = 0; i < infixExpression.length; i++) {
                if (Character.isLetter(infixExpression[i].charAt(0)) | Character.isDigit(infixExpression[i].charAt(0))) {
                    postfixExpression[inPostfix] = infixExpression[i];
                    inPostfix++;
                } else if (infixExpression[i].length() == 1) {
                    if (infixExpression[i].charAt(0) == '+' | infixExpression[i].charAt(0) == '-') {
                        while (stack.size() > 0 && ((String) stack.peek()).charAt(0) != '(') {
                            postfixExpression[inPostfix] = (String) stack.pop();
                            inPostfix++;
                        }
                        if (stack.size() == 0 || ((String) stack.peek()).charAt(0) == '(') {
                            stack.push(infixExpression[i]);
                        }
                    } else if (infixExpression[i].charAt(0) == '*' | infixExpression[i].charAt(0) == '/') {
                        stack.push(infixExpression[i]);
                    } else if (infixExpression[i].charAt(0) == '(') {
                        stack.push(infixExpression[i]);
                    } else if (infixExpression[i].charAt(0) == ')') {
                        while (stack.size() > 0 && ((String) stack.peek()).charAt(0) != '(') {
                            postfixExpression[inPostfix] = (String) stack.pop();
                            inPostfix++;
                        }
                        if (stack.size() == 0) {
                            RuntimeException Runtime = new RuntimeException();
                            throw Runtime;
                        } else if (((String) stack.peek()).charAt(0) == '(') {
                            stack.pop();
                        }
                    }
                }
            }
            while (stack.size() > 0) {
                postfixExpression[inPostfix] = (String) stack.pop();
                inPostfix++;
            }
            String newExpression = "";
            for (int i = 0; i < postfixExpression.length - 1; i++) {
                newExpression += postfixExpression[i];
                newExpression += " ";
            }
            newExpression += postfixExpression[postfixExpression.length - 1];
            return newExpression;
        }
        else if (expression.length()==0){
            return "";
        }
        else {
            NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
        }
    }

    /**
     * Evaluate a postfix numeric expression, with a single space separator
     *
     * @param expression
     * postfix expression
     * @return the expression evaluated value
     */
    @Override
    public int evaluate(String expression) {
        if (expression==null){
            NullPointerException nullPointer = new NullPointerException();
            throw nullPointer;
        }
        else if (expression.length()==0){
            return 0;
        }
        for (int i=0;i<expression.length();i++){
            if (!Character.isWhitespace(expression.charAt(i))&!Character.isDigit(expression.charAt(i))&expression.charAt(i)!='*'&expression.charAt(i)!='/'&expression.charAt(i)!='+'&expression.charAt(i)!='-'){
                RuntimeException Runtime = new RuntimeException();
                throw Runtime;
            }
        }
        String[] exp=expression.split(" ");
        Stack evaluate = new Stack();
        int i=0;
        int j=0;
        for (i=0;i<exp.length;i++) {
            if (exp[i].length() == 1) {
                if (Character.isDigit(exp[i].charAt(0))) {
                    evaluate.push(exp[i]);
                    j++;
                } else {
                    if (evaluate.size() > 1) {
                        if ((exp[i].charAt(0)) == '*') {
                            float operandTwo = Float.parseFloat((String) evaluate.pop());
                            float operandOne = Float.parseFloat((String) evaluate.pop());
                            evaluate.push(String.valueOf(operandOne * operandTwo));
                        } else if ((exp[i].charAt(0)) == '/') {
                            float operandTwo = Float.parseFloat((String) evaluate.pop());
                            float operandOne = Float.parseFloat((String) evaluate.pop());
                            if (operandTwo == 0) {
                                RuntimeException Runtime = new RuntimeException();
                                throw Runtime;
                            }
                            evaluate.push(String.valueOf(operandOne / operandTwo));
                        } else if ((exp[i].charAt(0)) == '+') {
                            float operandTwo = Float.parseFloat((String) evaluate.pop());
                            float operandOne = Float.parseFloat((String) evaluate.pop());
                            evaluate.push(String.valueOf(operandOne + operandTwo));
                        } else if ((exp[i].charAt(0)) == '-') {
                            float operandTwo = (float) Float.parseFloat((String) evaluate.pop());
                            float operandOne = (float) Float.parseFloat((String) evaluate.pop());
                            evaluate.push(String.valueOf(operandOne - operandTwo));
                        }
                    } else {
                        RuntimeException Runtime = new RuntimeException();
                        throw Runtime;
                    }
                }
            }
            else if (exp[i].length()==0){
                continue;
            }
            else {
                evaluate.push(exp[i]);
                j++;
            }
        }
        int m =(int)(Float.parseFloat((String)evaluate.pop()));
        return m;
    }
}
