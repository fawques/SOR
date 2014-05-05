package aspects;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.aspectj.lang.reflect.MethodSignature;

import audit.AuditLogger;
import gestor_taller.*;
import gestor_desguace_java.*;
import gestor_admin.*;

public aspect WSAspect {
	pointcut exclude() : execution(public * *.generarClaveReto(..)) || execution(public * *.alta(..)) || execution(public * *.checkActivacion(..));
	pointcut taller() : execution(public !static * TallerWS.*(..));
	pointcut desguace() : execution(public !static * DesguaceJavaWS.*(..));
	pointcut admin() : execution(public !static * AdminWS.*(..));

	before() : taller() || desguace() || admin() {
		Message message = PhaseInterceptorChain.getCurrentMessage();
		if(message!= null){
			HttpServletRequest request = (HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
	        AuditLogger.setIp(request.getRemoteAddr());
		}
		else{
			 AuditLogger.setIp("127.0.0.1");
		}
    }
	after() : taller() && !exclude()  {
		TallerWS.removeKey(AuditLogger.user);
    }
	after() : desguace()  && !exclude(){
		DesguaceJavaWS.removeKey(AuditLogger.user);
    }
	after() : taller() || desguace() || admin() {
		resetAudit();
    }
	private void resetAudit() {
		AuditLogger.setUser("NO_USER");
		AuditLogger.setIp("NO_IP");
	}
	
}
