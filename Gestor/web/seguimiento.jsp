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
<th>ID</th>
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
            Gson gson = new GsonBuilder().setDateFormat("MMM dd, yyyy hh:mm:ss a").create();
            Type collectionType = new TypeToken<Pedido>() {
                }.getType();
            alP = gson.fromJson(myCookie.getValue(), collectionType);
            for(int i=0; i<alP.size(); i++){
                out.println("<td>"+alP.get(i).getID()+"</td>");
                out.println("<td>"+alP.get(i).getFecha_alta()+"</td>");
                out.println("<td>"+alP.get(i).getFecha_limite()+"</td>");
                out.println("<td>"+alP.get(i).getEstado()+"</td>");
                out.println("<td>"+alP.get(i).getModoAutomatico()+"</td>");
            }
        }
%>
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
