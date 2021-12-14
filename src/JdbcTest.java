/*create database of name anshika_I and table name info with 1 coulumn email(attribute with datatype varchar2 length 30)...
now create project by the name of MyProject56 then class name JdbcTest .take input a string from user and use it as a matcher
and provide pattern of the EMAIL address and check if matches..then stored in database and if Email column contain null value
then throw a user define exception*/

import java.sql.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JdbcTest{
    public static void main(String[] args) throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.jdbc.Driver"); //creating driver class
        Scanner sc=new Scanner(System.in);//creating scanner class for taking input of target
        System.out.println("give input pattern");//msg for taking input from user
        String str=sc.nextLine();//input email
       // String s="uuu" ;
     //   System.out.println(s.matches("[a-z]{3}));
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Anshi_I","root","");//making connection with con variable
        PreparedStatement s=con.prepareStatement("Insert info values(?)"); //creating prepared statement
        //s.executeQuery();
        //ResultSet rs=s.getResultSet();
        Pattern p= Pattern.compile("[a-zA-Z0-9]+@(gmail|yahoo|rediffmail)+.com");//making object of pattern class
        Matcher m = p.matcher(str);                                               // making object of Matcher class
        String sa = null;                  // creating a null string
        System.out.println(m.matches());
        try {                            // try block
            if (m.matches()== true) {      // checking match possible or not
                s.setString(1, m.group());//  if yes..then add that EMAIL  in to database
                s.executeUpdate();
            } else if (sa.equals(null)) {     // if no data found
                throw new Exception("no data found");
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        con.close();
    }
}
