<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jugar JavaCraft!</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="http://getbootstrap.com/favicon.ico">

    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/start.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="style/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<%

	boolean p1Error = (Boolean)(session.getAttribute("p1Error"));
	boolean p2Error = (Boolean)(session.getAttribute("p2Error"));	
//System.out.println((Boolean)(session.getAttribute("p1Error")));

%>
    <div class="container">

      <form class="form-signin" name="signin" action="ElegirPersonaje" method="post">
        <h2 class="form-signin-heading">Choose your warriors</h2>
        <label for="inputPersonaje1" class="sr-only">Warrior 1</label>
        <input name="Personaje1" id="inputPersonaje1" class="form-control" placeholder="Warrior 1" required="" autofocus="" type="">
        <%if(p1Error == true){%>
        	<div  style="color: red;">Oopss!!! No existe el codigo de  personaje ingresado! </div>
        <% } %>
        <label for="inputPersonaje2" class="sr-only">Warrior 2</label>
        <input name="Personaje2" id="inputPersonaje2" class="form-control" placeholder="Warrior 2" required="" type="">
        <%if(p2Error == true){%>
        	<div  style="color: red;">Oopss!!! No existe el codigo de  personaje ingresado! </div>
        <% } %>   
        <button class="btn btn-lg btn-primary btn-block" type="submit">Play!</button>
      </form>

    </div> <!-- /container -->


    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="style/ie10-viewport-bug-workaround.js"></script>

</body>
</html>