<%@page import="controlers.CtrlABMCElemento"%>
<%@page import="entity.Elemento"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">

      <form class="form-signin" name="signin" action="start" method="post">
      
        <h2 class="form-signin-heading">  Elemento</h2>
        <label for="inputElemento" class="sr-only"> Elemento</label>
        <input name="elemento" id="inputelemento" class="form-control" placeholder="" required="" autofocus="" type="">
       
        <br><br><label for="inputTipoDeElemento" class="sr-only">Tipo de elemento</label> 
        <%CtrlABMCElemento ctrl=new CtrlABMCElemento();
			ArrayList<Elemento> els= new ArrayList<Elemento>();
			els=ctrl.getAll();
		%><select style="width: 101px; ">
		<%	for(Elemento e : els){%>
			<option value="<%=e.getNombre_El() %>"><%=e.getNombre_El() %></option>
		<%
			}
		%> 
		</select><br>
        
			
    
      
        <button class="btn btn-agregar btn-primary btn-block" type="submit">Agregar</button>
        <button class="btn btn-modificar btn-primary btn-block" type="submit">Modificar</button>
        <button class="btn btn-borrar btn-primary btn-block" type="submit">Borrar</button>
    
      </form>

</body>
</html>