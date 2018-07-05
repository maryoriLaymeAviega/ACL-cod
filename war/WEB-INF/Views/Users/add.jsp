
<%@   page import="java.util.List"%>
<%@  page import="model.entity.Role"%>
<%
	List<Role> cur = (List<Role>) request.getAttribute("current");
%>
<html>
<body>
	<%if(cur.size()>0){ %>
	<form>
		<select name="roleId">
			<% for(int i=0;i<cur.size();i++){%>
			<option value="<%=cur.get(i).getId()%>" <%if(i==0)out.print("selected"); %>><%=cur.get(i).getType()%></option>
			<% } %>
		</select> <input type="email" name="email"> <input type="submit">
	</form>
	<%}else{ out.print("<p>No tiene roles creados</p>");}%>
</body>

</html>