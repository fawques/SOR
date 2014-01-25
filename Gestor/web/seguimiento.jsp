<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Seguimiento</title>
<link rel="stylesheet" href="estilos.css" type="text/css" media="screen" /> 
</head>
<body>
<p class="centrado">Seguimiento pedidos</p>

<%
     
    %>

<br>
<table class="centrado">
<tr>
<th>ID</th>
<th>Pedido</th>
<th>Fecha alta</th>
<th>Desguace</th>
<th>Importe</th>
</tr>
<tr>
<%
CÓDIGO %>
</tr>
</table>
<br>
   <a href="gestion.jsp"><input class="centrado" type="button" name="pedido" value="Atras"></a>
   <input class="centrado-1" type="button" name="pedido" value="Cancelar pedido">
   <input class="centrado-1" type="button" name="pedido" value="Ver ofertas">
   <form action="actualizarOfetasYPedidos" method="post">
       <input class="centrado-1" type="submit" value="Actualizar">
   </form>
</body>
</html>
