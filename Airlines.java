package JavaLab3;
import java.util.Scanner;

public class Airlines {

    public static void main(String args[]) {
        Scanner x = new Scanner(System.in);
        boolean a[] = new boolean[10];
        book bk = new book();
        while (true) {
            System.out.println("\n Choose options: \n 1. First Class \n 2. Economy class \n 3. Exit");
            int n = x.nextInt();

            boolean verify = bk.check(n, a);
            if (verify == false)
                break;
            else
                continue;
        }
    }
}
class book{
    Scanner ob = new Scanner(System.in);

    boolean secondclass(boolean a[]) {
        for(int i=6;i<10;i++) {
            if(a[i]==false) {
                a[i]=true;
                System.out.print("Seat no "+i+" has been booked");
                return true;
            }
        }
        return false;
    }
    boolean firstclass(boolean a[]) {
        for(int i=0;i<5;i++) {
            if(a[i]==false) {
                a[i]=true;
                System.out.print("Seat no "+i+" has been booked.");
                return true;
            }
        }
        return false;
    }

    boolean check(int n,boolean a[]) {
        if(n>=1 && n<=2) {
            if(n==2) {
                System.out.println("You have chosen Economy class");
                boolean booksecond = secondclass(a);
                if(booksecond==true) {
                    return true;
                }
                else {
                    System.out.print("\n Economy class is fully reserved!\n Press 1 if you wanna change class: ");
                    int fclss=ob.nextInt();
                    if(fclss==1) {
                        boolean bookfirst =firstclass(a);
                        if(bookfirst==true) {
                            return true;
                        }
                        else {
                            System.out.print("Sorry, No seats available!");
                            return false;
                        }

                    }
                    else {
                        System.out.println("Next flight leaves in 3 hrs");
                    }


                }

            }
            else {
                boolean bookfirst= firstclass(a);
                if(bookfirst==true) {
                    return true;
                }
                else {
                    System.out.print("\nBusiness class is fully reserved!\n Press 1 if you wanna change class:");
                    int fclss=ob.nextInt();
                    if(fclss==1) {
                        boolean booksecond =secondclass(a);
                        if(booksecond==true) {
                            return true;
                        }
                        else {
                            System.out.print("Sorry, No seats available!");
                            return false;
                        }

                    }
                    else {
                        System.out.println("Next flight leaves in 3 hrs");
                        return false;
                    }


                }

            }

        }
        System.out.println("you chose wrong option");
        return false;

    }

}
/*OUTPUT
 Choose options:
 1. First Class
 2. Economy class
 3. Exit
1
Seat no 0 has been booked.
 Choose options:
 1. First Class
 2. Economy class
 3. Exit
1
Seat no 1 has been booked.
 Choose options:
 1. First Class
 2. Economy class
 3. Exit
1
Seat no 2 has been booked.
 Choose options:
 1. First Class
 2. Economy class
 3. Exit
1
Seat no 3 has been booked.
 Choose options:
 1. First Class
 2. Economy class
 3. Exit
1
Seat no 4 has been booked.
 Choose options:
 1. First Class
 2. Economy class
 3. Exit
1

Business class is fully reserved!
 Press 1 if you wanna change class:1
Seat no 6 has been booked
 Choose options:
 1. First Class
 2. Economy class
 3. Exit
2
You have chosen Economy class
Seat no 7 has been booked
 Choose options:
 1. First Class
 2. Economy class
 3. Exit
2
You have chosen Economy class
Seat no 8 has been booked
 Choose options:
 1. First Class
 2. Economy class
 3. Exit
2
You have chosen Economy class
Seat no 9 has been booked
 Choose options:
 1. First Class
 2. Economy class
 3. Exit
2
You have chosen Economy class

 Economy class is fully reserved!
 Press 1 if you wanna change class: 1
Sorry, No seats available!
 */




