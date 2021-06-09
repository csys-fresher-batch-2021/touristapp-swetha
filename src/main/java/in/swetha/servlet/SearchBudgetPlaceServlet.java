package in.swetha.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.swetha.service.TouristPlaceService;

/**
 * Servlet implementation class SearchBudjetPlaceServlet
 */
@WebServlet("/SearchBudgetPlaceServlet")
public class SearchBudgetPlaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   @Override
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Double packageAmount = Double.parseDouble(request.getParameter("PackageAmount"));
		boolean isBudjet=TouristPlaceService.searchBudgetTouristPlace(packageAmount);
		if(isBudjet)
		{
			response.sendRedirect("SearchBudgetList.jsp"); 
		}else
		{
			response.sendRedirect("SearchBudgetPlace.jsp"); 
		}
		
		
	}catch(Exception e)
		{
		response.sendRedirect("SearchBudgetPlace.jsp"); 
		}
}
}