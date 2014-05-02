package aspects;

import javax.servlet.http.HttpServletRequest;

import org.apache.cxf.message.Message;
import org.apache.cxf.phase.PhaseInterceptorChain;
import org.apache.cxf.transport.http.AbstractHTTPDestination;

import audit.AuditLogger;
import gestor_taller.*;

public aspect TallerWSAspect {
	pointcut webservice() : execution(public * TallerWS.*(..));

	before() : webservice() {
		Message message = PhaseInterceptorChain.getCurrentMessage();
		HttpServletRequest request = (HttpServletRequest)message.get(AbstractHTTPDestination.HTTP_REQUEST);
        AuditLogger.setIp(request.getRemoteAddr());
    }
	
}
