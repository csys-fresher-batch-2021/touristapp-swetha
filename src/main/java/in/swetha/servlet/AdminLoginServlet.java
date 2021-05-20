package in.swetha.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.swetha.service.AdminService;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String adminName=request.getParameter("adminname");
		String adminpassword=request.getParameter("adminpassword");
		boolean isValidLogin=AdminService.adminInfo(adminName,adminpassword);
		if(isValidLogin)
		{
			HttpSession session=request.getSession();
			session.setAttribute("LOGGED_IN_USER", adminName);
			response.sendRedirect("ListTouristPlaces.jsp?");
			
		}else
		{
			String errorMessage="Invalid Credentials";
			response.sendRedirect("Login.jsp?message="+errorMessage);
		}
		}
}

	
