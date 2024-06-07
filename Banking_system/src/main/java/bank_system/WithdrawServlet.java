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
@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
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
		WithdrawBean wb= new WithdrawBean();
		wb.setAccount_no(Long.parseLong(s1));
		wb.setUser_name(s2);
		wb.setPassword(s3);
		wb.setAmount(Integer.parseInt(s4));
		WithdrawDAO wd =new WithdrawDAO();
		int result=wd.getResult(wb);
		PrintWriter pw=response.getWriter();
		if(result==1)
		{
			pw.println("Your Amount is Withdraw Successfully");
		}
		else
		{
			pw.println("Incorrect Password/UserName");
		}
	
		
		
		
	}

}
