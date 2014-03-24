package aspects;
import webservices.*;
import BD.InterfazBD;
public aspect AuditAspect {

	pointcut webservice() : execution(* Webservices.*(..));

    before() : webservice() {
    	String salida = "Llamando a un webservice de Gestor: <" + thisEnclosingJoinPointStaticPart.toShortString() + "(";
        for (Object arg : thisJoinPoint.getArgs()) {
        	 salida+= arg + ",";            	
        }
        salida += ")>";
        System.out.println(salida);
    }

}
