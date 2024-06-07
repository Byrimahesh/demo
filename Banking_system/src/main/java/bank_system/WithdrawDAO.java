package bank_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class WithdrawDAO {

	public int getResult(WithdrawBean wb) {
		// TODO Auto-generated method stub
		Connection con;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","MAHESH","Mahesh");
			PreparedStatement pstmt=con.prepareStatement("update apna_bank set amount=amount-? where ACCOUNT_NUMBER=?");
			pstmt.setInt(1, wb.getAmount());
			pstmt.setLong(2, wb.getAccount_no());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				return 1;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	
	

}
