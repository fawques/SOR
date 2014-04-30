package audit;

import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import taller.MainTaller;

public class AuditLogger {
	
	 private static String FQCN =  "audit.AuditLogger";
	 private static String ip = "127.0.0.1";

	 public static void info (String activity,String activityDetail) {
		info(MainTaller.nombreUsuario,activity,activityDetail);
	}
	 
	public static void info (String userid, String activity,String activityDetail) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", activity);
	    
	    LoggerFactory.getLogger("auditInfo").info(activityDetail);
	    MDC.clear();
	}
	
	public static void error (String errorDetail) {
		error(MainTaller.nombreUsuario, errorDetail);
	}
	
	public static void error (String userid,String errorDetail) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "ERROR");
	    
	    LoggerFactory.getLogger("auditError").error(errorDetail);
	    MDC.clear();
	}
	
	public static void ES (String detalle) {
		ES(MainTaller.nombreUsuario, detalle);
	}
	
	public static void ES (String userid,String detalle) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "Entrada/Salida");
	    
	    LoggerFactory.getLogger("auditInfo").info(detalle);
	    MDC.clear();
	}
	
	public static void aprovisionamiento (String detalle) {
		aprovisionamiento(MainTaller.nombreUsuario, detalle);
	}
	
	public static void aprovisionamiento (String userid,String detalle) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "Aprovisionamiento");
	    
	    LoggerFactory.getLogger("auditInfo").info(detalle);
	    MDC.clear();
	}
	
	public static void CRUD (String detalle) {
		CRUD(MainTaller.nombreUsuario, detalle);
	}
	
	public static void CRUD (String userid,String detalle) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "CRUD");
	    
	    LoggerFactory.getLogger("auditInfo").info(detalle);
	    MDC.clear();
	}
	
	public static void informe (String detalle) {
		informe(MainTaller.nombreUsuario, detalle);
	}
	
	public static void informe (String userid,String detalle) {
		MDC.put("ip", ip);
		MDC.put("userid", userid);
	    MDC.put("activity", "Informe");
	    
	    LoggerFactory.getLogger("auditInfo").info(detalle);
	    MDC.clear();
	}
	
}