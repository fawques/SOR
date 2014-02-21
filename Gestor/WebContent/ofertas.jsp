<%@page import="java.lang.reflect.Type"%>
<%@page import="com.google.gson.reflect.TypeToken"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="general.Oferta"%>
<%@page import="java.util.ArrayList"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>Ofertas recibidas</title>
<link rel="stylesheet" href="estilos.css" type="text/css" media="screen" /> 
</head>
<p class="centrado">Ofertas recibidas</p>
<div id="datosPedido" class="centrado">
<table class="centrado">
<tr>
<th>Id<th>
<th>Pedido</th>
<th>Desguace</th>
<th>Fecha alta</th>
<th>Fecha Limite</th>
<th>Importe</th>
<th>Estado</th>
<th>Automatico</th>
</tr>
<%
    String cookieName = "ofertas";
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
            ArrayList<Oferta> alP = new ArrayList<Oferta>();        
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            Type collectionType = new TypeToken<ArrayList<Oferta>>() {
                }.getType();
            alP = gson.fromJson(myCookie.getValue(), collectionType);
            for(int i=0; i<alP.size(); i++){
            	out.println("<tr><td>"+alP.get(i).getID()+"</td>");
                out.println("<td>"+alP.get(i).getPedido()+"</td>");
                out.println("<td>"+alP.get(i).getDesguaceNombre()+"</td>");
                out.println("<td>"+alP.get(i).getFecha_alta()+"</td>");
                out.println("<td>"+alP.get(i).getFecha_limite()+"</td>");
                out.println("<td>"+alP.get(i).getPrecio()+"</td>");
                out.println("<td>"+alP.get(i).getEstado()+"</td>");
                out.println("<td><a href=RechazarOferta?oferta="+alP.get(i).getID()+" >Rechazar</a></td>");
                out.println("<td><a href=AceptarOferta?oferta="+alP.get(i).getID()+" >Aceptar</a></td></tr>");
            }
        }
        else{

        	System.out.println("No hay ofertas");
        }
%>

</table>
</div>
<br>
<br>
   <a href="gestion.jsp" class="centrado">
   	Atras  </a>
<body>
</body>
</html>
