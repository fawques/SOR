<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Gestion de pedidos</title>
<link rel="stylesheet" href="estilos.css" type="text/css" media="screen" /> 
</head>
<body>
    <%
        /*if(request.getAttribute("usuario")==null){
            System.out.println("No hay usuario");
            response.sendRedirect("index.jsp");
        }*/
    %>
<p class="centrado">Bienvenido</p>
<a href="hacerPedido.jsp" type="button" class="centrado" style="width:150px;height:80px;position:relative;float:left;" name="pedido" >Nuevo pedido</a>
    <a href="" type="button" style="width:150px;height:80px;position:relative;float:left;" name="cuenta" >Mi cuenta</a>
    <a href="seguimiento.jsp" type="button" style="width:150px;height:80px;position:relative;float:left;" name="seguimiento" value="Seguimiento pedidos" >Seguimiento pedidos</a>
    <a href="ofertas.jsp" type="button" class="centrado" style="width:150px;height:80px;position:relative;float:left;" name="historico" value="Historico pedidos">Historico pedidos</a>
    <a href="index.jsp" type="button" name="pedido" value="Cerrar sesion" style="width:150px;height:30px;position:relative">Cerrar sesion</a>
</body>
</html>
