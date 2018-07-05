package controller.roles;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.PMF;
import model.entity.Role;

@SuppressWarnings("serial")
public class RolesControllerAdd extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String name = request.getParameter("type");
			if(name!=null){
				Role a = new Role(name, true);
				pm.makePersistent(a);
				response.sendRedirect("/role");
			}else{
				RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Views/Roles/add.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}