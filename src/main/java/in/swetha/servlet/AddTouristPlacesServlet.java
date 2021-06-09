package in.swetha.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.swetha.service.TouristPlaceService;
import in.swetha.validator.PlaceValidator;

/**
 * Servlet implementation class AddTouristPlacesServlet
 */
@WebServlet("/AddTouristPlacesServlet")
public class AddTouristPlacesServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * Servlet connection
		 */

		String touristPlace = request.getParameter("TouristPlace");
		Double packageAmount = Double.parseDouble(request.getParameter("PackageAmount"));
		String image = request.getParameter("photo");

		try {

			PlaceValidator.touristPlaceValidator(touristPlace, "Invalid Input To Insert Place");
			boolean isAdded =TouristPlaceService.addTouristPlace(touristPlace, packageAmount, image);

			if (!isAdded)

			{
				response.sendRedirect("ListTouristPlaces.jsp");
			} else {
				String errorMessage = "Place Already Exits";
				response.sendRedirect("AddTouristPlace.jsp?errorMessage=" + errorMessage);
			}
		}

		catch (Exception e) {
			response.sendRedirect("AddTouristPlace.jsp?errorMessage=" + e.getMessage());
			logger.info(e.getMessage());
		}
	}
	
}
