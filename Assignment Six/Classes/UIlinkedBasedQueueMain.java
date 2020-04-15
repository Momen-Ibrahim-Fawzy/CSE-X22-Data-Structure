package eg.edu.alexu.csd.datastructure.queue;

import java.math.BigInteger;
import java.util.Scanner;

public class UIlinkedBasedQueueMain {
    /**
     * it print the menu
     */
    private static void printMenu(){
        System.out.println("1: enqueue");
        System.out.println("2: dequeue");
        System.out.println("3: Check if empty");
        System.out.println("4: Get size");
        System.out.println("5: exit");
        System.out.println("====================================================================");
    }

    private static int tybe=0;

    /**
     * apply the choice which the user chose
     * enqueue
     * dequeue
     * isEmpty
     * size
     * or exit
     *
     * @param choice
     * @param q is the Stack the user working on
     * @return Stack
     */
    private static linkedBasedQueue applyChoice(int choice,linkedBasedQueue q){
        linkedBasedQueue temp=new linkedBasedQueue();
        temp=q;
        if (choice==1){
            boolean taken=false;
            boolean done=false;
            do {
                System.out.println("please enter the value you want to enqueue:");
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
                        System.out.println("the entered value isnot of the same type of the Queue elements");
                        System.out.println("if you want to fill the Queue with other type please enQueue all elements in it");
                    }
                }
                else if (tybe == 2) {//double
                    try {
                        Double.parseDouble(val);
                        taken=true;
                    } catch (Exception e) {
                        System.out.println("the entered value isnot of the same type of the Queue elements");
                        System.out.println("if you want to fill the Queue with other type please enQueue all elements in it");
                    }
                }
                else if (tybe == 3) {//float
                    try {
                        Float.parseFloat(val);
                        taken=true;
                    } catch (Exception e) {
                        System.out.println("the entered value isnot of the same type of the Queue elements");
                        System.out.println("if you want to fill the Queue with other type please enQueue all elements in it");
                    }
                }
                else if (tybe == 4) {//long
                    try {
                        Long.parseLong(val);
                        taken=true;
                    } catch (Exception e) {
                        System.out.println("the entered value isnot of the same type of the Queue elements");
                        System.out.println("if you want to fill the Queue with other type please enQueue all elements in it");
                    }
                }
                else if (tybe == 5) {//BigInteger
                    try {
                        new BigInteger(val);
                        taken=true;
                    } catch (Exception e) {
                        System.out.println("the entered value isnot of the same type of the Queue elements");
                        System.out.println("if you want to fill the Queue with other type please enQueue all elements in it");
                    }
                }
                else if(tybe==6){//char
                    if (val.length()==1) {
                        taken=true;
                    }
                    else {
                        System.out.println("the entered value isnot of the same type of the Queue elements");
                        System.out.println("if you want to fill the Queue with other type please enQueue all elements in it");
                    }
                }
                else if(tybe==7){//String
                    if (val.length()>1|val.length()==1) {
                        taken=true;
                    }
                    else {
                        System.out.println("the entered value isnot of the same type of the Queue elements");
                        System.out.println("if you want to fill the Queue with other type please enQueue all elements in it");
                    }
                }
                if(taken) {
                    temp.enqueue(val);
                    System.out.println("the value: " + val + " is enqueued to the Queue");
                }
                printMenu();
            }while (!taken);
        }
        else if (choice==2){
            if (temp.size()!=0) {
                Object front = temp.dequeue();
                System.out.println("the value of the front of the Queue is: " + front);
                System.out.println("the value: " + front + " is enqueued out of the Queue");
                if (temp.size()==0){
                    tybe=0;
                }
            }
            else {
                System.out.println("the Queue is empty");
            }
            printMenu();
        }
        else if (choice==3){
            if (temp.isEmpty()==true){
                System.out.println("the Queue is Empty");
            }
            else if(temp.isEmpty()==false){
                System.out.println("the Queue is Not Empty");
            }
            printMenu();
        }
        else if (choice==4){
            System.out.println("the size of the Queue is: "+temp.size());
            printMenu();
        }
        else if(choice == 5) {
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
        linkedBasedQueue mainQueue=new linkedBasedQueue();
        System.out.println("that Application is based on the implementation of the Queue based on Single Linked List");
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
                    if (choice>0&&choice<6) {
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
            mainQueue=applyChoice(choice,mainQueue);
        }
    }
}
