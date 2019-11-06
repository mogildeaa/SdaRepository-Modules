package moduljsp;

import jspbins.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MasiniServlet")
public class MasiniServlet extends HttpServlet {
    CarService carService= new CarService();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String brand = request.getParameter("brand");
        String type = request.getParameter("type");
        Integer year = Integer.parseInt(request.getParameter("year"));
        Double km = Double.parseDouble(request.getParameter("km"));

        Car myCar = new Car(brand, type, year, km);
        carService.save(myCar);
        //todo: salveaza asta in baza de date cu jdbc
    }
}
