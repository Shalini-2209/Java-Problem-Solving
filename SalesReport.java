package JavaLab3;
import java.util.Scanner;

class sales{
    double sales[][] = new double[5][4];
    double salestotal[] = new double[4];
    void calc() {
        Scanner as = new Scanner(System.in);
        System.out.print("Enter Salesperson id from 1  to 4: ");
        int ID = as.nextInt();
        while(ID >=1 && ID <=4) {
            System.out.print("Product Id between 1 to 5: ");
            int pid= as.nextInt();

            System.out.print("Price of product sold : ");
            int amount = as.nextInt();

            if(ID >= 1 && ID <= 4 && pid >= 1 && pid <= 5 && amount >= 0)
            {
                sales[pid - 1][ID - 1] += amount;
            }

            System.out.print("Salesperson ID between 1  to 4: ");
            ID = as.nextInt();
        }
    }
    void show() {
        for(int i=0; i<=4; i++) {
            double total = 0.0;
            System.out.print("Product" + (i+1) + "\t");
            for(int j=0; j<4; j++) {
                System.out.printf(sales[i][j] + "\t");
                total += sales[i][j];
                salestotal[j] += sales[i][j];
            }
            System.out.println(total);
        }
        System.out.println("\t");
        for(int i=0; i<4; i++)
            System.out.print(salestotal[i] + "\t");
    }

}
public class SalesReport {
        public static void main(String[] args) {

            sales s = new sales();
            s.calc();
            s.show();
        }
}
/*  OUTPUT
Enter Salesperson no from 1  to 4: 1
Product Id between 1 to 5: 1
Price of product sold : 123
Salesperson ID between 1  to 4: 1
Product Id between 1 to 5: 2
Price of product sold : 321
Salesperson ID between 1  to 4: 1
Product Id between 1 to 5: 3
Price of product sold : 432
Salesperson ID between 1  to 4: 1
Product Id between 1 to 5: 4
Price of product sold : 567
Salesperson ID between 1  to 4: 1
Product Id between 1 to 5: 5
Price of product sold : 900
Salesperson ID between 1  to 4: 2
Product Id between 1 to 5: 1
Price of product sold : 564
Salesperson ID between 1  to 4: 2
Product Id between 1 to 5: 2
Price of product sold : 200
Salesperson ID between 1  to 4: 2
Product Id between 1 to 5: 3
Price of product sold : 600
Salesperson ID between 1  to 4: 2
Product Id between 1 to 5: 4
Price of product sold : 679
Salesperson ID between 1  to 4: 2
Product Id between 1 to 5: 5
Price of product sold : 900
Salesperson ID between 1  to 4: 3
Product Id between 1 to 5: 1
Price of product sold : 210
Salesperson ID between 1  to 4: 3
Product Id between 1 to 5: 2
Price of product sold : 700
Salesperson ID between 1  to 4: 3
Product Id between 1 to 5: 3
Price of product sold : 43
Salesperson ID between 1  to 4: 3
Product Id between 1 to 5: 4
Price of product sold : 54
Salesperson ID between 1  to 4: 3
Product Id between 1 to 5: 5
Price of product sold : 600
Salesperson ID between 1  to 4: 4
Product Id between 1 to 5: 1
Price of product sold : 100
Salesperson ID between 1  to 4: 3
Product Id between 1 to 5: 2
Price of product sold : 200
Salesperson ID between 1  to 4: 3
Product Id between 1 to 5: 2
Price of product sold : 678
Salesperson ID between 1  to 4: 9
Product1	123.0	564.0	210.0	100.0	997.0
Product2	321.0	200.0	1578.0	0.0	    2099.0
Product3	432.0	600.0	43.0	0.0	    1075.0
Product4	567.0	679.0	54.0	0.0	    1300.0
Product5	900.0	900.0	600.0	0.0	    2400.0
 */