import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class CarJdbc {
    Connection conn = null;
    PreparedStatement pst = null;
    String query;

    CarJdbc() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicle?serverTimezone=UTC", "root", "");
    }

    public boolean addCar(double total, double cost, double mileage, double parkFee, double toll, double totExp) throws Exception {
        query = "INSERT INTO charges VALUES(?, ?, ?, ?, ?, ?)";
        pst = conn.prepareStatement(query);
        pst.setDouble(1, total);
        pst.setDouble(2, cost);
        pst.setDouble(3, parkFee);
        pst.setDouble(4, mileage);
        pst.setDouble(5, toll);
        pst.setDouble(6, totExp);
        int count = pst.executeUpdate();

        if (count != 0)
            return true;
        else
            return false;
    }
}

public class VehicleCharges {
    public static void main(String[] args) throws Exception {

        CarJdbc jdbc = new CarJdbc();

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the following information : \n");

        System.out.println("Total KM driven for the day : ");
        double total = in.nextDouble();

        System.out.println("Enter Cost Per Litre of the gasoline");
        double CostPerLitre = in.nextDouble();

        System.out.println("Enter Mileage of the vehicle");
        double  Mileage = in.nextDouble();

        System.out.println("Enter Parking Fees");
        double ParkingFees = in.nextDouble();

        System.out.println("Enter total tolls per day");
        double TollPerDay = in.nextDouble();

        double carDrivenCost = total / Mileage * CostPerLitre;
        double totalParkingFees = ParkingFees * TollPerDay;
        double totalExp = carDrivenCost + totalParkingFees;


        //Inserting into database
        boolean isAdded = jdbc.addCar(total, CostPerLitre, Mileage, ParkingFees, TollPerDay, totalExp);
        if (isAdded)
            System.out.println("\nData inserted successfully into database\n");

        System.out.println("Information for total expense of the day");
        System.out.println("===================================================");
        System.out.println("Total Km = " + total);
        System.out.println("Cost Per Litre = " + CostPerLitre);
        System.out.println("Mileage = " + Mileage);
        System.out.println("Parking = " + ParkingFees);
        System.out.println("Total tolls = " + TollPerDay);
        System.out.println("----------------------------------------------------");
        System.out.println("Total Expense = " + (int)totalExp);

        in.close();
    }
}




