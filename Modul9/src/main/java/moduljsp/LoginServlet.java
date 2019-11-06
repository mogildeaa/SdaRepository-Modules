package moduljsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

//        String username = request.getParameter("username");
       System.out.println("xxx");
//
//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        writer.append("Username is " + username + "<br>" + "<input type=text/>");
    }
}
