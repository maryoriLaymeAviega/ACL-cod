<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ page import="controller.*" %>
<%@ page import="java.util.*" %>

<%@ page import="model.entity.Profesor" %>
<%
	List<Profesor> Profesores=(List<Profesor>) request.getAttribute("profesores");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
<title>AÑADIR</title>

</head>
<body>
	<span class="nav"><a href="index.html">BACK</a></span>
	<ul class="navbar">
		<li><a href ="/profesores">Mostrar lista de profesores</a>
	</ul>
	<span class="title">
		<h1 align="center">AGREGAR UN PROFESOR</h1>
	</span>
	<p />
	<p></p>
	<form method="post" action="/profesores/add">
		<input type="hidden" name="action" value="crearProfesor" />
		<table border="0" cellspacing="1" cellpadding="5">
			<tr>
				<td style="font-weight: bold;">Nombre del profesor:</td>
				<td bgcolor="#ffffff"><input type="text" name="name" placeholder="Ingrese Nombres y Apellidos" required></td>
			</tr>
			<tr>
				<td style="font-weight: bold;">Teléfono:</td>
				<td bgcolor="#ffffff"><input type="number" pattern="[0-9]{6,9}" min="0" name="telefono" placeholder="Ingrese Telefono (Ejem: 987654321 | 338487)" required></td>
			</tr>
			<tr>
				<td style="font-weight: bold;">Correo Electrónico:</td>
				<td bgcolor="#ffffff"><input type="email" name="email" required placeholder="Ingrese correo electronico"></td>
			</tr>
			<tr>
				<td style=" font-weight: bold;">Edad:</td>
				<td bgcolor="#ffffff"><input type="number" pattern="[0-9]" min="1" name="edad" placeholder="Ingrese Edad" required></td>
			</tr>
		
			<td style="font-weight: bold;">Nivel en el que enseña: </td>
				<td><select name="gEstudios" style="width: 150px">
						<option>Inicial</option>
						<option>Primaria</option>
						<option>Secundaria</option>
				</select></td>
				
				<tr>
				<td style=" font-weight: bold;">Genero: </td>
				<td><select name="genero" style="width: 150px">
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