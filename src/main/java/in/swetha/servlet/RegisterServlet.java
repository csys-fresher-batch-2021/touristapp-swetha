package in.swetha.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.swetha.model.User;
import in.swetha.service.UserService;
import in.swetha.validator.UserValidator;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		try {
			
			String userName = request.getParameter("username");
			String password = request.getParameter("password");// getting names,password,mobilenumber to register
			long mobileNo = Long.parseLong(request.getParameter("mobilenumber"));
			UserValidator.isValidUserName(userName);
			UserValidator.isValidPassword(password);
			UserValidator.isValidMobileNumber(mobileNo);

			User user = new User(userName, password, mobileNo);
			boolean valid = UserService.adduserDetail(user);
			if (valid) {
				String message = "Registered SuccessFully";
				response.sendRedirect("UserLogin.jsp?message=" + message);
			} else {
				String message = "Customer Details Already Exists";
				response.sendRedirect("Register.jsp?message=" + message);
			}
		} catch (Exception e) {
			response.sendRedirect("Register.jsp?message=" + e.getMessage());

		}
	}
}