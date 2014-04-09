package aspects;

import gestor_taller.*;

public aspect TallerWSAspect {
	pointcut webservice_exclude() : execution(* TallerWS.generarClaveReto(..));
	pointcut webservice(String idTaller) : execution(!static public * TallerWS.*(String,..)) && args(idTaller,..) && !webservice_exclude();

	after(String idTaller) : webservice(idTaller) {
        TallerWS.removeKey(idTaller);
    }
	
}
