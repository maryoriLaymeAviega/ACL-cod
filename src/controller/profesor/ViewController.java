package controller.profesor;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.Profesor;

public class ViewController extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("../profesores");
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Profesor.class.getSimpleName(), Long.parseLong(request.getParameter("profesoresId")));
		Profesor r = pm.getObjectById(Profesor.class, k);
		request.setAttribute("profesores", r);
		request.getRequestDispatcher("/WEB-INF/Views/Profesores/view.jsp").forward(request, response);
		pm.close();
		
	}
}

