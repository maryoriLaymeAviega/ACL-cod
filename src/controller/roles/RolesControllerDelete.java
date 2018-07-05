package controller.roles;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import controller.PMF;
import model.entity.Role;

public class RolesControllerDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public RolesControllerDelete() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Key k =	KeyFactory.createKey(Role.class.getSimpleName(), Long.parseLong(request.getParameter("id")));
			Role a = (Role) pm.getObjectById(Role.class, k);
			pm.deletePersistent(a);
			response.sendRedirect("/role/index");
		} catch (Exception e) {
			response.sendRedirect("/role/index");
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}