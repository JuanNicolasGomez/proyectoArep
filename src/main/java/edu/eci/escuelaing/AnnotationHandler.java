package edu.eci.escuelaing;

import edu.eci.escuelaing.annotations.Webapp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationHandler {


    public AnnotationHandler( ){

    }

    public String handle(Class<?> cl, String param) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method method = null;
        for (Method m : cl.getMethods()) {
            if (m.isAnnotationPresent(Webapp.class)) {
                method = m;
            }
        }


        return (String) method.invoke(cl.newInstance(), param);
    }


}
