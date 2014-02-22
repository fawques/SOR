<%@page import="gestor_admin.AdminWS"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Inicio sesion</title>
<link rel="stylesheet" href="estilos.css" type="text/css" media="screen" /> 
</head>
<body>
<p class="centrado">Inicio de sesion</p>
<form class="centrado" action="login" method="POST">
 Usuario (mail): <input type="text" name="usuario"><br>
 Contrasenya: <input type="password" name="contrasenya">
 <br>
 <br>

 <input type="submit" class="centrado" value="Acceder">
 <div style="color: #FF0000;">${errorMessage}</div>
 </form> 
<p class="centrado">No eres usuario? <a href="registro.jsp">Registrate</a></p>
</body>
</html>

