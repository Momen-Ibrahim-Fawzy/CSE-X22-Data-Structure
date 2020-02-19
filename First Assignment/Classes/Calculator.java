package SimpleCalculator;

public class Calculator implements ICalculator{
    /*
     * this method return the summation of 2 integers
     * And return -1 in case of the summation of the integers is grater than the capacity of int
     *  */
    @Override
    public int add(int x, int y){
        int z;
        z=x+y;
        if((double)(x)+y>2147483647||(double)(x)+y<-2147483648){
            System.out.println("large value of the summation more than int capacity ,Error");
            return -1;
        }
        else
            return z;
    }
    /*
     * this method return the division of 2 integers
     * And return -1 in case of the second integer was zero
     * and in case of runtime error or in any other errors
     *  */
    @Override
    public float divide(int x, int y) throws RuntimeException {
        try {
            float z;
            if (y == 0) {
                System.out.println("Cannot be divided by 0 , Error");
                //throws ;
                return -1;
            } else {
                z = (float) x / y;
                return z;
            }
        }
        /*catch(ArithmeticException e){
        System.out.println("Cannot be divided by 0 , Error");
        return -1;
        }*/
        catch (RuntimeException e) {
            System.out.println("Runtime Error");
            //throws;
            return -1;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //throws;
            return -1;
        }
    }
}
