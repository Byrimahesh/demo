package bank_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/TransferServlet")
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1=request.getParameter("Account_number");
		String s2=request.getParameter("user_name");
		String s3=request.getParameter("password");
		String s4=request.getParameter("Target_Account_number");
		String s5=request.getParameter("amount");
		TransferBean tb= new TransferBean();
		tb.setAccount_no(Integer.parseInt(s1));
		tb.setUser_name(s2);
		tb.setPassword(s3);
		tb.setTarget_Account(Integer.parseInt(s4));
		tb.setAmount(Integer.parseInt(s5));
		TransferDAO wd =new TransferDAO();
		int result=0;
		try {
			result = wd.getResult(tb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter pw=response.getWriter();
		if(result>0)
		{
			pw.println("Your Amount is Transfer Successfully");
		}
		else
		{
			pw.println("Incorrect Password/UserName");
		}
	
		
		
		
	}

}
