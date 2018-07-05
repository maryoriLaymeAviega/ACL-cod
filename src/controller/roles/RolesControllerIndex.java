package controller.roles;

import java.io.IOException;

import java.util.List;
import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.PMF;
import model.entity.Role;
@SuppressWarnings("serial")
public class RolesControllerIndex extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PersistenceManager pm = PMF.get().getPersistenceManager();			
			List<Role> roles = (List<Role>)pm.newQuery(Role.class).execute();
			request.setAttribute("current",roles);		 
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/WEB-INF/Views/Roles/index.jsp"); 
			dispatcher.forward(request, response); 	
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
			rd.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}