package in.swetha.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.swetha.service.UserService;
import in.swetha.validator.UserValidator;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("username");
		String password = request.getParameter("userpassword");

		try {
			UserValidator.isValidUserName(userName);
			UserValidator.isValidPassword(password);
			boolean isvalidLogin = UserService.validUserLogin(userName, password);// To Login Getting name and password
			if (isvalidLogin) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", userName);
				response.sendRedirect("ListTouristPlaces.jsp?");

			} else {
				String errorMessage = "Invalid Credentials";
				response.sendRedirect("CustomerLogin.jsp?message=" + errorMessage);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
			String errorMessage = e.getMessage();
			response.sendRedirect("CustomerLogin.jsp?message=" + errorMessage);
		}
	}
}
