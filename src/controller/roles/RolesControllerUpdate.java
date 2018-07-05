package controller.roles;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.Role;

public class RolesControllerUpdate extends HttpServlet {
	PersistenceManager pm = PMF.get().getPersistenceManager();	
	private static final long serialVersionUID = 1L;
    public RolesControllerUpdate() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Key k =	KeyFactory.createKey(Role.class.getSimpleName(), Long.parseLong(request.getParameter("id")));
		Role a = (Role) pm.getObjectById(Role.class, k);		
		request.setAttribute("o",a);
		RequestDispatcher dispatcher =getServletContext().getRequestDispatcher("/Views/Roles/update.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Key k =	KeyFactory.createKey(Role.class.getSimpleName(), Long.parseLong(request.getParameter("id")));
		Role a = (Role) pm.getObjectById(Role.class, k);
		a.setStatus(Boolean.parseBoolean(request.getParameter("status")));
		a.setType(request.getParameter("src"));
		response.sendRedirect("/role/index");
	}

}