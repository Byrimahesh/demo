package bank_system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BalanceCheckServlet
 */
@WebServlet("/BalanceCheckServlet")
public class BalanceCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BalanceCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			
		
		String s1=request.getParameter("AccountNumber");
		String s2=request.getParameter("PW");
		String s3=request.getParameter("un");
		BalanceBean bb=new BalanceBean();
		bb.setAccountNumber(Integer.parseInt(s1));
		bb.setPassword(s2);
		bb.setUserName(s3);
		
		BalanceDAO bd=new BalanceDAO();
		int balance=bd.getResult(bb);
		PrintWriter pw=response.getWriter();
		if(balance==0)
		{
			pw.println("Invalid UserName/AccountNumber");
		}
		else
		{
			pw.println(balance);
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
