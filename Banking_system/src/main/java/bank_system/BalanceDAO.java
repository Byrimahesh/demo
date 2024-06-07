package bank_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BalanceDAO {

	public int getResult(BalanceBean bd) {
		int balance=0;
		
		
		// TODO Auto-generated method stub
		Connection con = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "mahesh", "Mahesh");
            String sql="select * from apna_bank where USER_NAME=? AND ACCOUNT_NUMBER=?";
            pstmt=con.prepareStatement(sql);
            pstmt.setString(1,bd.getUserName());
            pstmt.setInt(2, bd.getAccountNumber());
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()) {
            	balance=rs.getInt(3);
            }
            
            
        
        }
        catch (Exception e) {
			// TODO: handle exception
		}
        return balance;
		
		
	}

}
