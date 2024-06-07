package bank_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
public class TransferDAO {

	public int getResult(TransferBean tb) throws SQLException {
		// TODO Auto-generated method stub
		Connection con;

		PreparedStatement pstmt=null;
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","MAHESH","Mahesh");
			con.setAutoCommit(false);
			Savepoint setSavepoint = con.setSavepoint();
			
			pstmt=con.prepareStatement("update apna_bank set AMOUNT=AMOUNT-? where ACCOUNT_NUMBER=?");
			pstmt.setLong(1,tb.getAmount());
			pstmt.setInt(2, tb.getAccount_no());
			int k = pstmt.executeUpdate();
			if(k>0) {				
				PreparedStatement pstmt1=con.prepareStatement("update apna_bank set AMOUNT=AMOUNT+? where ACCOUNT_NUMBER=?");
				pstmt1.setLong(1, tb.getAmount());
				pstmt1.setInt(2, tb.getTarget_Account());
				int k1 = pstmt1.executeUpdate();
				if(k1>0) {
					con.commit();
					return 1;
				}
				else {
					con.rollback();
				}
			}
			else {
				con.rollback(setSavepoint);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	
	

}
