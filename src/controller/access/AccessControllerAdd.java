package controller.access;

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
import model.entity.Resource;
import model.entity.Access;

@SuppressWarnings("serial")
public class AccessControllerAdd extends HttpServlet {

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);	
		request.getRequestDispatcher("/WEB-INF/Views/Access/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String res = request.getParameter("role");
		if(res!=null){
			String rol = request.getParameter("role");
			String reso = request.getParameter("reso");
			PersistenceManager pm = PMF.get().getPersistenceManager();
			Access a = new Access(rol, reso);
			try{
				response.sendRedirect("/access");
				pm.makePersistent(a);
			}finally{
				pm.close();
			}
		}else{
			PersistenceManager pm = PMF.get().getPersistenceManager();
			String query = "select from " +Role.class.getName();
			List<Role> roles = (List<Role>) pm.newQuery(query).execute();
			
			String query2 = "select from " + Resource.class.getName();
			List<Resource> resources = (List<Resource>) pm.newQuery(query2).execute();
			
			request.setAttribute("roles", roles);
			request.setAttribute("resources", resources);
			request.getRequestDispatcher("/WEB-INF/Views/Access/add.jsp");
		}
	}

}
