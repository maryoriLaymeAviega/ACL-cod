package controller.resources;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PMF;
import model.entity.Resource;

@SuppressWarnings("serial")
public class ResourcesControllerIndex extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			List<Resource> resources = (List<Resource>) pm.newQuery(Resource.class).execute();
			request.setAttribute("current", resources);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/Views/Resources/index.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}