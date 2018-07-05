
<%@ page import="controller.*" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UFT-8">
<title>ELIMINAR</title>
</head>
<body>
	<span class="nav"><a href="index.html">BACK</a></span>
	<ul class="navbar">
	<ul class="navbar">
	<li><a href="index.html">Pagina principal</a>
		<li><a href ="add.jsp">Agregar profesor</a>
		<li><a href ="view.jsp">Mostrar profesor</a>
		<li><a href ="delete.jsp">Eliminar profesor</a>
		<li><a href ="find.jsp">Editar profesor</a>
	</ul>
	<span class="title">
		<h1 align="center">ELIMINAR PROFESOR</h1>
	</span>
	<p />
	<p></p>
	<form method="post" action="users/delete">
		<input type="hidden" name="action" value="eliminarProfesor" />
		<table border="0" cellspacing="1" cellpadding="5" bgcolor="#CCCCCC">
			<tr bgcolor="#A84087">
				<td style="color: #ffffff; font-weight: bold;">Nombre del Profesor: </td>
				<td bgcolor="#ffffff"><input type="input" name="name" required></td>
			</tr>
			<tr>
				<td colspan="2" bgcolor="#ffffff" align="center"><input
					type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>