package moduljsp;

import com.mysql.jdbc.Statement;
import jspbins.Car;

import java.sql.*;

public class CarService {

    public static void save(Car car) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspmodul9",
                    "root", "n-amparola");
            Statement statement = (Statement) connection.createStatement();
            PreparedStatement prSt = connection.prepareStatement(
                    "INSERT INTO cars(Brand, CarType, FabricationYear, KM) VALUES (?,?,?,?)"
            );

            prSt.setString(1, car.getBrand());
            prSt.setString(2, car.getType());
            prSt.setInt(3, car.getYear());
            prSt.setDouble(4, car.getKm());

            int verificare = prSt.executeUpdate();
            if (verificare != 0) {
                System.out.println("Added to the database");
            } else {
                System.out.println("Failed to add to the database");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
