package controller.users;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import controller.PMF;
import model.entity.User;

public class UsersControllerDelete extends HttpServlet {
	PersistenceManager pm = PMF.get().getPersistenceManager();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Key k =	KeyFactory.createKey(User.class.getSimpleName(), Long.parseLong(request.getParameter("id")));
		User a = (User) pm.getObjectById(User.class, k);
		pm.deletePersistent(a);
		response.sendRedirect("/user/index");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
