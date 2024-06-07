package bank_system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositServlet() {
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
		String s4=request.getParameter("amount");
		DepositBean db= new DepositBean();
		db.setAccount_no(Long.parseLong(s1));
		db.setUser_name(s2);
		db.setPassword(s3);
		db.setAmount(Integer.parseInt(s4));
		DepositDAo dd =new DepositDAo();
		int result=dd.getResult(db);
		PrintWriter pw=response.getWriter();
		if(result==1)
		{
			pw.println("Your Amount is Deposited Successfully");
		}
		else
		{
			pw.println("Incorrect Password/UserName");
		}
	
		
		
		
	}

}
