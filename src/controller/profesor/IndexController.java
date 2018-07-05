package controller.profesor;

import java.io.IOException;
import java.util.List;

import javax.jdo.JDOFatalUserException;
import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PMF;
import model.entity.Profesor;

@SuppressWarnings("serial")
public class IndexController extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		String query = "select  from " + Profesor.class.getName();
		List<Profesor> profesores = (List<Profesor>) pm.newQuery(query).execute();
		request.setAttribute("profesores", profesores);
		request.getRequestDispatcher("/WEB-INF/Views/Profesores/index.jsp").forward(request, response);
		pm.close();
		
		
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		request.getRequestDispatcher("/WEB-INF/Views/Profesores/index.jsp").forward(request, response);
	}

}
