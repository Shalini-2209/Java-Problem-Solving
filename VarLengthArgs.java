package JavaLab3;

class variable
{
    void product(int ...args)
    {
        int prdt =1;
        System.out.println("Given arguments: ");
        for (int i: args) {
            System.out.print(" " +i);
            prdt = prdt * i;
        }
        System.out.println("\nProduct of given series is: "+ prdt + "\n");
    }
}

public class VarLengthArgs {
        public static void main(String[] args) {
            variable v =new variable();
            v.product(10,13);
            v.product(22,10,10);
            v.product(10,10,10,10);

        }
}

/* OUTPUT
Given arguments:
 10 13
Product of given series is: 130

Given arguments:
 22 10 10
Product of given series is: 2200

Given arguments:
 10 10 10 10
Product of given series is: 10000

 */
