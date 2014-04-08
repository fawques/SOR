package permisos;
import java.sql.SQLException;

import BD.InterfazBD;
public class permisos {


	public Boolean comprobarPermisos(String basedatos,String usuario,String funcion) throws Exception{
		try {
			InterfazBD bd= new InterfazBD(basedatos);
			Boolean permisos= bd.comprobarPermisos(usuario,funcion);
			bd.close();
			if(permisos==false){
				
				throw ( new Exception("El usuario "+usuario+ "no tiene acceso a la función "+funcion) );
			}
			return permisos;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
