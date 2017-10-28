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

      <form class="form-signin" name="PER" action="Personas" method="post">
     
        <h2 class="form-signin-heading"> Persona</h2>
        <label for="inputdni" class="sr-only">DNI</label>
        <input name="tipodni" id="inputdni" class="form-control" placeholder="" required="" autofocus="" type=""> 
        <button class="btn btn-agregar btn-primary btn-block" type="submit">Buscar</button>
        <br><br><label for="inputNombre" class="sr-only">Nombre:</label>
        <input name="nombre" id="inputnombre" class="form-control" placeholder="" required="" type="">
      
        <br><br><label for="inputApellido" class="sr-only">Apellido:</label>
        <input name="apellido" id="inputapellido" class="form-control" placeholder="" required="" type=""><br><br>
     
        <label for="inputEmail" class="sr-only">Email:</label>
        <input name="email" id="inputemail" class="form-control" placeholder="" required="" type="">
      
        <label for="inputCategoria" class="sr-only"><br><br>Categoria:</label>
        <input name="categoria" id="inputcategoria class="form-control" placeholder="" required="" type="">
     
			<br><br><input type="checkbox">
			<label for="inputHabilitado" class="sr-only">Habilitado</label>
			
        <br><br><button class="btn btn-agregar btn-primary btn-block" type="submit">Agregar</button>
        <button class="btn btn-modificar btn-primary btn-block" type="submit">Modificar</button>
        <button class="btn btn-borrar btn-primary btn-block" type="submit">Borrar</button>
        
      </form>

    </div> <!-- /container -->
</body>
</html>