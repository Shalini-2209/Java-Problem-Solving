import java.util.Scanner;

interface Bonus{
    public void calculateBonus(int pos, int exp);
}

class Calculation implements Bonus {
    int bonus;

    @Override
    public void calculateBonus(int pos, int exp) {
        if(pos == 1){
            bonus = 1000 * exp;
        }
        else if(pos == 2) {
            bonus = 1500 * exp;
        }
        else if(pos == 3) {
            bonus = 2000 * exp;
        }
        else if(pos == 4) {
            bonus = 2500 * exp;
        }
        else if(pos == 5) {
            bonus = 3000 * exp;
        }
        else {
            bonus = 3500 * exp;
        }

        System.out.println("Amout transacted for your Diwali bonus is "+ bonus);

    }
}

public  class Interface {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calculation calc = new Calculation();
        int ch;

        while(true) {

            System.out.println("Choose the designation of the employee: ");
            System.out.println("1. Analyst");
            System.out.println("2. Programmer Analyst");
            System.out.println("3. Senior Analyst");
            System.out.println("4. Consultant");
            System.out.println("5. Region head");
            System.out.println("6. BU head");
            System.out.println("7. Exit");
            System.out.println("Your Choice: ");
            ch = in.nextInt();

            if(ch == 7){
                return;
            }

            System.out.println("Enter years of experience: ");
            int exp = in.nextInt();

            calc.calculateBonus(ch, exp);

            }

        }

    }


