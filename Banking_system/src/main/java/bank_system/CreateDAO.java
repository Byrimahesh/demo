package bank_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class CreateDAO {
    public int getResult(CreateBean cb) {
        int accountNumber = 0;
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "mahesh", "Mahesh");

            String sql = "INSERT INTO apna_bank (USER_NAME, PASSWORD, AMOUNT, ADDRESS, PHONE, ACCOUNT_NUMBER) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = con.prepareStatement(sql);

            pstmt.setString(1, cb.getUN());
            pstmt.setString(2, cb.getPW());
            pstmt.setLong(3, cb.getAMOUNT());
            pstmt.setString(4, cb.getADDRESS());
            pstmt.setLong(5, cb.getPHONE());

            Random random = new Random();
            accountNumber = random.nextInt(99999999);
            pstmt.setInt(6, accountNumber);

            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver class not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("SQL Exception occurred.");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return accountNumber;
    }
}
