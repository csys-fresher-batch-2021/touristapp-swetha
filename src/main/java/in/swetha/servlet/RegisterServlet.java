package in.swetha.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.swetha.model.User;
import in.swetha.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//getting names,paasword,mobilenumber to register
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		long mobileNo = Long.parseLong(request.getParameter("mobilenumber"));
		try {
			User user = new User(userName, password, mobileNo);
			UserService.adduser(user);
			boolean isValidRegister = UserService.validRegister(user);// validating user details
			if (isValidRegister) {
				String infoMessage = "Registerd successfully";
				response.sendRedirect("CustomerLogin.jsp?infoMessage=" + infoMessage);
			} else {
				String errorMessage = "Invalid credentials";
				response.sendRedirect("Register.jsp?errorMessage=" + errorMessage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.sendRedirect("Register.jsp?errorMessage=" + errorMessage);
		}

	}

}
