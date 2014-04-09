package audit;

import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class AuditLogger {
	
	 private static String FQCN =  "audit.AuditLogger";
	
      public static void debug (String userid, String activity,
String activityDetail) {
  //hola
}    

public static void info (String userid, String activity,String activityDetail) {
	MDC.put("ip", "127.0.0.1");
	MDC.put("userid", userid);
    MDC.put("activity", activity);
    
    LoggerFactory.getLogger("auditCRUD").info(activityDetail);
    MDC.clear();
}
}