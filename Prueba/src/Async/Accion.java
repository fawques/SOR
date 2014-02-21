/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Async;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import taller.MainTaller;

/**
 *
 * @author fawques
 */
public class Accion {
    String name;
    Class<?> paramTypes[];
    //Type paramTypesType[];
    String paramValues[];

    public Accion(String name, Class<?>[] paramTypes, /*Type paramTypesType[], */String[] paramValues) {
        this.name = name;
        this.paramTypes = paramTypes;
        //this.paramTypesType = paramTypesType;
        this.paramValues = paramValues;
    }

    public Accion(Method m, String[] paramValues) {
        this.name = m.getName();
        this.paramTypes = m.getParameterTypes();
        //this.paramTypesType = m.getGenericParameterTypes();
        this.paramValues = paramValues;
    }
    
    public void invocar(){
        try {
            // forName de los parámetros, y después un invocar a pelo de MainTaller -- Cómo?
        	Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            Method method = MainTaller.class.getMethod(name,paramTypes);
            Object params[] = new Object[paramValues.length];
            for (int i = 0; i < paramValues.length; i++) {
				params[i] = gson.fromJson(paramValues[i], paramTypes[i]);
			}
            method.invoke(null,params);
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
        //String typesTypes = "";
        String values = "";
        for (int i = 0; i < paramTypes.length; i++) {
            if (i != 0) {
                types += "|";
              //  typesTypes += "|";
                values += "|";
            }
            types += paramTypes[i].getName();
            //typesTypes += paramTypesType[i];
            values += paramValues[i];
        }
        return name + ":__:" + types + ":__:" /*+ typesTypes + ":__:" */+ values;
    }
    
    
    
}
