package controller.profesor;

import java.io.IOException;	

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.Profesor;

public class DeleteController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Profesor.class.getSimpleName(),new Long(request.getParameter("profesoresId")).longValue());
		try {
			Profesor r = pm.getObjectById(Profesor.class, k);
			if (r != null) {
				Long id = r.getId();
				pm.deletePersistent(r);
				// req.getRequestDispatcher("/profesores").forward(request, response);
				response.sendRedirect("/profesores");
				pm.close();
			}
		} catch (JDOObjectNotFoundException e) {
			response.sendRedirect("/profesores");
			}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("/profesores");
	}

}