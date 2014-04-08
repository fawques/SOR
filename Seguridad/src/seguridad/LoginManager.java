package seguridad;

import java.sql.SQLException;

import BD.InterfazBD;

public class LoginManager {
	String database;
	
	public LoginManager(String database){
		this.database = database;
	}
	
	public boolean login(String username, String password) throws ClassNotFoundException, SQLException{
		InterfazBD bd = new InterfazBD(database);
		boolean ok = bd.login(username, password);
		bd.close();
		return ok;
	}

}
