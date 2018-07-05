<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="controller.*" %>
<%@ page import="model.entity.Profesor" %>



<%
	Profesor profesor = (Profesor)request.getAttribute("profesores");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
<title>EDITAR</title>
</head>

<body>
	<span class="title">
		<h1 align="center">View PROFESOR</h1>
	</span>
	<ul class="navbar">
		<li><a href ="/profesores/add">Agregar profesor</a>
		<li><a href="/profesores/update?profesoresId=<%=profesor.getId()%>">Editar Profesor</a></li>
		<li><a href="/profesores/delete?profesoresId=<%=profesor.getId()%>">Eliminar Profesor</a></li>
		<li><a href="/profesores">Lista de Profesores</a></li>
	</ul>
	
	
		<h3>Profesor con id: <%=profesor.getId() %> </h3>
		<table border="0" cellspacing="1" cellpadding="5" bgcolor="#CCCCCC">
		<tr>
				<td style="font-weight: bold;">Nombre del profesor:</td>
				<td bgcolor="#ffffff"><%=profesor.getName() %></td>
			</tr>
			<tr>
				<td style="font-weight: bold;">Teléfono:</td>
				<td bgcolor="#ffffff"><%=profesor.getTelefono() %></td>
			</tr>
			<tr>
				<td style="font-weight: bold;">Correo Electrónico:</td>
				<td bgcolor="#ffffff"><%= profesor.getEmail() %> </td>
			</tr>
			<tr>
				<td style=" font-weight: bold;">Edad:</td>
				<td bgcolor="#ffffff"><%=profesor.getEdad() %></td>
			</tr>
			<tr>
				<td style="font-weight: bold;">Nivel en el que enseña: </td>
				<td><%= profesor.getgEstudios() %></td>
			</tr>	
			<tr>
				<td style=" font-weight: bold;">Genero: </td>
				<td><%= profesor.getGenero() %></td>
			</tr>
	</table>
	<a href="/profesores" class="btn btn-info"  role="button"  >Regresar </a>
</body>
</html>