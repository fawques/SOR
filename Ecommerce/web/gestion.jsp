<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Gestion de pedidos</title>
<link rel="stylesheet" href="estilos.css" type="text/css" media="screen" /> 
</head>
<body>
    <%
        if(session.getAttribute("usuario")==null){
            response.sendRedirect("index.jsp");
        }
    %>
<p class="centrado">Bienvenido</p>
 <input type="button" class="centrado" style="width:150px;height:80px;position:relative;float:left;" name="pedido" value="Hacer pedido">
  <input type="button" style="width:150px;height:80px;position:relative;float:left;" name="cuenta" value="Mi cuenta">
  <input type="button" style="width:150px;height:80px;position:relative;float:left;" name="seguimiento" value="Seguimiento pedidos">
  <input type="button" class="centrado" style="width:150px;height:80px;position:relative;float:left;" name="historico" value="Historico pedidos">
  <input type="button" name="pedido" value="Cerrar sesion" style="width:150px;height:30px;position:relative">
</body>
</html>
