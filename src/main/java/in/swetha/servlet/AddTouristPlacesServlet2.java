package in.swetha.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;


import in.swetha.service.TouristPlaceService2;


/**
 * Servlet implementation class AddTouristPlacesServlet
 */
@WebServlet("/AddTouristPlacesServlet2")
public class AddTouristPlacesServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String touristPlace = request.getParameter("touristPlace");
		Double packageAmount = Double.parseDouble(request.getParameter("packageAmount"));
		
		PrintWriter out = response.getWriter();
	
		try {
			 TouristPlaceService2.addTouristPlace(touristPlace,packageAmount);

			JsonObject object = new JsonObject();
			object.addProperty("infoMessage", "Successfully Added");
			out.println(object);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			JsonObject object = new JsonObject();
			object.addProperty("errorMessage", e.getMessage());
			out.println(object);
		}
		
		out.flush();
	
		
		
	
	}

}

		
		
		


