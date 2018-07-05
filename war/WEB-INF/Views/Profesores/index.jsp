<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="controller.*" %>
<%@ page import="java.util.List" %>
<%@ page import="model.entity.Profesor" %>
<%
	List<Profesor>profesores=(List<Profesor>) request.getAttribute("profesores");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
<title>Mostrar Profesor</title>
</head>
<body>

<span class="nav"><a href="index.html">BACK</a></span>
	<ul class="navbar">
		<li><a href ="/profesores/add">Agregar profesor</a>
	</ul>
	<%
		if (profesores!=null){
	%>

	<table border="0" cellspacing="1" cellpadding="5"
		width="100%">
		<tr >
			<td style="font-weight: bold;">N°</td>
			<td style="font-weight: bold;">Nombre</td>
			<td style="font-weight: bold;">Teléfono</td>
			<td style="font-weight: bold;">Email</td>
			<td style=" font-weight: bold;">Edad </td>
			<td style="font-weight: bold;">Nivel en el que enseña </td>
			<td style=" font-weight: bold;">Genero </td>
			<td style=" font-weight: bold;">Acciones </td>
			
		</tr>
		<%
			for (int i=0 ; i<profesores.size(); i++) {
				Profesor c = (Profesor) profesores.get(i);
		%>
		<tr>
			<td> <%= i+1 %></td>
			<td><%=c.getName()%></td>
			<td> <%= c.getTelefono() %></td>
			<td><%=c.getEmail()%></td>
			<td><%=c.getEdad() %> </td>
			<td><%= c.getgEstudios()%></td>
			<td><%=c.getGenero()%></td></td>
			<td>
				<span><a href="/profesores/view?profesoresId=<%= c.getId() %>">Read</a></span>
				<span><a href="/profesores/delete?profesoresId=<%= c.getId() %>">Delete</a></span>
				<span><a href="/profesores/update?profesoresId=<%= c.getId() %>">Update</a></span>
			</td>
			</tr>
		<%
			}
		%>
	</table>

	<%
		} else{
	%>
		<tr><td>No hay profesores que mostrar</td></tr>
	<%} %>
	

</body>
</html>
