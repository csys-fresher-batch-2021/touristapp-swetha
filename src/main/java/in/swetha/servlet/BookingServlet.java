package in.swetha.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.swetha.exception.ValidDateException;

import in.swetha.validator.DateValidation;

/**
 * Servlet implementation class BookingServlet
 */
@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		LocalDate fromDate = LocalDate.parse(request.getParameter("startDate"));
		LocalDate toDate  = LocalDate.parse(request.getParameter("endDate"));
		try {
			if(DateValidation.dateValidationStart(toDate)&&DateValidation.dateValidationEnd(fromDate, toDate))
			{
				String infoMessage="Package Booked SuccessFully";
				response.sendRedirect("Booking.jsp?Booking Status="+infoMessage);
			}
		
		} catch (ValidDateException e) {
			response.sendRedirect("Booking.jsp?errorMessage=" + e.getMessage());
			logger.info(e.getMessage());
		
		}
	
}
}
