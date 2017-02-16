<%@page import="entidades.Personaje"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/start.css" rel="stylesheet">

<title>Pelea!</title>
</head>
<body>
	<h1>¡Pelea!</h1>
	<% 
		Personaje p1= ((Personaje)session.getAttribute("P1"));
		Personaje p2= ((Personaje)session.getAttribute("P2"));
    	boolean errorEnergia = (Boolean)(session.getAttribute("errorEnergia"));
    	boolean gano = (Boolean)(session.getAttribute("gano"));
		int turno = ((Integer)session.getAttribute("turno"));
	%>
	<%=p1.getCodigo()+" "+p1.getNombre() %>
	<%=p2.getCodigo()+" "+p2.getNombre() %><br/>
	<%=turno %>
	
	    <div class="container">
	<% if(gano != true){%>    
	<% if(turno==1){%>
	<div class="row">
	  <div class="col-md-6">
		  <form class="form-signin" name="signin" action="Ataque" method="post">
	        <h2 class="form-signin-heading"><strong><%=p1.getNombre() %></strong></h2><br>
	        <label for="inputPersonaje1" style="color: #000;">Vida:</label><br/>
	        <input class="form-control" value="<%=p1.getVidaPartida() %>" required="" autofocus="" type="text" readonly="readonly"><br/>
	        <label for="inputPersonaje1" style="color: #000;">Energia:</label><br/>
	        <input class="form-control" value="<%=p1.getEnergiaPartida() %>" required="" autofocus="" type="text" readonly="readonly"><br>
	        <label for="inputPersonaje1" style="color: #000;">Puntos de ataque:</label>
	        <input class="form-control"  required="" autofocus="" type="text" name="ptosAtaque"><br>
	         <% if(errorEnergia==true){%>
	         	<div  style="color: red;">La energia elegida supera los puntos disponibles</div>
	         	<%}%>
	        <input name="personajeActivo" type="hidden" value="1">
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Atacar!</button>
	      </form>
	      
	      <form class="form-signin" name="signin" action="Defensa" method="post">
	        <label for="inputPersonaje1" class="sr-only"><%=p1.getNombre() %></label>
	        <input name="personajeActivo" type="hidden" value="1">
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Defender!</button>
	      </form>
	  
	  </div>
  		<div class="col-md-6">
	        <h2 class="form-signin-heading"><%=p2.getNombre() %></h2><br>
	        <label for="inputPersonaje1" style="color: #000;">Vida:</label><br/>
	        <input class="form-control" value="<%=p2.getVidaPartida() %>" required="" autofocus="" type="text" readonly="readonly"><br/>
	        <label for="inputPersonaje1" style="color: #000;">Energia:</label><br/>
	        <input class="form-control" value="<%=p2.getEnergiaPartida() %>" required="" autofocus="" type="text" readonly="readonly"><br>
  			
  		
  		</div>
	</div>
      
	<% } else { %>
	<div class="row">
	  <div class="col-md-6">
		  <form class="form-signin" name="signin" action="Ataque" method="post">
	        <h2 class="form-signin-heading"><strong><%=p2.getNombre() %></strong></h2><br>
	        <label for="inputPersonaje1" style="color: #000;">Vida:</label><br/>
	        <input class="form-control" value="<%=p2.getVidaPartida() %>" required="" autofocus="" type="text" readonly="readonly"><br/>
	        <label for="inputPersonaje1" style="color: #000;">Energia:</label><br/>
	        <input class="form-control" value="<%=p2.getEnergiaPartida() %>" required="" autofocus="" type="text" readonly="readonly"><br>
	        <label for="inputPersonaje1" style="color: #000;">Puntos de ataque:</label>
	        <input class="form-control"  required="" autofocus="" type="text" name="ptosAtaque"><br>
	         <% if(errorEnergia==true){%>
	         	<div style="color: red;">La energia elegida supera los puntos disponibles</div>
	         	<%}%>
	        <input name="personajeActivo" type="hidden" value="2">
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Atacar!</button>
	      </form>
	      
	      <form class="form-signin" name="signin" action="Defensa" method="post">
	        <label for="inputPersonaje1" class="sr-only"><%=p2.getNombre() %></label>
	        <input name="personajeActivo" type="hidden" value="2">
	        <button class="btn btn-lg btn-primary btn-block" type="submit">Defender!</button>
	      </form>
	  
	  </div>
  		<div class="col-md-6">
	        <h2 class="form-signin-heading"><%=p1.getNombre() %></h2><br>
	        <label for="inputPersonaje1" style="color: #000;">Vida:</label><br/>
	        <input class="form-control" value="<%=p1.getVidaPartida() %>" required="" autofocus="" type="text" readonly="readonly"><br/>
	        <label for="inputPersonaje1" style="color: #000;">Energia:</label><br/>
	        <input class="form-control" value="<%=p1.getEnergiaPartida() %>" required="" autofocus="" type="text" readonly="readonly"><br>
  			
  		
  		</div>
	</div>
      <% }%>
      <% }else{%> 
      		<% if(turno == 1){%>
      			<h1> Gano jugador: <%=p1.getNombre()%></h1>
      		<% }else{%> 
      			<h1> Gano jugador: <%=p2.getNombre()%></h1>
     	 <% }%> 
      <% }%>
    </div> <!-- /container -->
	
</body>
</html>