package controller.profesor;

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.jdo.PersistenceManager;
import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.http.*;

import controller.PMF;
import model.entity.Profesor;

@SuppressWarnings("serial")

public class AddController extends HttpServlet {
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String res = request.getParameter("name");
		if (res != null) {
			String name = request.getParameter("name");
			String tel = request.getParameter("telefono");
			String email = request.getParameter("email");
			int edad = Integer.parseInt(request.getParameter("edad"));
			String gEstudios = request.getParameter("gEstudios");
			String genero = request.getParameter("genero");

			PersistenceManager pm = PMF.get().getPersistenceManager();
			Profesor nuevo = new Profesor(name, tel, email, edad, gEstudios, genero);
			try {
				response.sendRedirect("/profesores");
				pm.makePersistent(nuevo);
			} finally {
				pm.close();
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/Views/Profesores/add.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}