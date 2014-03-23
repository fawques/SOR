package aspects;
import webservices.*;
import BD.InterfazBD;
public aspect AuditAspect {

	pointcut webservice(String s) : execution(* Webservices.*(..)) && args(s);
	pointcut bd() : call(* InterfazBD.*(..));

    before(String s) : webservice(s) { 
        System.out.println("Llamando a un webservice de Gestor: <" + thisEnclosingJoinPointStaticPart.toShortString() + "(" + s + ")>");
    }
    
    before() : bd() { 
        System.out.println("Llamando a la BD: <" + thisEnclosingJoinPointStaticPart.toShortString() + ">");
    }

}
