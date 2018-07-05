<%@page import="sun.security.util.Length"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="controller.*"%>
<%@ page import="java.util.List"%>
<%@ page import="model.entity.Resource"%>

<%
	List<Resource> cur = (List<Resource>) request.getAttribute("current");
%>
<html>
<body>
	<table>
		<tr>
			<th>id</th>
			<th>type</th>
			<th>status</th>
		</tr>
		<%for(int i=0;i<cur.size();i++){ %>
		<tr>
			<td><%=cur.get(i).getId()%></td>
			<td><%=cur.get(i).getSrc()%></td>
			<td><%=cur.get(i).isStatus()%></td>
		</tr>
		<%} %>
	</table>
</body>

</html>