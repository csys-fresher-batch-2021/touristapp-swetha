package in.swetha.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddTouristPlacesServlet
 */
@WebServlet("/AddTouristPlacesServlet")
public class AddTouristPlacesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String touristPlace = request.getParameter("TouristPlace");
		out.println(touristPlace);
		Integer packageAmount = Integer.parseInt(request.getParameter("PackageAmount"));
		out.println(packageAmount);
		boolean isAdded = ListOfTouristPlaces.addTouristPlace(touristPlace, packageAmount);
		if (isAdded)

		{
			response.sendRedirect("ListTouristPlaces.jsp");
		} else {
			String errorMessage = "Unable to add places";
			response.sendRedirect("ListTouristPlaces.jsp?errorMessage=" + errorMessage);
		}

	}
}
