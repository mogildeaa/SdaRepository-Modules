package jdbc;

import org.junit.Test;

import java.sql.*;
import java.util.Date;

public class TeacherTest {
//    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
//    first_name VARCHAR(255) NOT NULL,
//    last_name VARCHAR(255) NOT NULL,
//    hire_date DATE

    private String user = "root";
    private String password = "n-amparola";
    private String url = "jdbc:mysql://localhost:3306/courses?useSSL=false";

    @Test
    public void createTeacher() throws SQLException {
        String sqlString = "INSERT INTO teacher(first_name, last_name, hire_date)" +
                " values ('Ionel', 'Popescu', '2007-09-23')";
        // In varianta try-with-resources, resursele sunt inchise automat.
        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement statement = conn.createStatement()
        ) { // Change default behaviour of transaction - get transaction
            conn.setAutoCommit(false);

            // number of affected rows
            int res = statement.executeUpdate(sqlString);

            //commit transaction
            conn.commit();
        }
    }

    @Test
    public void deleteTeacher() {
        String sqlString = "DELETE FROM teacher WHERE id = ?"; // "?" spune ca acest CRITERIU!!! trebuie sa fie definit in try

        //Am sa utilizez try-ul clasic pentru a exemplifica
        //clean-up-ul pentru resure.
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            statement = conn.prepareStatement(sqlString);

            conn.setAutoCommit(false);

            statement.setInt(1, 2); // parametruIndex este primul CRITERIU!!!

            // no of deleted rows
            int res = statement.executeUpdate();

            conn.commit();

            statement.close();
            conn.close();

        } catch (Exception e) {
            try {
                if (null != conn) {
                    conn.rollback();
                    conn.close();
                }
                if (null != statement) {
                    conn.rollback();
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Test
    public void testDeleteLastRow() throws SQLException {
        String sqlMaxId = "SELECT max(id) FROM teacher";
        String sqlDeleteLastRow = "DELETE FROM teacher WHERE id = ? ";

        try (
                Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement statement = conn.prepareStatement(sqlMaxId);
                PreparedStatement statement2 = conn.prepareStatement(sqlDeleteLastRow);
        ) {
            int maxId = 0;
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                maxId = rs.getInt(1);
            }

            statement2.setInt(1, maxId);
            int result = statement2.executeUpdate();
            System.out.println("Nr de row-uri sterse: " + result);
            System.out.println("Index sters: " + maxId);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectedTeacher() throws SQLException {
        String sqlString = "SELECT * FROM TEACHER";
        try ( Connection conn = DriverManager.getConnection(url,user,password);
              Statement stmt = conn.createStatement();
        ) {
            // Pentru SELECT(READ) nu este nevoie de o tranzactie (best practice)
            ResultSet rs = stmt.executeQuery(sqlString);
            //move cursor to the next row
            while(rs.next()) {
                int id = rs.getInt("id");
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                Date hireDate = rs.getDate("hire_date");
                System.out.println("Prof :"+ id + " / " + firstname + "/" + lastname + "/ hiredate" + hireDate );
            }
        }
    }
}
