package controller.users;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.PMF;
import model.entity.Role;
import model.entity.User;

@SuppressWarnings("serial")
public class UsersControllerAdd extends HttpServlet {
	PersistenceManager pm = PMF.get().getPersistenceManager();

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {
			String mail = request.getParameter("email");
			if(mail==null){
				List<Role> roles = (List<Role>)pm.newQuery(Role.class).execute();
				request.setAttribute("current",roles);		 
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Users/add.jsp"); 
				dispatcher.forward(request, response);
			}else {
				User b=new User(mail,Long.parseLong(request.getParameter("roleId")));
				pm.makePersistent(b);
				response.sendRedirect("/user");
			}
		} catch (Exception e) {
			request.setAttribute("message", e.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/Views/Errors/error.jsp");
			rd.forward(request, response);
		}
		 	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}