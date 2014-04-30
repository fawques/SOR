package audit;

import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class AuditLogger {
	
	 private static String FQCN =  "audit.AuditLogger";
	 private static String ip = "NO_IP";
	 private static String user = "NO_USER";
	 
	 public static void setUser(String newuser){
		 user = newuser;
	 }

	 public static void info (String activity,String activityDetail) {
		info(user,activity,activityDetail);
	}
	 
	public static void info (String userid, String activity,String activityDetail) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", activity);
	    
	    LoggerFactory.getLogger("auditInfo").info(activityDetail);
	    MDC.clear();
	}
	
	public static void error (String errorDetail) {
		error(user, errorDetail);
	}
	
	public static void error (String userid,String errorDetail) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "ERROR");
	    
	    LoggerFactory.getLogger("auditError").error(errorDetail);
	    MDC.clear();
	}
	
	public static void ES (String detalle) {
		ES(user, detalle);
	}
	
	public static void ES (String userid,String detalle) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "Entrada/Salida");
	    
	    LoggerFactory.getLogger("auditInfo").info(detalle);
	    MDC.clear();
	}
	
	public static void aprovisionamiento (String detalle) {
		aprovisionamiento(user, detalle);
	}
	
	public static void aprovisionamiento (String userid,String detalle) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "Aprovisionamiento");
	    
	    LoggerFactory.getLogger("auditInfo").info(detalle);
	    MDC.clear();
	}
	
	public static void informe (String detalle) {
		informe(user, detalle);
	}
	
	public static void informe (String userid,String detalle) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "Informe");
	    
	    LoggerFactory.getLogger("auditInfo").info(detalle);
	    MDC.clear();
	}

	public static void CRUD_Desguace (String detalle) {
		CRUD_Desguace(user, detalle);
	}
	
	public static void CRUD_Desguace (String userid,String detalle) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "CRUD_Taller");
	    
	    LoggerFactory.getLogger("auditInfo").info(detalle);
	    MDC.clear();
	}

	public static void CRUD_Taller (String detalle) {
		CRUD_Taller(user, detalle);
	}
	
	public static void CRUD_Taller (String userid,String detalle) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "CRUD_Taller");
	    
	    LoggerFactory.getLogger("auditInfo").info(detalle);
	    MDC.clear();
	}
	

	public static void CRUD_Pedido (String detalle) {
		CRUD_Pedido(user, detalle);
	}
	
	public static void CRUD_Pedido (String userid,String detalle) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "CRUD_Pedido");
	    
	    LoggerFactory.getLogger("auditInfo").info(detalle);
	    MDC.clear();
	}
	

	public static void CRUD_Oferta (String detalle) {
		CRUD_Oferta(user, detalle);
	}
	
	public static void CRUD_Oferta (String userid,String detalle) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "CRUD_Oferta");
	    
	    LoggerFactory.getLogger("auditInfo").info(detalle);
	    MDC.clear();
	}
	
}