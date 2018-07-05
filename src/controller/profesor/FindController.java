package controller.profesor;
import java.util.*;
import java.io.IOException;  
import model.entity.Profesor;  
import javax.servlet.*;  
import javax.servlet.http.*;  
@SuppressWarnings("serial")

public class FindController extends HttpServlet {  
	@SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
		      
		 String name=request.getParameter("name");  
	       
		 Profesor nuevo= new Profesor(name, "null", "null",0,"null","null");
	    
	     if(getServletContext().getAttribute("profesores")!=null){
	    	 ArrayList <Profesor> profesores=(ArrayList<Profesor>)getServletContext().getAttribute("profesores");
	    	 for(int i=0;i<profesores.size();i++){
	    		 if(profesores.get(i).getName().equals(nuevo.getName())){
	    			 request.getSession().setAttribute("nameFind", name);
	    			 response.sendRedirect("../update.jsp");
	    		 }
	    		 else{
	    	    	 response.getWriter().println("NO EXISTE");
	    	    	 response.sendRedirect("../find.jsp");
	    	    
	    	      }
	    	 }
	     }
	     else{
	    	 response.sendRedirect("../WEB-INF/Views/Profesores/index.html");
	     }
	    
	  
	     
	}
}
