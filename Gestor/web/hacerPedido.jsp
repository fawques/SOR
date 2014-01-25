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
     <input type="input" name="piezas" style="width:300px;">
 </div>
<div id="cantidad" class="centrado">
 	<p >Cantidad</p>
  	<input type="input" name="cantidad" style="width:50px;">
  </div>
  <br>
<input class="centrado" type="button" name="anadir" value="Anadir a pedido"><br>

	<p class="centrado">Fecha max. entrega</p>
<input class="centrado" type="date" name="fecha">

	<p class="centrado">Modo:</p>

    <select class="centrado" >
      <option value="volvo">Volvo</option>
      <option value="saab">Saab</option>
      <option value="mercedes">Mercedes</option>
      <option value="audi">Audi</option>
    </select>
    
	
<br>
<br>
   <input class="centrado" type="button" name="pedido" value="Confirmar envio">
   <a href="gestion.jsp"> Cancelar </a>
<body>
</body>
</html>
