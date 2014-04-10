package aspects;
import audit.AuditLogger;
import webservices.*;
import BD.InterfazBD;
public aspect AuditAspect {

	pointcut webservice() : execution(* Webservices.*(..));

    before() : webservice() {
        AuditLogger.info("USUARIO", "ACTIVITY", "DETALLE");
    }

}
