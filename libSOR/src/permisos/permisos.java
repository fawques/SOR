package permisos;
import java.nio.file.AccessDeniedException;
import java.sql.SQLException;

import BD.InterfazBD;
public class permisos {
	public permisos(){
		
	}

	public Boolean comprobarPermisos(String basedatos,String usuario,String funcion) throws AccessDeniedException{
		try {
			InterfazBD bd= new InterfazBD(basedatos);
			Boolean permisos= bd.comprobarPermisos(usuario,funcion);
			bd.close();
			if(permisos==false){
				
				
				throw ( new AccessDeniedException("El usuario "+usuario+ " no tiene acceso a la función "+funcion) );
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
