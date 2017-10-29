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

      <form class="form-signin" name="signin" action="start" method="post" style="height: 259px; ">
     
        <h2 class="form-signin-heading"> Tipo de Elemento</h2>
        ID <label for="inputTipoElemento" class="sr-only"><input><br><br>Tipo de elemento</label>
        <input name="tipoDeElemento" id="inputTipoElemento" class="form-control" placeholder="" required="" autofocus="" type="">
       
        <br><br><label for="inputCantReserva" class="sr-only">Cant. de reserva maxima</label>
        <input name="cantDeResmax" id="inputcantDeResmax" class="form-control" placeholder="" required="" type="">
       
        <br><br><label for="inputTiempoLimite" class="sr-only">Tiempo Limite</label>
        <input name="tiempoLimite" id="inputtiempoLimite" class="form-control" placeholder="" required="" type="">
       
        <br><br><label for="inputDiasAnticipacion" class="sr-only">Dias Anticipacion</label>
        <input name="diasAnticipacion" id="inputdiasAnticipacion" class="form-control" placeholder="" required="" type=""><br><br>
       
        <button class="btn btn-agregar btn-primary btn-block" type="submit">Agregar</button>
        <button class="btn btn-modificar btn-primary btn-block" type="submit">Modificar</button>
        <button class="btn btn-borrar btn-primary btn-block" type="submit">Borrar</button>
       
      </form>

    </div> <!-- /container -->
    </body>
</html>