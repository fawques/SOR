package aspects;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

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
		HttpServletRequest request = (HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
        AuditLogger.setIp(request.getRemoteAddr());
    }
	
}
