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
    // setters
    public int anadirOferta(int id, Date fechaAlta, float importe, int estado, int pedido, int desguace, Date fechaBaja, Date fechaLimite)    {
        // TODO: cambiar el id
        return conexion.ejecutarInsert("insert INTO oferta (id, fecha_alta, importe, estado, pedido, desguace, fecha_baja, fecha_limite) values ('" + id + "','" + fechaAlta + "', '" + importe + "','" + estado + "','" + pedido + "';" + desguace + "','" + fechaBaja + "','" + fechaLimite + "');");
    }
    
    public void anadirPedido(String id, Date fechaAlta, int estado, String taller, Date fechaBaja, Date fechaLimite)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        conexion.ejecutarSQL("insert INTO pedido (id, fecha_alta, estado, taller, fecha_baja, fecha_limite) values ('"+id+"',"+(fechaAlta != null? "'"+dateFormat.format(fechaAlta)+ "'":fechaAlta)+",'"+estado+"','"+taller+"',"+(fechaBaja != null?"'" + dateFormat.format(fechaBaja) + "'":fechaBaja)+","+(fechaLimite != null? "'" + dateFormat.format(fechaLimite) + "'":fechaLimite)+");");
    }
    
    public int anadirPedido(Date fechaAlta, EstadoPedido estado, String taller, Date fechaBaja, Date fechaLimite) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return conexion.ejecutarInsert("insert INTO pedido (id, fecha_alta, estado, taller, fecha_limite) values ('', " + (fechaAlta != null? "'"+dateFormat.format(fechaAlta)+ "'":fechaAlta) + ",'" + estado.ordinal() + "','" + taller + "', " + (fechaLimite != null? "'"+dateFormat.format(fechaLimite)+ "'":fechaLimite) + ");");
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
                Oferta nuevo = new Oferta(resultados.getString("id"), resultados.getDouble("importe"), resultados.getString("desguace"), resultados.getString("pedido"),resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"), EstadoOferta.values()[resultados.getInt("estado")] );
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
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
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM desguace;");
            while(resultados.next()){
                ArrayList listaOfertas = getOfertasDesguace(resultados.getString("id"));
                Desguace nuevo = new Desguace(resultados.getString("id"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")] ,listaOfertas);
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

                Pedido nuevo = new Pedido(pedidoID, resultados.getString("taller"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"),EstadoPedido.values()[resultados.getInt("estado")],piezas,cantidades,getOfertasPedido(pedidoID));
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
                getPiezasYCantidades(pedidoID, piezas, cantidades);
                Pedido nuevo = new Pedido(pedidoID, resultados.getString("taller"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"),EstadoPedido.values()[resultados.getInt("estado")],piezas,cantidades,getOfertasPedido(pedidoID));
                lista.add(nuevo);
                //System.out.println("id: " + resultados.getString("id") + " taller: "+resultados.getInt("taller"));
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
            ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM taller;");
            ArrayList<Pedido> listaDePedidos = new ArrayList<>();
            while(resultados.next()){
                Taller nuevo;
                if ("".equals(resultados.getString("id"))) {
                    // estamos en taller, y está todavía pendiente
                    nuevo = new Taller("", resultados.getInt("id_aux"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"), EstadoGeneral.values()[resultados.getInt("estado")], listaDePedidos);
                }else{
                    // estamos en gestor o en taller
                    listaDePedidos = getPedidosTaller(resultados.getString("id"));
                    nuevo = new Taller(resultados.getString("id"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaDePedidos);
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
                Taller nuevo = new Taller(resultados.getString("id"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaDePedidos);
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
                Desguace nuevo = new Desguace(resultados.getString("id"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaOfertas);
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

                pedido = new Pedido(resultados.getString("id"),resultados.getString("taller"), resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"),resultados.getDate("fecha_limite"),EstadoPedido.values()[resultados.getInt("estado")] ,piezas,cantidades,getOfertasPedido(id));

            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        return pedido;
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
                Oferta nueva = new Oferta(resultados.getString("id"),  resultados.getDouble("importe"), resultados.getString("desguace"), resultados.getString("pedido"),resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"), EstadoOferta.values()[resultados.getInt("estado")]);
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
            while(resultados.next()){

                Oferta nueva = new Oferta(resultados.getString("id"),  resultados.getDouble("importe"), resultados.getString("desguace"), resultados.getString("pedido"),resultados.getDate("fecha_alta"), resultados.getDate("fecha_baja"), resultados.getDate("fecha_limite"), EstadoOferta.values()[resultados.getInt("estado")]);

                lista.add(nueva);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return lista;

    }
    
    public Taller getTaller(String email){
        ResultSet resultados = conexion.ejecutarSQLSelect("SELECT * FROM taller WHERE email='" + email + "';");
        try {
            if (resultados.first()) {
                final String tallerID = resultados.getString("id");
                if("".equals(tallerID)){
                    return new Taller("", resultados.getInt("id_aux"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"), EstadoGeneral.values()[resultados.getInt("estado")], new ArrayList<Pedido>());
                }else{
                    ArrayList<Pedido> listaDePedidos = getPedidosTaller(resultados.getString("id"));
                    return new Taller(tallerID, resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaDePedidos);
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
                    return new Taller("", resultados.getInt("id_aux"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"), EstadoGeneral.values()[resultados.getInt("estado")], new ArrayList<Pedido>());
                }else{
                    ArrayList<Pedido> listaDePedidos = getPedidosTaller(resultados.getString("id"));
                    return new Taller(resultados.getString("id"), resultados.getString("nombre"), resultados.getString("email"), resultados.getString("direccion"), resultados.getString("ciudad"),resultados.getInt("codPostal"),resultados.getInt("telefono"),EstadoGeneral.values()[resultados.getInt("estado")],listaDePedidos);
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
        return res > 0;
    }
    
    // método que llaman talleres y desguaces, sin id (lo autogenera la bd)
    public int altaTaller(String nombre, String email, String direccion, String ciudad, int codPostal, int telefono, int estado) {
        return conexion.ejecutarInsert("insert into taller (nombre, email, direccion, ciudad, codPostal, telefono, estado) values ('" + nombre + "', '" + email + "','" + direccion + "','" + ciudad + "'," + codPostal + "," + telefono + "," + estado + ");");
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
        return conexion.ejecutarSQL("UPDATE `taller` SET `id`='" + idRecibido + "', `estado`='0'");
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
                getPiezasYCantidades(idPedido, piezas, cantidades);

                Pedido p = new Pedido(pedidos.getNString("id"),
                        pedidos.getInt("id_aux"), pedidos.getNString("taller"), pedidos.getDate("fecha_alta"), pedidos.getDate("fecha_baja"), pedidos.getDate("fecha_limite"), EstadoPedido.values()[pedidos.getInt("estado")],
                        piezas, cantidades, getOfertasPedido(pedidos.getNString("id")));
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
        /*if (modoAceptacion.isEmpty()) {            if (sWhere.isEmpty()) {
                sWhere += " and ";
            }
            sWhere +="";
         }*/
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
                conexion.ejecutarInsert("Insert into pedido_pieza(pedido,pieza,cantidad) values ('" + idPedido + "', '" + piezas.get(i) + "', '" + cantidades.get(i) + "')");
            }
            return true;
        }
        return false;
    }
}
