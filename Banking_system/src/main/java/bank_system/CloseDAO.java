package bank_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CloseDAO {

	public int getResult(CloseBean cb) 
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","MAHESH","Mahesh");
			PreparedStatement pstmt=con.prepareStatement("delete from apna_bank where Account_Number=?");
			pstmt.setLong(1,cb.getAccount_no());
			PreparedStatement pstmt1=con.prepareStatement("delete from apna_bank where Account_Number=?");
			pstmt1.setLong(1,cb.getAccount_no());
			ResultSet executeQuery1 = pstmt1.executeQuery();
			if(executeQuery1.next())
			{
				return 1;
			}
			else
			{
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}

}
