/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import general.Desguace;
import general.EstadoGeneral;
import general.EstadoPedido;
import general.Oferta;
import general.Pedido;
import general.Pieza;
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
    
    public void anadirDesguace(int id, String nombre, String email, String direccion, String ciudad, String codPostal, String telefono, int estado)
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
                Oferta nuevo = new Oferta(resultados.getInt("id"), resultados.getDate("fecha_alta"), resultados.getDouble("importe"), resultados.getInt("estado"), resultados.getInt("pedido"),resultados.getInt("desguace"),resultados.getDate("fecha_baja"),resultados.getDate("fecha_limite"));
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
                Desguace nuevo = new Desguace(resultados.getInt("id"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),resultados.getInt("estado"));
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getInt("id") + " taller: "+resultados.getInt("taller"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return lista;    
    }
    
    public ArrayList<Pedido> getPedidosActivos(){
        ArrayList<Pedido> lista= new ArrayList<>();
        try{
            //conexion.ejecutarSQL("INSERT INTO pedido (id, taller, estado, fecha_alta, fecha_baja, fecha_limite) values ('4', '5','4','2013-03-12', '2013-03-12', '2013-03-12');");
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM pedido;");
            while(resultados.next()){
                int pedidoID = resultados.getInt("id");
                ArrayList<Pieza> piezas = null;
                ArrayList<Integer> cantidades = null;
                getPiezasYCantidades(pedidoID, piezas, cantidades);
                Pedido nuevo = new Pedido(pedidoID, resultados.getInt("taller"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"),resultados.getObject("estado",EstadoPedido.class),piezas,cantidades,getOfertas(pedidoID));
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
    
    public ArrayList<Oferta> getOfertas(int pedidoID){
        ArrayList<Oferta> lista = new ArrayList<>();
        try{
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM oferta WHERE pedido=" + pedidoID + ";");
            while(resultados.next()){
                Oferta nueva = new Oferta(resultados.getInt("id"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"),resultados.getDouble("precio"), resultados.getInt("desguace"), pedidoID);
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
