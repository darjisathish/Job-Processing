package runners;

import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.ResultSet;
import  java.sql.DriverManager;
import  java.sql.SQLException;


public class SyntaxChecker {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
//        System.out.println(timeStamp);
        dbconnection();

    }

    public static void dbconnection() throws ClassNotFoundException, SQLException {

        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = "jdbc:oracle:thin:@sg1sefcsd01.logistics.intra:1521:fcsagl.logistics.intra";

        //Database Username
        String username = "focisread";

        //Database Password
        String password = "focisread";

        //Query to Execute
        String query = "select * from focis.X_ENTITY_TAB where financial_entity_code = '5910';";

        //Load mysql jdbc driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);

        //Create Statement Object
        Statement stmt = con.createStatement();

        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String myName = rs.getString(1);

            System. out.println(myName);
        }
        // closing DB Connection
        con.close();
    }


}
