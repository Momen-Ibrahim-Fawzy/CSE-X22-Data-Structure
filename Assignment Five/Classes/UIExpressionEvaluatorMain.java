package eg.edu.alexu.csd.datastructure.stack59;

import java.util.Scanner;

/**
 * the application of the ExpressionEvaluator
 *
 */
public class UIExpressionEvaluatorMain {

    /**
     * it print the Menu
     */
    private static void printMenu(){
        System.out.println("1: Calculate Expression");
        System.out.println("2: exit");
        System.out.println("====================================================================");
    }

    /**
     * it take the choice and apply it
     * the take some variables from user
     * to print the expression
     * or exit
     *
     * @param choice the choice which the user chose
     */
    private static void applyChoice(int choice){
        if (choice==1){
            boolean done = false;
            expressionEvaluator e = new expressionEvaluator();
            String postfix="";
            String expression="";
            while (!done) {
                System.out.println("Enter the Expression you want to Calculate :");
                try {
                    Scanner scanner = new Scanner(System.in);
                    expression = scanner.nextLine();
                    postfix = e.infixToPostfix(expression);
                    System.out.println("the post fix of the expression you entered is :");
                    System.out.println(postfix);
                    done = true;
                } catch (Exception m) {
                    System.out.println("the Expression you have enterd is not correct !");
                    System.out.println("Try Again");
                }
            }
            try {
                int i = e.evaluate(postfix);
                System.out.println("the value of the expression is :"+i);
                printMenu();
            }
            catch (Exception m){
                System.out.println("the Expression you have enterd cannot be evaluated !");
                System.out.println("it might contain variable value(like letters) and not constant values");
                System.out.println("Enter 0 if you want to substitute the variables in your Expression to calculate it");
                Scanner scanner = new Scanner(System.in);
                int val=1;
                try {
                    val = Integer.parseInt(scanner.nextLine());
                }
                catch (Exception p){
                    System.out.println("invalid input!");
                }
                if (val==0){
                    String[] exp=e.adjustingExpression(expression,true).split(" ");
                    for (int i=0;i<exp.length;i++){
                        if (exp[i].length()==1){
                            if (Character.isLetter(exp[i].charAt(0))){
                                boolean taken = false;
                                while (!taken) {
                                    System.out.println("enter the value of the variable:" + exp[i]);
                                    Scanner scan = new Scanner(System.in);
                                    try {
                                        val = Integer.parseInt(scanner.nextLine());
                                        taken=true;
                                    } catch (Exception p) {
                                        System.out.println("invalid input!");
                                    }
                                }
                                exp[i]=Integer.toString(val);
                            }
                        }
                    }
                    expression = "";
                    for (int i = 0; i < exp.length - 1; i++) {
                        expression += exp[i];
                        expression += " ";
                    }
                    expression += exp[exp.length - 1];
                    postfix=e.infixToPostfix(expression);
                    int i = e.evaluate(postfix);
                    System.out.println("the value of the expression is :"+i);
                    printMenu();
                }
                else {
                    printMenu();
                }
            }
        }
        else if(choice == 2) {
            System.out.println("END");
            System.exit(0);
        }
    }

    /**
     * the main method
     *
     * @param arg
     */
    public static void main(String[] arg){
        printMenu();
        while (true){
            int choice = 0;
            Scanner scanner=new Scanner(System.in);
            boolean taken = false;
            while (taken==false){
                scanner=new Scanner(System.in);
                String v=scanner.nextLine();
                try {
                    choice = Integer.parseInt(v);
                    if (choice>0&&choice<3) {
                        taken = true;
                    }
                    else {
                        System.out.println("not in the menu");
                        printMenu();
                    }
                } catch (Exception e) {
                    System.out.println("not in the menu");
                    printMenu();
                }
            }
            applyChoice(choice);
        }
    }
}
