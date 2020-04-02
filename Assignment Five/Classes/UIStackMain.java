package eg.edu.alexu.csd.datastructure.stack59;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * the application of the stack
 *
 */
public class UIStackMain {

    /**
     * it print the menu
     */
    private static void printMenu(){
        System.out.println("1: Push");
        System.out.println("2: Pop");
        System.out.println("3: Peek");
        System.out.println("4: Get size");
        System.out.println("5: Check if empty");
        System.out.println("6: exit");
        System.out.println("====================================================================");
    }

    private static int tybe=0;

    /**
     * apply the choice which the user chose
     * push
     * pop
     * peek
     * get size
     * check if empty
     * or exit
     *
     * @param choice
     * @param s is the Stack the user working on
     * @return Stack
     */
    private static Stack applyChoice(int choice,Stack s){
            Stack temp=new Stack();
            temp=s;
            if (choice==1){
                boolean taken=false;
                boolean done=false;
                do {
                    System.out.println("please enter the value you want to push:");
                    Scanner scanner = new Scanner(System.in);
                    String val = scanner.nextLine();
                    if (tybe==0){
                        while (!done) {
                            try {
                                Integer.parseInt(val);
                                tybe = 1;
                                taken = true;
                                done=true;
                                continue;
                            } catch (Exception e) {

                            }
                            try {
                                Double.parseDouble(val);
                                tybe = 2;
                                taken = true;
                                done=true;
                                continue;
                            } catch (Exception e) {

                            }
                            try {
                                Float.parseFloat(val);
                                tybe = 3;
                                taken = true;
                                done=true;
                                continue;
                            } catch (Exception e) {

                            }
                            try {
                                Long.parseLong(val);
                                tybe = 4;
                                taken = true;
                                done=true;
                                continue;
                            } catch (Exception e) {

                            }
                            try {
                                new BigInteger(val);
                                tybe = 5;
                                taken = true;
                                done=true;
                                continue;
                            } catch (Exception e) {

                            }
                            if (val.length()==1) {
                                tybe = 6;
                                taken = true;
                                done=true;
                                continue;
                            }
                            if (val.length()>1) {
                                tybe = 7;
                                taken = true;
                                done=true;
                                continue;
                            }
                        }
                    }
                    else if (tybe == 1) {//int
                        try {
                            Integer.parseInt(val);
                            taken=true;
                        } catch (Exception e) {
                            System.out.println("the entered value isnot of the same type of the stack elements");
                            System.out.println("if you want to full the stack with other type please pop all elements in it");
                        }
                    }
                    else if (tybe == 2) {//double
                        try {
                            Double.parseDouble(val);
                            taken=true;
                        } catch (Exception e) {
                            System.out.println("the entered value isnot of the same type of the stack elements");
                            System.out.println("if you want to full the stack with other type please pop all elements in it");
                        }
                    }
                    else if (tybe == 3) {//float
                        try {
                            Float.parseFloat(val);
                            taken=true;
                        } catch (Exception e) {
                            System.out.println("the entered value isnot of the same type of the stack elements");
                            System.out.println("if you want to full the stack with other type please pop all elements in it");
                        }
                    }
                    else if (tybe == 4) {//long
                        try {
                            Long.parseLong(val);
                            taken=true;
                        } catch (Exception e) {
                            System.out.println("the entered value isnot of the same type of the stack elements");
                            System.out.println("if you want to full the stack with other type please pop all elements in it");
                        }
                    }
                    else if (tybe == 5) {//BigInteger
                        try {
                            new BigInteger(val);
                            taken=true;
                        } catch (Exception e) {
                            System.out.println("the entered value isnot of the same type of the stack elements");
                            System.out.println("if you want to full the stack with other type please pop all elements in it");
                        }
                    }
                    else if(tybe==6){//char
                        if (val.length()==1) {
                            taken=true;
                        }
                        else {
                            System.out.println("the entered value isnot of the same type of the stack elements");
                            System.out.println("if you want to full the stack with other type please pop all elements in it");
                        }
                    }
                    else if(tybe==7){//String
                        if (val.length()>1|val.length()==1) {
                            taken=true;
                        }
                        else {
                            System.out.println("the entered value isnot of the same type of the stack elements");
                            System.out.println("if you want to full the stack with other type please pop all elements in it");
                        }
                    }
                    if(taken) {
                        temp.push(val);
                        System.out.println("the value: " + val + " is pushed to the Stack");
                    }
                        //System.out.println("the Stack become:");
                        //temp.showStack();
                        printMenu();
                }while (!taken);
            }
            else if (choice==2){
                if (temp.size()!=0) {
                    Object peek = temp.pop();
                    System.out.println("the value of the peek is: " + peek);
                    System.out.println("the value: " + peek + " is popped out of the Stack");
                    if (temp.size()==0){
                        tybe=0;
                    }
                    //System.out.println("the Stack become:");
                    //temp.showStack();
                }
                else {
                    System.out.println("the stack is empty");
                }
                printMenu();
            }
            else if (choice==3){
                if (temp.size()!=0) {
                    System.out.println("the value of the peek is: " + temp.peek());
                    //System.out.println("the Stack is:");
                    //temp.showStack();
                }
                else {
                    System.out.println("the stack is empty");
                }
                printMenu();
            }
            else if (choice==4){
                System.out.println("the size of the stack is: "+temp.size());
                //System.out.println("the Stack is:");
                //temp.showStack();
                printMenu();
            }
            else if (choice==5){
                if (temp.isEmpty()==true){
                    System.out.println("the stack is Empty");
                }
                else if(temp.isEmpty()==false){
                    System.out.println("the stack is Not Empty");
                }
                //System.out.println("the Stack is:");
                //temp.showStack();
                printMenu();
            }
            else if(choice == 6) {
                System.out.println("END");
                System.exit(0);
            }
            return temp;
    }

    /**
     * the main method of the application
     * @param arg
     */
    public static void main(String[] arg){
        Stack mainStack=new Stack();
        printMenu();
        while (true) {
            int choice = 0;
            Scanner scanner=new Scanner(System.in);
            boolean taken = false;
            while (taken==false){
                scanner=new Scanner(System.in);
                String v=scanner.nextLine();
                try {
                    choice = Integer.parseInt(v);
                    if (choice>0&&choice<7) {
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
            mainStack=applyChoice(choice,mainStack);
        }
    }
}
