package bank_system;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Create_account
 */
@WebServlet("/Create_account")
public class Create_account extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Create_account() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String s2=request.getParameter("un");
			String s3=request.getParameter("PW");
			String s4=request.getParameter("RPW");
			String s5=request.getParameter("AMOUNT");
			String s6=request.getParameter("ADDRESS");
			String s7=request.getParameter("PHONE");
			CreateBean cb=new CreateBean();
			cb.setUN(s2);
			if(s3.equals(s4)) {
				cb.setPW(s3);
			}
			else
			{
				System.out.println("invalid password");
			}
			cb.setAMOUNT(Long.parseLong(s5));
			cb.setADDRESS(s6);
			cb.setPHONE(Long.parseLong(s7));
			
			CreateDAO da=new CreateDAO();
			int ac=da.getResult(cb);
			PrintWriter pw=response.getWriter();
			pw.println(ac);
		}
//			System.out.println(s1+" "+s2+" "+s3+" "+s4+" "+s5+" "+s6+" "+s7);
			
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}

}
