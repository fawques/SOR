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
	pointcut taller() : execution(public * TallerWS.*(..));
	pointcut desguace() : execution(public * DesguaceJavaWS.*(..));
	pointcut admin() : execution(public * AdminWS.*(..));

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
	after() : taller()  {
		TallerWS.removeKey(AuditLogger.user);
		resetAudit();
    }
	after() : desguace() {
		DesguaceJavaWS.removeKey(AuditLogger.user);
		resetAudit();
    }
	after() : taller() || desguace() || admin() {
		resetAudit();
    }
	private void resetAudit() {
		AuditLogger.setUser("NO_USER");
		AuditLogger.setIp("NO_IP");
	}
	
}
