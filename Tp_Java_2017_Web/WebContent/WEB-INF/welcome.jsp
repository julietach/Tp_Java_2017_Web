<%@page import="java.util.ArrayList"%>
<%@page import="entity.Persona"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<h1>Bienvenido <%=((Persona)session.getAttribute("user")).getNombre() %></h1>
	<table>
		<%
			ArrayList<Persona>listaPers= (ArrayList<Persona>)request.getAttribute("listaPersonas");
			for(Persona p : listaPers){
		%>
		<tr>
			<td><%=p.getDni() %></td>
			<td><%=p.getApellido() %></td>
			<td><%=p.getNombre() %></td>
		</tr>
		<%
			}
		%>
	</table>
</head>
<body>
	<ul id=”menu”>
<li><a href=”#”>PERSONA</a>
<ul>
<li><a href=”persona.jsp”>AMBCPersona</a></li>
<li><a href=”#”>submenu1</a></li>
<li><a href=”#”>submenu1</a></li>
</ul>
</li>
<li><a href=”#”>Opcion 2</a>
<ul>
<li><a href=”#”>submenu2</a></li>
<li><a href=”#”>submenu2</a></li>
<li><a href=”#”>submenu2</a></li>
</ul>
</li>
<li><a href=”#”>Opcion 3</a>
<ul>
<li><a href=”#”>submenu3</a></li>
<li><a href=”#”>submenu3</a></li>
<li><a href=”#”>submenu3</a></li>
</ul>
	
</body>
</html>