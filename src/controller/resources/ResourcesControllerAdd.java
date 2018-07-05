package controller.resources;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PMF;
import model.entity.Resource;

@SuppressWarnings("serial")
public class ResourcesControllerAdd extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String name = request.getParameter("type");
			if(name!=null){
				Resource a = new Resource(name);
				pm.makePersistent(a);
				response.sendRedirect("/resource");
			}else{
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Views/Resources/add.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
