package com.kevo.mortgageCalculator.annotations;

import org.springframework.core.annotation.AnnotationConfigurationException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/* method to make use of @ChangeRate annotation.
1. check if field has change rate annotation, else throw an error
2. set field to accessible
3. set field to new random number
4. set field to inaccessible
 */
public class RateExecution {
    public static void change(Object object) throws InvocationTargetException, IllegalAccessException, InterruptedException {
        checkForAnnotation(object);
        randomizeRate(object);
    }
    private static void checkForAnnotation(Object object) {
        if (Objects.isNull(object)) throw new AnnotationConfigurationException("Class is null");
    }
    private static void randomizeRate(Object object) throws InvocationTargetException, IllegalAccessException, InterruptedException {
        Class<?> classObject = object.getClass();
        for(Method method: classObject.getDeclaredMethods() ){
            if(method.isAnnotationPresent(ChangeRate.class)){
                ChangeRate annotation = method.getAnnotation(ChangeRate.class);
                method.setAccessible(true);
                Thread thread = getThread(object, method, annotation);
                thread.start();
            }
        }
    }

    private static Thread getThread(Object object, Method method, ChangeRate annotation) {
        return new Thread(()->{
            for(int i = 0; i< annotation.interval(); i++){
                try {
                    Thread.sleep(1000);
                    System.out.println("Rate reset");
                    method.invoke(object);
                }
                catch (InterruptedException | InvocationTargetException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
