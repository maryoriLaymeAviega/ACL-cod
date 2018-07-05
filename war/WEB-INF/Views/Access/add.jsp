<%@   page import="java.util.List"%>
<%@  page import="model.entity.Role"%>
<%@  page import="model.entity.Resource"%>
<%
	List<Role> roles = (List<Role>) request.getAttribute("roles");
	List<Resource> resources =(List<Resource>)request.getAttribute("resources");
%>
<html>
<body>
	
	<form>
		<p>Seleccione Rol</p>
		<%if(roles.size()>0){ %>
		<select name="role">
			<% for(int i =0 ; i<roles.size(); i++){ 
				Role rol = roles.get(i);%>
			<option><%=rol.getType() %></option>
			<%} %>
		</select>
		<%} else {%>
		<p>Sin roles</p>
		<%} %>
		<%if(resources.size()>0){ %>
		<p>Seleccione Recurso</p>
		<select name="reso">
			<% for(int i=0; i<resources.size();i++){ 
				Resource res = resources.get(i);
				%>
				<option><%= res.getSrc() %></option>
			<%} %>
		</select>
		<%} else{ %>
		<p>Sin recursos</p>
		<%} %>
	</form>


</body>

</html>