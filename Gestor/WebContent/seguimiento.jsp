<%@page import="general.EstadoPedido"%>
<%@page import="java.lang.reflect.Type"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="general.Pedido"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Seguimiento</title>
<link rel="stylesheet" href="estilos.css" type="text/css" media="screen" /> 
</head>
<body>
<p class="centrado">Seguimiento pedidos</p>
<br>
<table class="centrado">
<tr>
<th>Id pedido<th>
<th>Nombre</th>
<th>Fecha alta</th>
<th>Fecha Limite</th>
<th>Estado</th>
<th>Automatico</th>
</tr>
<tr>
<%
    String cookieName = "pedidos";
        Cookie cookies[] = request.getCookies();
        Cookie myCookie = null;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(cookieName)) {
                    myCookie = cookies[i];
                    break;
                }
            }
        }

        if (myCookie != null) {
            ArrayList<Pedido> alP = new ArrayList<Pedido>();        
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            Type collectionType = new TypeToken<ArrayList<Pedido>>() {
                }.getType();
            alP = gson.fromJson(myCookie.getValue(), collectionType);
            for(int i=0; i<alP.size(); i++){
            	if(alP.get(i).getEstado() == EstadoPedido.ACTIVE || alP.get(i).getEstado() == EstadoPedido.ACCEPTED){
	            	out.println("<tr><td>"+alP.get(i).getID()+"</td>");
	                out.println("<td>"+alP.get(i).getTallerNombre()+"</td>");
	                out.println("<td>"+alP.get(i).getFecha_alta()+"</td>");
	                out.println("<td>"+alP.get(i).getFecha_limite()+"</td>");
	                out.println("<td>"+alP.get(i).getEstado()+"</td>");
	                out.println("<td>"+alP.get(i).getModoAutomatico()+"</td>");
	                out.println("<td><a href=CancelarPedido?ped="+alP.get(i).getID()+" >Cancelar</a></td>");
	                out.println("<td><a href=VerOfertas?ped="+alP.get(i).getID()+" >Ofertas</a></td></tr>");
            	}
            }
        }
        else{

        	System.out.println("No hay pedidos");
        }
%>
</tr>
</table>
<br>
   <a href="gestion.jsp"><input class="centrado" type="button" name="pedido" value="Atras"></a>
   <form action="actualizarPedidos" method="post">
       <input class="centrado-1" type="submit" value="Actualizar">
   </form>
</body>
</html>
