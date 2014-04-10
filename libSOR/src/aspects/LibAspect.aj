package aspects;

import BD.*;

public aspect LibAspect {
	pointcut bd() : execution(* InterfazBD.*(..));
	
	before() : bd() { 
        System.out.println("Llamando a la BD: <" + thisEnclosingJoinPointStaticPart.toShortString() + ">");
    }
}
