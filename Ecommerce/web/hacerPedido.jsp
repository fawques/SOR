<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Documento sin título</title>
<link rel="stylesheet" href="estilos.css" type="text/css" media="screen" /> 
</head>
<form action="nuevoPedido" method="POST">
<p class="centrado">Pedido</p>
<div id="detalle" class="centrado">
    <p >Descripción detallada de las piezas</p>
     <input type="input" name="piezas" style="width:300px;">
 </div>
<div id="cantidad" class="centrado">
 	<p >Cantidad</p>
  	<input type="input" name="cantidad" style="width:50px;">
  </div>
  <br>
<input class="centrado" type="button" name="anadir" value="Añadir a pedido"><br>

<p class="centrado">Calidad</p>
  <select name="programa" class="centrado">    
       <option value="Windows" selected="selected">Windows</option>
       <option value="Machintosh">Mac</option>
       <option value="Linux">Linux</option>
   </select>
   
	<p class="centrado">Fecha máx. entrega</p>
<input class="centrado" type="date" name="fecha">

	<p class="centrado">Si la decisión debe tomarse de forma AUTOMÁTICA, por favor indique:</p>

    <input class="centrado" type="radio" name="decision" value="pvp" />PVP mínimo <br>
    <input class="centrado" type="radio" name="decision" value="fecha" />Fecha entrega más próxima

<br>
<br>
   <input class="centrado" type="submit" name="pedido" value="Confirmar envío">
   <input class="centrado-1" type="button" name="pedido" value="Cancelar">
   <input class="centrado-1" type="button" name="pedido" value="Cerrar sesión">
</form>
<body>
</body>
</html>
