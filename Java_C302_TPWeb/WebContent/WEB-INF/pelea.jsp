<%@page import="entidades.Personaje"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>War!!</title>
</head>
<body>
	<h1>¡Pelea!</h1>
	<% 
		Personaje p1= ((Personaje)session.getAttribute("P1"));
		Personaje p2= ((Personaje)session.getAttribute("P2"));
		int turno = ((Integer)session.getAttribute("Turno"));
	%>
	<%=p1.getCodigo()+" "+p1.getNombre() %>
	<%=p2.getCodigo()+" "+p2.getNombre() %>
	
	    <div class="container">
	<% if(turno==1){%>
      <form class="form-signin" name="signin" action="Ataque" method="post">
        <h2 class="form-signin-heading"><%=p1.getNombre() %></h2><br>
        <label for="inputPersonaje1" class="sr-only">Vida</label><br/>
        <input class="form-control" value="<%=p1.getVida() %>" required="" autofocus="" type="text" readonly="readonly"><br/>
        <input class="form-control" value="<%=p1.getEnergia() %>" required="" autofocus="" type="text" readonly="readonly"><br>
        
        
        <input name="turno" type="hidden" value="1">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Atacar!</button>
      </form>
      
      <form class="form-signin" name="signin" action="Defensa" method="post">
        <h2 class="form-signin-heading">Choose your warriors</h2>
        <label for="inputPersonaje1" class="sr-only"><%=p1.getNombre() %></label>
        <input name="turno" type="hidden" value="1">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Defender!</button>
      </form>
	<% } else { %>
	<form class="form-signin" name="signin" action="Ataque" method="post">
        <h2 class="form-signin-heading">Choose your warriors</h2>
        <label for="inputPersonaje2" class="sr-only"><%=p2.getNombre() %></label>
        <input name="turno" type="hidden" value="2">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Atacar!</button>
      </form>
      
      <form class="form-signin" name="signin" action="Defensa" method="post">
        <h2 class="form-signin-heading">Choose your warriors</h2>
        <label for="inputPersonaje2" class="sr-only"><%=p1.getNombre() %></label>
        <input name="turno" type="hidden" value="2">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Defender!</button>
      </form>
      <% }%>
      
    </div> <!-- /container -->
	
</body>
</html>