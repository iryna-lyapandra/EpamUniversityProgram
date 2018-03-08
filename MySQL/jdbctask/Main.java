package jdbctask;
import java.sql.*;
public class Main {
    public static void main(String[] args) throws Exception {
        String url="jdbc:mysql://localhost:3306/university";
        String user = "root";
        String password = "";
        String query = "SELECT first_name, last_name FROM university.students WHERE overall_rating > 3";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(query);
        String studentName = "";

        while (rs.next()){
            studentName = rs.getString(1) + " " + rs.getString(2);
            System.out.println(studentName);
        }

        st.close();
        connection.close();
    }
}
