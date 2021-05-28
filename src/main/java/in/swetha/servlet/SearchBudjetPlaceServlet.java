package in.swetha.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.swetha.model.Tourist;
import in.swetha.service.TouristPlaceService;

/**
 * Servlet implementation class SearchBudjetPlaceServlet
 */
@WebServlet("/SearchBudjetPlaceServlet")
public class SearchBudjetPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double packageAmount = Double.parseDouble(request.getParameter("PackageAmount"));
		
		List<Tourist> isBudjet=TouristPlaceService.searchPlace(packageAmount);
		if(isBudjet != null)
		{
			response.sendRedirect("SearchBudjetList.jsp"); 
		}else
		{
			System.out.println("No Record");
		}
		
		
	}
}