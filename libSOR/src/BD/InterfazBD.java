/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import general.Desguace;
import general.EstadoGeneral;
import general.EstadoOferta;
import general.EstadoPedido;
import general.Oferta;
import general.Pedido;
import general.Pieza;
import general.Taller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fawques
 */
public class InterfazBD {

    Conexion conexion;

    public InterfazBD(String database) throws SQLException, ClassNotFoundException {
        conexion = new Conexion(database);
    }
    
    // DESGUACES 
    // setterss
    public void anadirOferta(String id, int id_aux,Date fechaAlta, double importe, int estado, String pedido, String desguace,String desguaceNombre,  Date fechaBaja, Date fechaLimite) {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          conexion.ejecutarInsert("insert INTO oferta (id,id_aux ,fecha_alta, importe, estado, pedido, desguace, desguaceNombre,fecha_baja, fecha_limite) values ('" + id+"','"+id_aux+ "'," +(fechaAlta != null ? "'" + dateFormat.format(fechaAlta) + "'" : fechaAlta) + ",'" + importe + "','" + estado + "','" + pedido + "','" + desguace + "','" + desguaceNombre +  "'," +  (fechaBaja != null ? "'" + dateFormat.format(fechaBaja) + "'" : fechaBaja)  + "," + (fechaLimite != null ? "'" + dateFormat.format(fechaLimite) + "'" : fechaLimite) + ");");

    }
    public void anadirOferta(String id,Date fechaAlta, double importe, int estado, String pedido, String desguace,String desguaceNombre,  Date fechaBaja, Date fechaLimite) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         conexion.ejecutarInsert("insert INTO oferta (id,fecha_alta, importe, estado, pedido, desguace, desguaceNombre,fecha_baja, fecha_limite) values ('" + id+"'," +(fechaAlta != null ? "'" + dateFormat.format(fechaAlta) + "'" : fechaAlta) + ",'" + importe + "','" + estado + "','" + pedido + "','" + desguace + "','" + desguaceNombre +  "'," +  (fechaBaja != null ? "'" + dateFormat.format(fechaBaja) + "'" : fechaBaja)  + "," + (fechaLimite != null ? "'" + dateFormat.format(fechaLimite) + "'" : fechaLimite) + ");");

   }
    public int anadirOferta(Date fechaAlta,  int estado,double importe, String pedido, String desguace,String desguaceNombre, Date fechaBaja, Date fechaLimite) {
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return conexion.ejecutarInsert("insert INTO oferta (id, fecha_alta, importe, estado, pedido, desguace, desguaceNombre,fecha_baja, fecha_limite) values ('', " +  (fechaAlta != null ? "'" + dateFormat.format(fechaAlta) + "'" : fechaAlta) + ",'" + importe + "','" + estado + "','" + pedido + "','" + desguace  + "','" + desguaceNombre +  "'," +  (fechaBaja != null ? "'" + dateFormat.format(fechaBaja) + "'" : fechaBaja)  + "," + (fechaLimite != null ? "'" + dateFormat.format(fechaLimite) + "'" : fechaLimite) + ");");
    }
    public void anadirPedido(String id, int id_aux,Date fechaAlta, int estado, String taller,String tallerNombre, Date fechaBaja, Date fechaLimite, boolean modoAutomatico)    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        conexion.ejecutarSQL("insert INTO pedido (id, id_aux,fecha_alta, estado, taller,tallerNombre, fecha_baja, fecha_limite, modo_automatico) values ('" + id +"','"+id_aux+ "'," + (fechaAlta != null ? "'" + dateFormat.format(fechaAlta) + "'" : fechaAlta) + ",'" + estado + "','" + taller + "','" + tallerNombre +  "'," +(fechaBaja != null ? "'" + dateFormat.format(fechaBaja) + "'" : fechaBaja) + "," + (fechaLimite != null ? "'" + dateFormat.format(fechaLimite) + "'" : fechaLimite) + ", '" + (modoAutomatico ? 1 : 0) + "');");
    }

    public void anadirPedido(String id,Date fechaAlta, int estado, String taller,String tallerNombre, Date fechaBaja, Date fechaLimite, boolean modoAutomatico)    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        conexion.ejecutarSQL("insert INTO pedido (id,fecha_alta, estado, taller,tallerNombre, fecha_baja, fecha_limite, modo_automatico) values ('" + id + "'," + (fechaAlta != null ? "'" + dateFormat.format(fechaAlta) + "'" : fechaAlta) + ",'" + estado + "','" + taller + "','" + tallerNombre +  "'," +(fechaBaja != null ? "'" + dateFormat.format(fechaBaja) + "'" : fechaBaja) + "," + (fechaLimite != null ? "'" + dateFormat.format(fechaLimite) + "'" : fechaLimite) + ", '" + (modoAutomatico ? 1 : 0) + "');");
    }
    public int anadirPedido(Date fechaAlta, EstadoPedido estado, String taller, String tallerNombre,Date fechaBaja, Date fechaLimite, boolean modoAutomatico) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return conexion.ejecutarInsert("insert INTO pedido (id, fecha_alta, estado, taller,tallerNombre ,fecha_limite, modo_automatico) values ('', " + (fechaAlta != null ? "'" + dateFormat.format(fechaAlta) + "'" : fechaAlta) + ",'" + estado.ordinal() + "','" + taller + "','" + tallerNombre +  "'," +(fechaLimite != null ? "'" + dateFormat.format(fechaLimite) + "'" : fechaLimite) + ", '" + (modoAutomatico ? 1 : 0) + "');");
    }

    
    public int anadirDesguace(int id, String nombre, String email, String direccion, String ciudad, int codPostal, int telefono, int estado)    {
        // TODO: cambiar el id
        return conexion.ejecutarInsert("insert INTO desguace (id, nombre, email, direccion, ciudad, codPostal, telefono, estado) values ('" + id + "','" + nombre + "', '" + email + "','" + direccion + "','" + ciudad + "','" + codPostal + "','" + telefono + "','" + estado + "');");
        
    }
    // getters
    public ArrayList<Oferta> getOfertas()
    {
        ArrayList<Oferta> lista= new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM oferta;");
            while(resultados.next()){
                Oferta nuevo = new Oferta(resultados.getString("id"), resultados.getInt("id_aux"),resultados.getDouble("importe"), resultados.getString("desguace"), resultados.getString("desguaceNombre"), resultados.getString("pedido"),resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoOferta.values()[resultados.getInt("estado")] );
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;    
    }
    public Oferta getOfertaporID(String id) {
    	
         try {
             Oferta nueva= null;
             ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM oferta where id='" + id + "'");
             while (resultados.next()) {    

                 nueva = new Oferta(resultados.getString("id"), resultados.getInt("id_aux") ,resultados.getDouble("importe"), resultados.getString("desguace"),resultados.getString("desguaceNombre"), resultados.getString("pedido"), resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoOferta.values()[resultados.getInt("estado")]);
                 return nueva;
            }
         } catch (SQLException ex) {
             ex.printStackTrace();
             return null;
         }
         return null;
	}
    public ArrayList<Desguace> getDesguaces()
    {
        ArrayList<Desguace> lista= new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM desguace;");
            while(resultados.next()){
                ArrayList<Oferta> listaOfertas = getOfertasDesguace(resultados.getString("id"));
                Desguace nuevo = new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")] ,listaOfertas);
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;    
    }
    
    public int getNumPedidos(){
    	ResultSet resultados = conexion.ejecutarSQLSelect("Select count(*) as num from pedido");
    	try {
    		while(resultados.next())
    			return resultados.getInt("num");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return 0;
    }
    
    public int getNumOfertas(){
    	ResultSet resultados = conexion.ejecutarSQLSelect("Select count(*) as num from oferta");
    	try {
    		while(resultados.next())
    			return resultados.getInt("num");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return 0;
    }
    
    public int getNumPedidosPorError(String id){
    	ResultSet resultados = conexion.ejecutarSQLSelect("Select count(*) as num from pedido where id like '"+id+"%'");
    	try {
    		while(resultados.next())
    			return resultados.getInt("num");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return 0;
    }
    
    public int getNumOfertasPorError(String id){
    	ResultSet resultados = conexion.ejecutarSQLSelect("Select count(*) as num from oferta where id like '"+id+"%'");
    	try {
    		while(resultados.next())
    			return resultados.getInt("num");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return 0;
    }
    
    public ArrayList<Desguace> getDesguacesAceptados()
    {
        ArrayList<Desguace> lista= new ArrayList<>();
        try{
        	  ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM desguace where estado='0'");
            while(resultados.next()){
                ArrayList<Oferta> listaOfertas = getOfertasDesguace(resultados.getString("id"));
                Desguace nuevo = new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")] ,listaOfertas);
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
            }
           resultados = conexion.ejecutarSQLSelect("SELECT * FROM desguace where estado='1'");
            while(resultados.next()){
                ArrayList<Oferta> listaOfertas = getOfertasDesguace(resultados.getString("id"));
                Desguace nuevo = new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")] ,listaOfertas);
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;    
    }

    public ArrayList<Pedido> getPedidosActivos(){ //devuelve pedidos en general
        ArrayList<Pedido> lista= new ArrayList<>();
        try{
            //conexion.ejecutarSQL("INSERT INTO pedido (id, taller, estado, fecha_alta, fecha_baja, fecha_limite) values ('4', '5','4','2013-03-12', '2013-03-12', '2013-03-12');");
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido;");
            while(resultados.next()){
                String pedidoID = resultados.getString("id");
                ArrayList<Pieza> piezas = new ArrayList<>();
                ArrayList<Integer> cantidades = new ArrayList<>();
                getPiezasYCantidades(pedidoID, piezas, cantidades);

                Pedido nuevo = new Pedido(pedidoID, resultados.getInt("id_aux"),resultados.getString("taller"), resultados.getString("tallerNombre"),resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoPedido.values()[resultados.getInt("estado")], resultados.getInt("modo_automatico") != 0, piezas, cantidades, getOfertasPedido(pedidoID));
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
        
    }
    
    public ArrayList<Pedido> getPedidosTaller(String idTaller){ //devuelve pedidos en general
        ArrayList<Pedido> lista= new ArrayList<>();
        try{
            //conexion.ejecutarSQL("INSERT INTO pedido (id, taller, estado, fecha_alta, fecha_baja, fecha_limite) values ('4', '5','4','2013-03-12', '2013-03-12', '2013-03-12');");
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido where taller = '" + idTaller + "';");
            while(resultados.next()){
                String pedidoID = resultados.getString("id");
                ArrayList<Pieza> piezas = new ArrayList<>();
                ArrayList<Integer> cantidades = new ArrayList<>();
                getPiezasYCantidades(resultados.getInt("id_aux"), piezas, cantidades);
                Pedido nuevo = new Pedido(pedidoID, resultados.getInt("id_aux"), resultados.getString("taller"),resultados.getString("tallerNombre") ,resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoPedido.values()[resultados.getInt("estado")], resultados.getBoolean("modo_automatico"), piezas, cantidades, getOfertasPedido(pedidoID));
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
        
    }
    public Pedido getPedidoID(String id){ //devuelve pedidos en general
        Pedido pedido=null;
        try{
            //conexion.ejecutarSQL("INSERT INTO pedido (id, taller, estado, fecha_alta, fecha_baja, fecha_limite) values ('4', '5','4','2013-03-12', '2013-03-12', '2013-03-12');");
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido where id = '" + id + "';");
            while(resultados.next()){
                String pedidoID = resultados.getString("id");
                ArrayList<Pieza> piezas = new ArrayList<>();
                ArrayList<Integer> cantidades = new ArrayList<>();
                getPiezasYCantidades(pedidoID, piezas, cantidades);
                Pedido nuevo = new Pedido(pedidoID,resultados.getInt("id_aux") ,resultados.getString("taller"),resultados.getString("tallerNombre") ,resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoPedido.values()[resultados.getInt("estado")], resultados.getBoolean("modo_automatico"), piezas, cantidades, getOfertasPedido(pedidoID));
                return nuevo;
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return pedido;
        
    }
    public ArrayList<Pedido> getPedidosConID_aux() { //devuelve pedidos en general
        ArrayList<Pedido> lista = new ArrayList<>();
        try {
            //conexion.ejecutarSQL("INSERT INTO pedido (id, taller, estado, fecha_alta, fecha_baja, fecha_limite) values ('4', '5','4','2013-03-12', '2013-03-12', '2013-03-12');");
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido;");
            while (resultados.next()) {
                String pedidoID = resultados.getString("id");
                ArrayList<Pieza> piezas = new ArrayList<>();
                ArrayList<Integer> cantidades = new ArrayList<>();
                getPiezasYCantidades(resultados.getInt("id_aux"), piezas, cantidades);

               Pedido nuevo = new Pedido(pedidoID, resultados.getInt("id_aux"), resultados.getString("taller"),resultados.getString("tallerNombre"), resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoPedido.values()[resultados.getInt("estado")], resultados.getBoolean("modo_automatico"), piezas, cantidades, getOfertasPedido(pedidoID));
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;

    }
    public ArrayList<Oferta> getOfertasPorEstado(EstadoOferta estado){
        ArrayList<Oferta> lista = new ArrayList<>();
        try {
            Oferta nueva;
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM oferta where estado='" + estado.ordinal() + "'");
            while (resultados.next()) {    

                nueva = new Oferta(resultados.getString("id"), resultados.getInt("id_aux") ,resultados.getDouble("importe"), resultados.getString("desguace"),resultados.getString("desguaceNombre"), resultados.getString("pedido"), resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoOferta.values()[resultados.getInt("estado")]);
                lista.add(nueva);
           }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;

    
    }
    public ArrayList<Pedido> getPedidosPorEstado(EstadoPedido estado){
        ArrayList<Pedido> lista = new ArrayList<>();
        try {
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido where estado='" + estado.ordinal() + "'");
            while (resultados.next()) {
                String pedidoID = resultados.getString("id");
                ArrayList<Pieza> piezas = new ArrayList<>();
                ArrayList<Integer> cantidades = new ArrayList<>();
                getPiezasYCantidades(resultados.getInt("id_aux"), piezas, cantidades);

                Pedido nuevo = new Pedido(pedidoID,resultados.getInt("id_aux") , resultados.getString("taller"), resultados.getString("tallerNombre") ,resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoPedido.values()[resultados.getInt("estado")], resultados.getBoolean("modo_automatico"), piezas, cantidades, getOfertasPedido(pedidoID));
                lista.add(nuevo);
           }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;

    
    }
    public ArrayList<Pedido> getPedidosConID_aux(EstadoPedido estado) {
        ArrayList<Pedido> lista = new ArrayList<>();
        try {
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido where estado='" + estado.ordinal() + "'");
            while (resultados.next()) {
                String pedidoID = resultados.getString("id");
                ArrayList<Pieza> piezas = new ArrayList<>();
                ArrayList<Integer> cantidades = new ArrayList<>();
                getPiezasYCantidades(pedidoID, piezas, cantidades);

                Pedido nuevo = new Pedido(pedidoID, resultados.getInt("id_aux"), resultados.getString("taller"), resultados.getString("tallerNombre"), resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoPedido.values()[resultados.getInt("estado")], resultados.getBoolean("modo_automatico"), piezas, cantidades, getOfertasPedido(pedidoID));
                lista.add(nuevo);
           }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;

    }
public ArrayList<Oferta> getOfertasConID_aux(EstadoOferta estado) {
        ArrayList<Oferta> lista = new ArrayList<Oferta>();
        try {
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM oferta where estado='" + estado.ordinal() + "'");
            while (resultados.next()) {
                String ofertaID = resultados.getString("id");


                Oferta nuevo = new Oferta(ofertaID, resultados.getInt("id_aux"), resultados.getDouble("importe"),resultados.getString("desguace"),resultados.getString("desguaceNombre"), resultados.getString("pedido"), resultados.getTimestamp("fecha_alta"),  resultados.getTimestamp("fecha_baja"),  resultados.getTimestamp("fecha_limite"), EstadoOferta.values()[resultados.getInt("estado")]);
                lista.add(nuevo);
           }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;

    }
    public ArrayList<Oferta> getOfertasConID_aux() {
        ArrayList<Oferta> lista = new ArrayList<Oferta>();
        try {
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM oferta ");
            while (resultados.next()) {
                String ofertaID = resultados.getString("id");


                Oferta nuevo = new Oferta(ofertaID, resultados.getInt("id_aux"), resultados.getDouble("importe"),resultados.getString("desguace"), resultados.getString("desguaceNombre"),resultados.getString("pedido"), resultados.getTimestamp("fecha_alta"),  resultados.getTimestamp("fecha_baja"),  resultados.getTimestamp("fecha_limite"), EstadoOferta.values()[resultados.getInt("estado")]);
                lista.add(nuevo);
           }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;

    }
    public ArrayList<Taller> getTalleresAceptados()
    {
        ArrayList<Taller> lista= new ArrayList<>();
        try{
        	  ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM taller where estado='0'");
        	  while(resultados.next()){
                  ArrayList<Pedido> listaDePedidos = new ArrayList<>();
                  listaDePedidos = null; // no se necesita para el alta
                  Taller nuevo = new Taller(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaDePedidos);
                  lista.add(nuevo);
                  //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
              }
           resultados = conexion.ejecutarSQLSelect("SELECT * FROM taller where estado='1'");
           while(resultados.next()){
               ArrayList<Pedido> listaDePedidos = new ArrayList<>();
               listaDePedidos = null; // no se necesita para el alta
               Taller nuevo = new Taller(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaDePedidos);
               lista.add(nuevo);
               //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
           }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;    
    }
    public ArrayList<Taller> getTalleres()
    {
        ArrayList<Taller> lista= new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM taller;");
            ArrayList<Pedido> listaDePedidos = new ArrayList<>();
            while(resultados.next()){
                Taller nuevo;
                if ("".equals(resultados.getString("id"))) {
                    // estamos en taller, y está todavía pendiente
                    nuevo = new Taller("", resultados.getInt("id_aux"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"), EstadoGeneral.values()[resultados.getInt("estado")], listaDePedidos);
                }else{
                    // estamos en gestor o en taller
                    listaDePedidos = getPedidosTaller(resultados.getString("id"));
                    nuevo = new Taller(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaDePedidos);
                }
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;    
    }
    
    public ArrayList<Taller> getAltasTaller()
    {
        ArrayList<Taller> lista= new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM taller where estado ='"+2+"';");
            while(resultados.next()){
                ArrayList<Pedido> listaDePedidos = new ArrayList<>();
                listaDePedidos = null; // no se necesita para el alta
                Taller nuevo = new Taller(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaDePedidos);
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
        
    }
    

    public ArrayList<Desguace> getAltasDesguaces()
    {
        ArrayList<Desguace> lista= new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM desguace where estado ='"+2+"';");
            
            while(resultados.next()){
                ArrayList<Oferta> listaOfertas = new ArrayList<>();
                listaOfertas = null; // inicialmente vacía
                Desguace nuevo = new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaOfertas);
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
    }
    
    public Pedido getPedido(String id)
    {
        Pedido pedido = null;
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido where id ='"+id+"';");
            while(resultados.next()){
                ArrayList<Pieza> piezas =new ArrayList<>();
        
                ArrayList<Integer> cantidades = new ArrayList<>();
                getPiezasYCantidades(id, piezas, cantidades);

                pedido = new Pedido(resultados.getString("id"),resultados.getInt("id_aux") , resultados.getString("taller"),resultados.getString("tallerNombre"), resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoPedido.values()[resultados.getInt("estado")], resultados.getBoolean("modo_automatico"), piezas, cantidades, getOfertasPedido(id));

            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return pedido;
    }
    public Pedido getPedidoID_aux(String id)
    {
        Pedido pedido = null;
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido where id ='"+id+"';");
            while(resultados.next()){
                ArrayList<Pieza> piezas =new ArrayList<>();
        
                ArrayList<Integer> cantidades = new ArrayList<>();
                getPiezasYCantidades(resultados.getInt("id_aux"), piezas, cantidades);

                pedido = new Pedido(resultados.getString("id"),resultados.getInt("id_aux") , resultados.getString("taller"),resultados.getString("tallerNombre"), resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoPedido.values()[resultados.getInt("estado")], resultados.getBoolean("modo_automatico"), piezas, cantidades, getOfertasPedido(id));

            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return pedido;
    }
    public Taller getTallerEnGestor(String id) {
        ResultSet resultados = conexion.ejecutarSQLSelect("Select * from taller where id='" + id + "'");
        try {
            if (resultados.first()) {
                return new Taller(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"), resultados.getInt("codPostal"), resultados.getInt("telefono"), EstadoGeneral.values()[resultados.getInt("estado")], new ArrayList<Pedido>());
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Desguace getDesguaceEnGestor(String id) {
        ResultSet resultados = conexion.ejecutarSQLSelect("Select * from desguace where id='" + id + "'");
        try {
            if (resultados.first()) {
                return new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"), resultados.getInt("codPostal"), resultados.getInt("telefono"), EstadoGeneral.values()[resultados.getInt("estado")], new ArrayList<Oferta>());
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Desguace getDesguaceEnGestorID_AUX(String id_aux) {
        ResultSet resultados = conexion.ejecutarSQLSelect("Select * from desguace where id_aux='" + id_aux + "'");
        try {
            if (resultados.first()) {
                return new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"), resultados.getInt("codPostal"), resultados.getInt("telefono"), EstadoGeneral.values()[resultados.getInt("estado")], new ArrayList<Oferta>());
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void getPiezasYCantidades(int pedidoID, ArrayList<Pieza> piezas, ArrayList<Integer> cantidades){
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido_pieza WHERE pedido='" + pedidoID + "';");
            while(resultados.next()){
                piezas.add(new Pieza(resultados.getString("pieza")));
                cantidades.add(resultados.getInt("cantidad"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            //return null;
        }
    }
    public void getPiezasYCantidades(String pedidoID, ArrayList<Pieza> piezas, ArrayList<Integer> cantidades){
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido_pieza WHERE pedido='" + pedidoID + "';");
            while(resultados.next()){
                piezas.add(new Pieza(resultados.getString("pieza")));
                cantidades.add(resultados.getInt("cantidad"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            //return null;
        }
    } 
  
    public ArrayList<Pieza> getPiezasPedido(String pedidoID){
        ArrayList<Pieza> lista = new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido_pieza WHERE pedido='" + pedidoID + "';");
            while(resultados.next()){
                Pieza nueva = new Pieza(resultados.getString("pieza"));
                lista.add(nueva);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;

    }

    public ArrayList<Oferta> getOfertasDesguace(String desguaceID){
        ArrayList<Oferta> lista = new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM oferta WHERE desguace='" + desguaceID + "';");
            while(resultados.next()){
                Oferta nueva = new Oferta(resultados.getString("id"),resultados.getInt("id_aux") ,  resultados.getDouble("importe"), resultados.getString("desguace"),resultados.getString("desguaceNombre"), resultados.getString("pedido"),resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoOferta.values()[resultados.getInt("estado")]);
                lista.add(nueva);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
        
    }
        
    public ArrayList<Oferta> getOfertasPedido(String pedidoID){
        ArrayList<Oferta> lista = new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM oferta WHERE pedido='" + pedidoID + "';");
            Oferta nueva;
            while (resultados.next()) {
                nueva = new Oferta(resultados.getString("id"),resultados.getInt("id_aux") , resultados.getDouble("importe"), resultados.getString("desguace"),resultados.getString("desguaceNombre"),  resultados.getString("pedido"), resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoOferta.values()[resultados.getInt("estado")]);

                lista.add(nueva);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;

    }

    public ArrayList<Oferta> getOfertasPedido(String pedidoID, EstadoOferta estado) {
        ArrayList<Oferta> lista = new ArrayList<>();
        try {
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM oferta WHERE pedido='" + pedidoID + "' and estado='" + estado.ordinal() + "';");
            Oferta nueva;
            while (resultados.next()) {
                nueva = new Oferta(resultados.getString("id"),resultados.getInt("id_aux") , resultados.getDouble("importe"), resultados.getString("desguace"),resultados.getString("desguaceNombre"),  resultados.getString("pedido"), resultados.getTimestamp("fecha_alta"), resultados.getTimestamp("fecha_baja"), resultados.getTimestamp("fecha_limite"), EstadoOferta.values()[resultados.getInt("estado")]);

                lista.add(nueva);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;

    }
     public Desguace getDesguace(){
        ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM desguace");
        try {
            if (resultados.first()) {
                final String tallerID = resultados.getString("id");
                if("".equals(tallerID)){
                     return  new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")] ,null);
                }else{
                    ArrayList<Oferta> listaOfertas = getOfertasDesguace(resultados.getString("id"));
                return  new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")] ,listaOfertas);
                }
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }
     public Desguace getDesguace(String email){
        ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM desguace WHERE email='" + email + "';");
        try {
            if (resultados.first()) {
                final String tallerID = resultados.getString("id");
                if("".equals(tallerID)){
                     return  new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")] ,null);
                }else{
                    ArrayList<Oferta> listaOfertas = getOfertasDesguace(resultados.getString("id"));
                return  new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")] ,listaOfertas);
                }
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }   
    public Taller getTaller(String email){
        ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM taller WHERE email='" + email + "';");
        try {
            if (resultados.first()) {
                final String tallerID = resultados.getString("id");
                if("".equals(tallerID)){
                    return new Taller("", resultados.getInt("id_aux"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"), EstadoGeneral.values()[resultados.getInt("estado")], new ArrayList<Pedido>());
                }else{
                    ArrayList<Pedido> listaDePedidos = getPedidosTaller(resultados.getString("id"));
                    return new Taller(tallerID, resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaDePedidos);
                }
                
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Taller getTallerActivar(String contrasenya){
        ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM taller WHERE contrasenya='" + contrasenya + "';");
        try {
            if (resultados.first()) {
                final String tallerID = resultados.getString("id");
                if("".equals(tallerID)){
                    return new Taller("", resultados.getInt("id_aux"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"), EstadoGeneral.values()[resultados.getInt("estado")], new ArrayList<Pedido>());
                }else{
                    ArrayList<Pedido> listaDePedidos = getPedidosTaller(resultados.getString("id"));
                    return new Taller(tallerID, resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaDePedidos);
                }
                
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Taller getTallerActivar(String id, String contrasenya){
        ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM taller WHERE contrasenya='" + contrasenya + "' AND id = '" + id + "';");
        try {
            if (resultados.first()) {
                final String tallerID = resultados.getString("id");
                if("".equals(tallerID)){
                    return new Taller("", resultados.getInt("id_aux"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"), EstadoGeneral.values()[resultados.getInt("estado")], new ArrayList<Pedido>());
                }else{
                    ArrayList<Pedido> listaDePedidos = getPedidosTaller(resultados.getString("id"));
                    return new Taller(tallerID, resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaDePedidos);
                }
                
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Taller getPrimerTaller() {
        ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM taller;");

        try {
            if (resultados.first()) {
                final String tallerID = resultados.getString("id");
                if("".equals(tallerID)){
                    return new Taller("", resultados.getInt("id_aux"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"), EstadoGeneral.values()[resultados.getInt("estado")], new ArrayList<Pedido>());
                }else{
                    ArrayList<Pedido> listaDePedidos = getPedidosTaller(resultados.getString("id"));
                    return new Taller(resultados.getString("id"),resultados.getString("contrasenya"),  resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaDePedidos);
                }
                
            }
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // método que llama el gestor, pasándole el id como un string (resultado del md5)
    public boolean altaTaller(String stringID, String nombre, String email, String direccion, String ciudad, int codPostal, int telefono, int estado) {
        int res = conexion.ejecutarInsert("insert into taller (id,nombre, email, direccion, ciudad, codPostal, telefono, estado) values ('" + stringID + "','" + nombre + "', '" + email + "','" + direccion + "','" + ciudad + "'," + codPostal + "," + telefono + "," + estado + ");");
        return res >= 0;
    }
    
    // método que llaman talleres y desguaces, sin id (lo autogenera la bd)
    public int altaTaller(String nombre, String email, String direccion, String ciudad, int codPostal, int telefono, int estado,String contrasenya) {
        return conexion.ejecutarInsert("insert into taller (nombre, email, direccion, ciudad, codPostal, telefono, estado,contrasenya) values ('" + nombre + "', '" + email + "','" + direccion + "','" + ciudad + "'," + codPostal + "," + telefono + "," + estado +"," + contrasenya + ");");
    }

    public String getMD5IdTaller(String email) {
        ResultSet res = conexion.ejecutarSQLSelect("SELECT id from taller where email='" + email + "';");
        try {
            if (res.first()) {
                return res.getString("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ERROR";
    }
    
    public boolean modificarTaller(String ID, String nombre, String email, String direccion, String ciudad, int codPostal, int telefono, EstadoGeneral estado){
        return conexion.ejecutarSQL("UPDATE `taller` SET `nombre`='" + nombre + "', `email`='" + email + "', `direccion`='" + direccion + "', `ciudad`='" + ciudad + "', `codPostal`='" + codPostal + "', `telefono`='" + telefono + "', `estado`='" + estado.ordinal() + "' WHERE `id`='" + ID + "';");
    }

    public boolean modificarTaller(String nombre, String email, String direccion, String ciudad, int codPostal, int telefono) {
        return conexion.ejecutarSQL("UPDATE `taller` SET `nombre`='" + nombre + "', `email`='" + email + "', `direccion`='" + direccion + "', `ciudad`='" + ciudad + "', `codPostal`='" + codPostal + "', `telefono`='" + telefono + "'");
    }
    
    
        // método que llama el gestor, pasándole el id como un string (resultado del md5)
    public boolean altaDesguace(String stringID, String nombre, String email, String direccion, String ciudad, int codPostal, int telefono, int estado) {
        int res = conexion.ejecutarInsert("insert into desguace (id,nombre, email, direccion, ciudad, codPostal, telefono, estado) values ('" + stringID + "','" + nombre + "', '" + email + "','" + direccion + "','" + ciudad + "'," + codPostal + "," + telefono + "," + estado + ");");
        return res >= 0;
    }
    
    // método que llaman talleres y desguaces, sin id (lo autogenera la bd)
    public int altaDesguace(String nombre, String email, String direccion, String ciudad, int codPostal, int telefono, int estado,String contrasenya) {
        return conexion.ejecutarInsert("insert into desguace (nombre, email, direccion, ciudad, codPostal, telefono, estado,contrasenya) values ('" + nombre + "', '" + email + "','" + direccion + "','" + ciudad + "'," + codPostal + "," + telefono + "," + estado + "," + contrasenya + ");");
    }

    public String getMD5IdDesguace(String email) {
        ResultSet res = conexion.ejecutarSQLSelect("SELECT id from desguace where email='" + email + "';");
        try {
            if (res.first()) {
                return res.getString("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ERROR";
    }
    
    public boolean modificarDesguace(String ID, String nombre, String email, String direccion, String ciudad, int codPostal, int telefono, EstadoGeneral estado){
        return conexion.ejecutarSQL("UPDATE `desguace` SET `nombre`='" + nombre + "', `email`='" + email + "', `direccion`='" + direccion + "', `ciudad`='" + ciudad + "', `codPostal`='" + codPostal + "', `telefono`='" + telefono + "', `estado`='" + estado.ordinal() + "' WHERE `id`='" + ID + "';");
    }
    public boolean modificarDesguace(String nombre, String email, String direccion, String ciudad, int codPostal, int telefono) {
        return conexion.ejecutarSQL("UPDATE `desguace` SET `nombre`='" + nombre + "', `email`='" + email + "', `direccion`='" + direccion + "', `ciudad`='" + ciudad + "', `codPostal`='" + codPostal + "', `telefono`='" + telefono + "'");
    }
    
    
      public void close(){
        conexion.closeConexion();
    }

    /**
     * Será el que llame el taller para activarse en su BD (sor_taller) Activará
     * el propio taller en su bd. Cambiará el md5 generado en gestor y cambiará
     * el estado del taller a activo.
     *
     * @param idRecibido
     * @return
     */
    public boolean activarTallerMainTaller(String idRecibido) {
        return conexion.ejecutarSQL("UPDATE `taller` SET  `estado`='0', `id`='" + idRecibido + "'");
    }
    public boolean activarDesguaceMainDesguace(String idRecibido) {
        return conexion.ejecutarSQL("UPDATE `desguace` SET  `estado`='0', `id`='" + idRecibido + "'");
    }

    public boolean activarTaller(String idRecibido,String pass) {
        return conexion.ejecutarSQL("UPDATE `taller` SET  `estado`='0',`contrasenya`='"+pass+"' where `id`='" + idRecibido + "'");
    }
    public boolean activarDesguace(String idRecibido,String pass) {
    	 return conexion.ejecutarSQL("UPDATE `desguace` SET  `estado`='0',`contrasenya`='"+pass+"' where `id`='" + idRecibido + "'");
    }
    public ArrayList<Pedido> buscarPedido(String idPedido, String idPieza, String estado, Date fechaLimite, String modoAceptacion) throws SQLException {
        ArrayList<Pedido> alPedidos = new ArrayList<>();

        String sWhere = "";
        ResultSet pedidos;

        sWhere = crearWhereDeSelect(idPedido, sWhere, modoAceptacion, fechaLimite, estado);

        if (sWhere.isEmpty()) {
            pedidos = conexion.ejecutarSQLSelect("Select * from pedido;");
        } else {
            pedidos = conexion.ejecutarSQLSelect("SELECT * FROM pedido where " + sWhere);
        }

        if (pedidos.first()) {
            while (!pedidos.isAfterLast()) {
                ArrayList<Pieza> piezas = new ArrayList<>();
                ArrayList<Integer> cantidades = new ArrayList<>();
                getPiezasYCantidades(pedidos.getInt("id_aux"), piezas, cantidades);
                //falta filtrar por pieza
                Pedido p = new Pedido(pedidos.getNString("id"),
                        pedidos.getInt("id_aux"), pedidos.getNString("taller"),pedidos.getNString("tallerNombre"), pedidos.getDate("fecha_alta"), pedidos.getDate("fecha_baja"), pedidos.getDate("fecha_limite"), EstadoPedido.values()[pedidos.getInt("estado")],
                        pedidos.getBoolean("modo_automatico"), piezas, cantidades, getOfertasPedido(pedidos.getNString("id"))
                );
                alPedidos.add(p);
                pedidos.next();
            }
        }

        return alPedidos;
    }

    //falta añadir el modoAceptación
    private String crearWhereDeSelect(String idPedido, String sWhere, String modoAceptacion, Date fechaLimite, String estado) {
        if (idPedido.isEmpty()) {
            sWhere += " (id_aux='" + idPedido + "' or id='" + idPedido + "')";
        }
        if (modoAceptacion.isEmpty()) {            if (sWhere.isEmpty()) {
                sWhere += " and ";
            }
            sWhere += "modo_automatico='" + ("Automatico".equals(modoAceptacion) ? 1 : 0) + "'";
         }
        if (fechaLimite.toString().isEmpty()) {
            if (sWhere.isEmpty()) {
                sWhere += " and ";
            }
            sWhere += "fecha_limite='" + fechaLimite.toString() + "'";
        }
        //estado debe ser el último porque es un and
        if (estado.isEmpty()) {
            if (sWhere.isEmpty()) {
                sWhere += " and ";
            }
            sWhere += "estado='" + estado + "'";
        }
        return sWhere;
    }

    private boolean anyadirPiezasATablaPieza(ArrayList<Pieza> piezas) {
        for (Pieza pieza : piezas) {
                conexion.ejecutarInsert("Insert into pieza(nombre) values ('" + pieza.getNombre() + "')");
        }
        return true;
    }

    public boolean anyadirPiezasAPedido(int idPedido, ArrayList<Pieza> piezas, ArrayList<Integer> cantidades) {
        if (anyadirPiezasATablaPieza(piezas)) {
            for (int i = 0; i < piezas.size(); i++) {
                conexion.ejecutarInsert("Insert into pedido_pieza(pedido,pieza,cantidad) values ('" + idPedido + "', '" + piezas.get(i).getNombre() + "', '" + cantidades.get(i) + "')");
            }
            return true;
        }
        return false;
    }
    public boolean anyadirPiezasAPedido(String idPedido, ArrayList<Pieza> piezas, ArrayList<Integer> cantidades) {
        if (anyadirPiezasATablaPieza(piezas)) {
            for (int i = 0; i < piezas.size(); i++) {
                conexion.ejecutarInsert("Insert into pedido_pieza(pedido,pieza,cantidad) values ('" + idPedido + "', '" + piezas.get(i).getNombre() + "', '" + cantidades.get(i) + "')");
            }
            return true;
        }
        return false;
    }

    public boolean cambiarEstadoOferta(EstadoOferta eOf, String id) {
        return conexion.ejecutarSQL("Update oferta set estado='" + eOf.ordinal() + "' where id='" + id + "'");
    }
    public boolean cambiarEstadoPedido(EstadoPedido ePed, String id) {
        return conexion.ejecutarSQL("Update pedido set estado='" + ePed.ordinal() + "' where id='" + id + "'");
    }
    public boolean activarPedidoTaller(int id_aux, String id) {
        return conexion.ejecutarSQL("Update pedido set estado='1', id='" + id + "' where id_aux='" + id_aux + "';");
    }

    public boolean activarOfertaDesguace(int id_aux, String id) {
        return conexion.ejecutarSQL("Update oferta set estado='1', id='" + id + "' where id_aux='" + id_aux + "';");
    }
    
    public boolean cancelarOfertas(String idPedido) {
        return conexion.ejecutarSQL("Update oferta set estado='" + EstadoOferta.CANCELLED.ordinal() + "' where pedido='" + idPedido + "'");
    }
     public boolean cancelarOfertasDesguace(String idDesguace) {
        return conexion.ejecutarSQL("Update oferta set estado='" + EstadoOferta.CANCELLED.ordinal() + "' where desguace='" + idDesguace + "'");
    }

    public boolean cancelarPedidosTaller(String idTaller) throws SQLException {
        ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido where taller='" + idTaller + "'");
        while (resultados.next()) {
            cancelarOfertas(resultados.getString("id"));
        }
        return conexion.ejecutarSQL("Update pedido set estado='" + EstadoPedido.CANCELLED.ordinal() + "' where taller='" + idTaller + "'");
    }
  public boolean cancelarPedidosDesguace(String idDesguace) throws SQLException {
        ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM oferta where desguace='" + idDesguace+ "'");
        while (resultados.next()) {
            cancelarOfertasDesguace(resultados.getString("id"));
        }
        return conexion.ejecutarSQL("Update oferta set estado='" + EstadoPedido.CANCELLED.ordinal() + "' where desguace='" + idDesguace + "'");
    }
    public boolean cancelarPedido(String idPedido) {
        cancelarOfertas(idPedido);
        return conexion.ejecutarSQL("Update pedido set estado='" + EstadoPedido.CANCELLED.ordinal() + "' where id='" + idPedido + "'");
    }

    public boolean bajaTaller(String id) {
        try {
            cancelarPedidosTaller(id);
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion.ejecutarSQL("Update taller set estado='" + EstadoGeneral.INACTIVE.ordinal() + "' where id='" + id + "'");
    }
  public boolean bajaDesguace(String id) {
        try {
            cancelarPedidosDesguace(id);
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conexion.ejecutarSQL("Update desguace set estado='" + EstadoGeneral.INACTIVE.ordinal() + "' where id='" + id + "'");
    }
    /**
     *
     * @param accion debe tener formato "nombre:param0|param1|...|paramN"
     * @param paramValues debe tener formato "valor0|valor1|...|valorN"
     * @return
     */
    public boolean guardarAccion(String accion, String paramValues) {
        return conexion.ejecutarSQL("INSERT INTO `acciones`(`accion`,`params`) VALUES('" + accion + "', '" + paramValues + "');");
    }

    public ResultSet getAcciones() {
        ResultSet result = conexion.ejecutarSQLSelect("SELECT * FROM `acciones`;");
        return result;
    }
    
    public ResultSet getAccionesYBorra(){
    	ResultSet result = getAcciones();
    	conexion.ejecutarSQL("DELETE FROM `acciones`;");
    	return result;
    }

	public Boolean anyadirRolUsuario(String nombre, String contrasenya, String rol) {
		ArrayList<Integer> listaOpciones=getRolLista(rol);
		if(listaOpciones==null){return false;}
        conexion.ejecutarInsert("Insert into usuarios(nombre,contrasenya,rol,nuevo_pedido,borrar_pedido,modificar_pedido,modificar_datos,baja,aceptar_ofertas,rechazar_ofertas,nuevo_usuario,nuevo_rol,cambiar_usuario,cambiar_rol) values ('" + nombre + "', '" + contrasenya + "', '" + rol +"', '"+ listaOpciones.get(0) + "', '" + listaOpciones.get(1) +  "', '" + listaOpciones.get(2) + "', '" + listaOpciones.get(3) + "', '" + listaOpciones.get(4) + "', '" + listaOpciones.get(5) + "', '" + listaOpciones.get(6) + "', '" + listaOpciones.get(7) + "', '" + listaOpciones.get(8) +"', '" + listaOpciones.get(9) + "', '" + listaOpciones.get(10) +  "')");

		return true;
	}

	public ArrayList<Integer> getRolLista(String rol) {
	      
	       ArrayList<Integer> listaOpciones = new ArrayList<Integer>();
	       ResultSet  opciones=  conexion.ejecutarSQLSelect("SELECT * from roles where rol='" + rol + "';");
	      try {
			if(opciones.first()){

				for(int i=2;i<=12;i++){
					listaOpciones.add(opciones.getInt(i));
				}
				return listaOpciones;
				}
				
			  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       return null;
	}

	public Boolean comprobarInicio(String usuario, String contrasenya) {
        ResultSet res = conexion.ejecutarSQLSelect("SELECT * from usuarios where nombre='" + usuario + "' && contrasenya='" + contrasenya+"';");
        try {
            if (res.first()) {
                if(usuario.equals(res.getString("nombre")) && contrasenya.equals(res.getString("contrasenya"))){
                	return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
	}

	public Desguace getDesguaceActivar(String contrasenya) {
        ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM desguace WHERE contrasenya='" + contrasenya + "';");
        try {
            if (resultados.first()) {
                final String tallerID = resultados.getString("id");
                if("".equals(tallerID)){
                     return  new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")] ,null);
                }else{
                    ArrayList<Oferta> listaOfertas = getOfertasDesguace(resultados.getString("id"));
                return  new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")] ,listaOfertas);
                }
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}

	public Desguace getDesguaceActivar(String id, String contrasenya) {
        ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM desguace WHERE contrasenya='" + contrasenya + "' AND id = '" + id + "';");
        try {
            if (resultados.first()) {
                final String tallerID = resultados.getString("id");
                if("".equals(tallerID)){
                     return  new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")] ,null);
                }else{
                    ArrayList<Oferta> listaOfertas = getOfertasDesguace(resultados.getString("id"));
                return  new Desguace(resultados.getString("id"), resultados.getString("contrasenya"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")] ,listaOfertas);
                }
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}
	
	public void anyadirRol(String nombre,ArrayList<Integer> listaOpciones) {
        conexion.ejecutarInsert("Insert into roles(rol,nuevo_pedido,borrar_pedido,modificar_pedido,modificar_datos,baja,aceptar_ofertas,rechazar_ofertas,nuevo_usuario,nuevo_rol,cambiar_usuario,cambiar_rol) values ('" + nombre + "', '" + listaOpciones.get(0) + "', '" + listaOpciones.get(1) +  "', '" + listaOpciones.get(2) + "', '" + listaOpciones.get(3) + "', '" + listaOpciones.get(4) + "', '" + listaOpciones.get(5) + "', '" + listaOpciones.get(6) + "', '" + listaOpciones.get(7) + "', '" + listaOpciones.get(8) +"','"+ listaOpciones.get(9) + "', '" + listaOpciones.get(10) +"')");
       

		
	}

	public void cambiarUsuario(String nombreUsuario,ArrayList<Integer> listaOpciones) {
      //  conexion.ejecutarInsert("Insert into roles(rol,nuevo_pedido,borrar_pedido,modificar_pedido,modificar_datos,baja,aceptar_ofertas,rechazar_ofertas,nuevo_usuario,nuevo_rol) values ('" + nombre + "', '" + listaOpciones.get(0) + "', '" + listaOpciones.get(1) +  "', '" + listaOpciones.get(2) + "', '" + listaOpciones.get(3) + "', '" + listaOpciones.get(4) + "', '" + listaOpciones.get(5) + "', '" + listaOpciones.get(6) + "', '" + listaOpciones.get(7) + "', '" + listaOpciones.get(8) +"')");
         conexion.ejecutarSQL("UPDATE usuarios SET  `nuevo_pedido`='"+listaOpciones.get(0)+"',`borrar_pedido`='"+listaOpciones.get(1)+"', `modificar_pedido`='"+listaOpciones.get(2)+"', `modificar_datos`='"+listaOpciones.get(3)+"', `baja`='"+listaOpciones.get(4)+"',`aceptar_ofertas`='"+listaOpciones.get(5)+"',`rechazar_ofertas`='"+listaOpciones.get(6)+"',`nuevo_usuario`='"+listaOpciones.get(7)+"',`nuevo_rol`='"+listaOpciones.get(8)+"',`cambiar_usuario`='"+listaOpciones.get(9)+"',`cambiar_rol`='"+listaOpciones.get(10)+"' where nombre='"+nombreUsuario+"';");
		
	}

	public void cambiarRol(String nombreRol, ArrayList<Integer> listaOpciones) {
        conexion.ejecutarSQL("UPDATE roles SET  `nuevo_pedido`='"+listaOpciones.get(0)+"',`borrar_pedido`='"+listaOpciones.get(1)+"', `modificar_pedido`='"+listaOpciones.get(2)+"', `modificar_datos`='"+listaOpciones.get(3)+"', `baja`='"+listaOpciones.get(4)+"',`aceptar_ofertas`='"+listaOpciones.get(5)+"',`rechazar_ofertas`='"+listaOpciones.get(6)+"',`nuevo_usuario`='"+listaOpciones.get(7)+"',`nuevo_rol`='"+listaOpciones.get(8)+"',`cambiar_usuario`='"+listaOpciones.get(9)+"',`cambiar_rol`='"+listaOpciones.get(10)+"' where rol='"+nombreRol+"';");

		
	}

	public ArrayList<String> getUsuarios() {
		ArrayList<String> usuarios= new ArrayList<String>();
		   ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM usuarios;");
	        try {
	            if (resultados.first()) {
	            	 while (!resultados.isAfterLast()) {
	            		 usuarios.add(resultados.getString("nombre"));
	            		 resultados.next();
	            	 }
	                
	            }
	            return usuarios;
	        } catch (SQLException ex) {
	            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return null;
	}

	public ArrayList<String> getRoles() {
		ArrayList<String> roles= new ArrayList<String>();
		   ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM roles;");
	        try {
	            if (resultados.first()) {
	            	 while (!resultados.isAfterLast()) {
	            		 roles.add(resultados.getString("rol"));
	            		 resultados.next();
	            	 }
	                
	            }
	            return roles;
	        } catch (SQLException ex) {
	            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return null;
	}

	public Boolean comprobarPermisos(String usuario, String funcion) {
		  int funcionOpcion =0;
		  ResultSet resultSet ;
	    ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM usuarios WHERE nombre='" + usuario + "';");
        try {
            if (resultados.first()) {
                 funcionOpcion = resultados.getInt(funcion);
                 if(funcionOpcion==0){
                	 	resultados = conexion.ejecutarSQLSelect("SELECT * FROM roles WHERE rol='" + resultados.getString("rol") + "';");
                        try {
                            if (resultados.first()) {
                            	funcionOpcion = resultados.getInt(funcion);
                            	if(funcionOpcion==1){
                            		return true;
                            	}
                                
                            }

                        } catch (SQLException ex) {
                            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                 }
                 else{return true;}

                
            }
            else{
            	resultSet =conexion.ejecutarSQLSelect("SELECT * FROM roles WHERE rol='Administrador';");
                try {
                    if (resultSet.first()) {
                    	funcionOpcion = resultSet.getInt(funcion);
                    	if(funcionOpcion==1){
                    		return true;
                    	}
                        
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(InterfazBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
	}

	public void ponerCodigoActivacionTaller(String codigo,String id) {
		conexion.ejecutarSQL("UPDATE `taller` SET `contrasenya`='"+codigo+"' WHERE `id`='"+id+"';");
		
	}
	public void ponerCodigoActivacionDesguace(String codigo,String id) {
		conexion.ejecutarSQL("UPDATE `desguace` SET `contrasenya`='"+codigo+"' WHERE `id`='"+id+"';");
		
	}
	
}
