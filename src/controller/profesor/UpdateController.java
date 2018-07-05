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

@SuppressWarnings("serial")
public class UpdateController extends HttpServlet {
	@SuppressWarnings("unchecked")
  
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Profesor.class.getSimpleName(),new Long(req.getParameter("profesoresId")).longValue());
		Profesor r = pm.getObjectById(Profesor.class, k);

		req.setAttribute("profesores", r);

		req.getRequestDispatcher("/WEB-INF/Views/Profesores/update.jsp").forward(req, resp);
		pm.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Key k = KeyFactory.createKey(Profesor.class.getSimpleName(),new Long(request.getParameter("profesoresId")).longValue());
		Profesor r = pm.getObjectById(Profesor.class, k);
		String name = request.getParameter("name");
		String tel = request.getParameter("telefono");
		String email = request.getParameter("email");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String gEstudios = request.getParameter("gEstudios");
		String genero = request.getParameter("genero");

		r.setName(name);
		r.setTelefono(tel);
		r.setEmail(email);
		r.setEdad(edad);
		r.setgEstudios(gEstudios);
		r.setGenero(genero);


		response.sendRedirect("../profesores");
		response.getWriter().println("Profesor actualizado");

	}

}
