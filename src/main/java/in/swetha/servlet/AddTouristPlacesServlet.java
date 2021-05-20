package in.swetha.servlet;

import java.io.IOException;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.swetha.service.TouristPlaceService;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String touristPlace = request.getParameter("TouristPlace");
		Integer packageAmount = Integer.parseInt(request.getParameter("PackageAmount"));
		try {
			boolean isAdded = TouristPlaceService.addTouristPlace(touristPlace, packageAmount);

			if (!isAdded)

			{
				response.sendRedirect("ListTouristPlaces.jsp");
			} 
			else {
				String errorMessage="Invalid Place";
				response.sendRedirect("addTouristPlace,jsp?errorMessage="+errorMessage);
			}
		}
		catch (RuntimeException e) {
			response.sendRedirect("addTouristPlace.jsp?errorMessage=" + e.getMessage());
			logger.info(e.getMessage());
		}
	}
}
