<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="controller.*" %>
<%@ page import="java.util.*" %>
<%@ page import="model.entity.Profesor" %>

<% Profesor r = (Profesor)request.getAttribute("profesores");%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
<title>EDITAR</title>
</head>
<body>
	<span class="nav"><a href="index.html">BACK</a></span>
	<ul class="navbar">
		<li><a href="index.html">Pagina principal</a>
		<li><a href ="/Profesores">Lista de Profesores</a>
	</ul>
<span class="title">
		<h1 align="center">EDITAR PROFESOR</h1>
	</span> 
	<p /> 
	<p></p>
	
	<form method="post" action="/profesores/update?profesoresId=<%= r.getId() %>">
		<h3>Id <%=r.getId()%></h3>
		<table border="0" cellspacing="1" cellpadding="5" bgcolor="#CCCCCC">
		<tr>
				<td style="color: #ffffff; font-weight: bold;">Nombre del profesor:</td>
				<td bgcolor="#ffffff"><input type="text" name="name" value="<%=r.getName() %>" placeholder="Ingrese Nombres y Apellidos" required></td>
			</tr>
			<tr>
				<td style="color: #ffffff; font-weight: bold;">Teléfono:</td>
				<td bgcolor="#ffffff"><input type="number" pattern="[0-9]{6,9}" placeholder="Ingrese Telefono (Ejem: 987654321 | 338487)" min="0" value="<%=r.getTelefono() %>" name="telefono" required></td>
			</tr>
			<tr>
				<td style="color: #ffffff; font-weight: bold;">Correo Electrónico:</td>
				<td bgcolor="#ffffff"><input type="email" name="email" value="<%= r.getEmail()%>" placeholder="Ingrese correo electronico"></td>
			</tr>
			<tr>
				<td style="color: #ffffff; font-weight: bold;">Edad:</td>
				<td bgcolor="#ffffff"><input type="number" name="edad" pattern="[0-9]" min="1" value="<%=r.getEdad() %>" placeholder="Ingrese Edad" required></td>
			</tr>	
		
			<td style="color: #ffffff; font-weight: bold;">Nivel en el que enseña: </td>
				<td><select name="gEstudios" style="width: 150px" value="<%=r.getgEstudios()%>">
						<option>Inicial</option>
						<option>Primaria</option>
						<option>Secundaria</option>
				</select></td>
				
				<tr>
				<td style="color: #ffffff; font-weight: bold;">Genero: </td>
				<td><select name="genero" style="width: 150px" value="<%=r.getGenero()%>">
						<option>Masculino</option>
						<option>Femenino</option>
				</select></td>
			</tr>
		

			<tr>
				<td colspan="2" bgcolor="#ffffff" align="center"><input
					type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>