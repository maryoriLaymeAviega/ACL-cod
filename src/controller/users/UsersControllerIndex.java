package controller.users;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.Resource;
import model.entity.Role;
import model.entity.User;

public class UsersControllerIndex extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PersistenceManager pm = PMF.get().getPersistenceManager();
			List<User> user = (List<User>) pm.newQuery(User.class).execute();
			request.setAttribute("current", user);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/WEB-INF/Views/Users/index.jsp");
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