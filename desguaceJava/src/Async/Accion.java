/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Async;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fawques
 */
import desguace.DesguaceJava;
public class Accion {
    String name;
    Class<?> paramTypes[];
    String paramValues[];

    public Accion(String name, Class<?>[] paramTypes, String[] paramValues) {
        this.name = name;
        this.paramTypes = paramTypes;
        this.paramValues = paramValues;
    }

    public Accion(Method m, String[] paramValues) {
        this.name = m.getName();
        this.paramTypes = m.getParameterTypes();
        this.paramValues = paramValues;
    }
    
    public void invocar(){
        try {
            // forName de los parámetros, y después un invocar a pelo de MainTaller -- Cómo?
            Method method = DesguaceJava.class.getMethod(name,paramTypes);
            method.invoke(null,paramValues);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Accion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Accion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Accion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Accion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Accion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public String toString() {
        String types = "";
        String values = "";
        for (int i = 0; i < paramTypes.length; i++) {
            if (i != 0) {
                types += "|";
                values += "|";
            }
            types += paramTypes[i].getName();
            values += paramValues[i];
        }
        return name + ":" + types + ":" + values;
    }
    
    
    
}
