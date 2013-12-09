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
import java.util.ArrayList;
import java.util.Date;

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
    // setters
    public void anadirOferta(int id, Date fechaAlta, float importe, int estado, int pedido, int desguace, Date fechaBaja, Date fechaLimite)
    {
        conexion.ejecutarSQL("insert INTO sor_desguace.oferta (id, fechaAlta, importe, estado, pedido, desguace, fechaBaja, fechaLimite) values ('"+id+"','"+fechaAlta+"', '"+importe+"','"+estado+"','"+pedido+"';"+desguace+"','"+fechaBaja+"','"+fechaLimite+"');");
        
    }
    
    public void anadirPedido(int id, Date fechaAlta, int estado, int taller, Date fechaBaja, Date fechaLimite)
    {
        conexion.ejecutarSQL("insert INTO sor_desguace.pedido (id, fechaAlta, estado, taller, fechaBaja, fechaLimite) values ('"+id+"','"+fechaAlta+"','"+estado+"','"+taller+"','"+fechaBaja+"','"+fechaLimite+"';");
    }
    
    public void anadirDesguace(int id, String nombre, String email, String direccion, String ciudad, int codPostal, int telefono, int estado)
    {
        conexion.ejecutarSQL("insert INTO sor_desguace.desguace (id, nombre, email, direccion, ciudad, codPostal, telefono, estado) values ('"+id+"','"+nombre+"', '"+email+"','"+direccion+"','"+ciudad+"','"+codPostal+"','"+telefono+"','"+estado+"');");
        
    }
    // getters
    public ArrayList<Oferta> getOfertas()
    {
        ArrayList<Oferta> lista= new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM sor_desguace.oferta;");
            while(resultados.next()){
                Oferta nuevo = new Oferta(resultados.getInt("id"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"), resultados.getDouble("importe"), resultados.getInt("desguace"), resultados.getInt("pedido"), resultados.getObject("estado",EstadoOferta.class));
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getInt("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;    
    }
    
    public ArrayList<Desguace> getDesguaces()
    {
        ArrayList<Desguace> lista= new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM sor_desguace.desguace;");
            while(resultados.next()){
                ArrayList listaOfertas = getOfertasDesguace(resultados.getInt("id"));
                Desguace nuevo = new Desguace(resultados.getInt("id"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),listaOfertas);
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getInt("id") + " taller: "+resultados.getInt("taller"));
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
                int pedidoID = resultados.getInt("id");
                ArrayList<Pieza> piezas = getPiezasPedido(pedidoID);
                ArrayList<Integer> cantidades = null;
                getPiezasYCantidades(pedidoID, piezas, cantidades);
                Pedido nuevo = new Pedido(pedidoID, resultados.getInt("taller"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"),resultados.getObject("estado",EstadoPedido.class),piezas,cantidades,getOfertasPedido(pedidoID));
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getInt("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
        
    }
    
    public ArrayList<Pedido> getPedidosTaller(int idTaller){ //devuelve pedidos en general
        ArrayList<Pedido> lista= new ArrayList<>();
        try{
            //conexion.ejecutarSQL("INSERT INTO pedido (id, taller, estado, fecha_alta, fecha_baja, fecha_limite) values ('4', '5','4','2013-03-12', '2013-03-12', '2013-03-12');");
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM sor_gestor.pedido where taller = '" + idTaller + "';");
            while(resultados.next()){
                int pedidoID = resultados.getInt("id");
                ArrayList<Pieza> piezas = getPiezasPedido(pedidoID);
                ArrayList<Integer> cantidades = null;
                getPiezasYCantidades(pedidoID, piezas, cantidades);
                Pedido nuevo = new Pedido(pedidoID, resultados.getInt("taller"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"),resultados.getObject("estado",EstadoPedido.class),piezas,cantidades,getOfertasPedido(pedidoID));
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getInt("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
        
    }
    
    // fin DESGUACES
    
    public ArrayList<Taller> getTalleres()
    {
        ArrayList<Taller> lista= new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM sor_taller.taller;");
            ArrayList<Pedido> listaDePedidos = new ArrayList<>();
            while(resultados.next()){
                listaDePedidos = getPedidosTaller(resultados.getInt("id"));
                Taller nuevo = new Taller(resultados.getInt("id"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),listaDePedidos);
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getInt("id") + " taller: "+resultados.getInt("taller"));
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
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM sor_taller.taller where estado ='"+2+"';");
            while(resultados.next()){
                ArrayList<Pedido> listaDePedidos = new ArrayList<>();
                listaDePedidos = null; // no se necesita para el alta
                Taller nuevo = new Taller(resultados.getInt("id"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),listaDePedidos);
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getInt("id") + " taller: "+resultados.getInt("taller"));
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
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM sor_desguace.desguace where estado ='"+2+"';");
            
            while(resultados.next()){
                ArrayList<Oferta> listaOfertas = new ArrayList<>();
                listaOfertas = null; // inicialmente vacía
                Desguace nuevo = new Desguace(resultados.getInt("id"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),listaOfertas);
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getInt("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
    }
    
    public Pedido getPedido(int id)
    {
        Pedido pedido = null;
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM sor_desguace.pedido where id ='"+id+"';");
            if(resultados != null){
                ArrayList<Pieza> piezas = null;
                ArrayList<Integer> cantidades = null;
                getPiezasYCantidades(id, piezas, cantidades);
                pedido = new Pedido(resultados.getInt("id"),resultados.getInt("tallerID"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"),resultados.getDate("fecha_limite"), resultados.getObject("estado",EstadoPedido.class),piezas,cantidades,getOfertasPedido(id));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return pedido;
    }
    
    public void getPiezasYCantidades(int pedidoID, ArrayList<Pieza> piezas, ArrayList<Integer> cantidades){
        piezas = new ArrayList<>();
        cantidades = new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido_pieza WHERE pedido=" + pedidoID + ";");
            while(resultados.next()){
                piezas.add(getPieza(resultados.getInt("pieza")));
                cantidades.add(resultados.getInt("cantidad"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            //return null;
        }
    }
    
    public Pieza getPieza(int piezaID){
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pieza WHERE id=" + piezaID + ";");
            if(resultados.next()){
                Pieza nueva = new Pieza(piezaID, resultados.getString("nombre"), resultados.getObject("estado", EstadoGeneral.class), resultados.getString("descripcion"));
                return nueva;
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
  
    public ArrayList<Pieza> getPiezasPedido(int pedidoID){
        ArrayList<Pieza> lista = new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM sor_gestor.pedido_pieza WHERE pedido=" + pedidoID + ";");
            while(resultados.next()){
                Pieza nueva = getPieza(resultados.getInt("id"));
                //Pieza nueva = new Pieza(resultados.getInt("id"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"), resultados.getDouble("importe"), resultados.getInt("desguace"), resultados.getInt("pedido"), resultados.getObject("estado",EstadoOferta.class));
                lista.add(nueva);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
        
    }
    
    public ArrayList<Oferta> getOfertasDesguace(int desguaceID){
        ArrayList<Oferta> lista = new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM oferta WHERE desguace=" + desguaceID + ";");
            while(resultados.next()){
                Oferta nueva = new Oferta(resultados.getInt("id"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"), resultados.getDouble("importe"), resultados.getInt("desguace"), resultados.getInt("pedido"), resultados.getObject("estado",EstadoOferta.class));
                lista.add(nueva);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
        
    }
        
    public ArrayList<Oferta> getOfertasPedido(int pedidoID){
        ArrayList<Oferta> lista = new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM oferta WHERE pedido=" + pedidoID + ";");
            while(resultados.next()){
                Oferta nueva = new Oferta(resultados.getInt("id"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"), resultados.getDouble("importe"), resultados.getInt("desguace"), resultados.getInt("pedido"), resultados.getObject("estado",EstadoOferta.class));
                lista.add(nueva);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;
        
    }
    
    public int altaTaller(String nombre, String email, String direccion, String ciudad, int codPostal, int telefono, int estado){
        return conexion.ejecutarInsert("insert into taller (nombre, email, direccion, ciudad, codPostal, telefono, estado) values ('"+nombre+"', '"+email+"','"+direccion+"','"+ciudad+"',"+codPostal+","+telefono+","+estado+");");
    }
    
}
