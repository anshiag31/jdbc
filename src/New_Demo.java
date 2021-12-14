import java.sql.*;

public class New_Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from student");
        while(rs.next()){
            System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getString(3)+" "+rs.getInt(4));
        }
    }
}
