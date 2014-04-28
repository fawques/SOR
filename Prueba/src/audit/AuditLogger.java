package audit;

import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import taller.MainTaller;

public class AuditLogger {
	
	 private static String FQCN =  "audit.AuditLogger";

	 public static void info (String activity,String activityDetail) {
		info(MainTaller.nombreUsuario,activity,activityDetail);
	}
	 
	public static void info (String userid, String activity,String activityDetail) {
		MDC.put("ip", "127.0.0.1");
		MDC.put("userid", userid);
	    MDC.put("activity", activity);
	    
	    LoggerFactory.getLogger("auditCRUD").info(activityDetail);
	    MDC.clear();
	}
	
	public static void error (String errorDetail) {
		error(MainTaller.nombreUsuario, errorDetail);
	}
	
	public static void error (String userid,String errorDetail) {
		MDC.put("ip", "127.0.0.1");
		MDC.put("userid", userid);
	    MDC.put("activity", "ERROR");
	    
	    LoggerFactory.getLogger("auditERROR").error(errorDetail);
	    MDC.clear();
	}
}