package in.swetha.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.swetha.service.TouristPlaceService;

/**
 * Servlet implementation class DeleteTouristPlacesServlet
 */
@WebServlet("/DeleteTouristPlaceServlet")
public class DeleteTouristPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String TouristPlace=request.getParameter("touristPlace");
			TouristPlaceService.deleteTouristPlace(TouristPlace);
			
			
			{
				response.sendRedirect("ListTouristPlaces.jsp");
			}
		
}
}
