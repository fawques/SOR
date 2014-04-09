package seguridad;

import general.Desguace;
import general.Taller;

import java.sql.SQLException;

import BD.InterfazBD;

public class LoginManager {
	String database;
	
	public LoginManager(String database){
		this.database = database;
	}
	
	public boolean login(String username, String password) throws ClassNotFoundException, SQLException{
		boolean ok = false;
		InterfazBD bd = new InterfazBD(database);
		Taller t = bd.getTallerActivar(username,password);
		if (t != null) {
			ok = true;
		}else{
			Desguace d = bd.getDesguaceActivar(username,password);
			if (d != null) {
				ok = true;
			}
		}
		bd.close();
		return ok;
	}

}
