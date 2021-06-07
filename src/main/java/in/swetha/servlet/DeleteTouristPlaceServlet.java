package in.swetha.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.swetha.exception.DBException;
import in.swetha.model.Tourist;
import in.swetha.service.TouristPlaceService;


/**
 * Servlet implementation class DeleteTouristPlacesServlet
 */
@WebServlet("/DeleteTouristPlaceServlet")
public class DeleteTouristPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		try {
			String touristPlace = request.getParameter("TouristPlace");
			List<Tourist> isDeleted=TouristPlaceService.deletePlace(touristPlace) ;
			if(isDeleted != null)
			{	
				String message="Package Deleted Successfully";
				response.sendRedirect("ListTouristPlaces.jsp?message="+message);
			}
			
			
		}  catch (SQLException | DBException e) {
			
			e.getMessage();
		}
		
	}
}
