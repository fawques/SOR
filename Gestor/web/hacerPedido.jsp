<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Hacer pedido</title>
<link rel="stylesheet" href="estilos.css" type="text/css" media="screen" /> 
</head>
<p class="centrado">Pedido</p>
<div id="detalle" class="centrado">
    <p >Descripcion detallada de las piezas</p>
   <form action="login" method="POST">
         <input type="input" name="piezas" style="width:300px;">
     </div>
    <div id="cantidad" class="centrado">
        <p >Cantidad</p>
        <input type="input" name="cantidad" style="width:50px;">
      </div>
      <br>
    <input class="centrado" type="submit" name="anadir" value="Anadir a pedido"><br>
</form>

	<p class="centrado">Fecha max. entrega</p>
<input class="centrado" type="date" name="fecha">

	<p class="centrado">Modo:</p>
	<input type="checkbox" class="centrado" name="modo" value="Automatico">Automatico<br>
    
	
<br>
<br>
   <input class="centrado" type="button" name="pedido" value="Confirmar envio">
   <a href="gestion.jsp"> Cancelar </a>
<body>
</body>
</html>
