package bank_system;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;

/**
 * Servlet implementation class CloseServlet
 */
@WebServlet("/closeServlet")
public class CloseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
	String s1=request.getParameter("Account_no");
	String s2=request.getParameter("user_name");
	String s3=request.getParameter("password");
	CloseBean cb=new CloseBean();
	cb.setAccount_no(Integer.parseInt(s1));
	cb.setPassword(s3);
	cb.setUser_name(s2);
	CloseDAO cd =new CloseDAO();
	int r=cd.getResult(cb);
	PrintWriter pw=response.getWriter();
	if(r>0)
	{

		pw.println("Success");
		pw.println(cb.getAccount_no());
		pw.println(cb.getUser_name());
	}
	else
	{
		pw.println("Fail");
		
	}
	
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	
	}

}
