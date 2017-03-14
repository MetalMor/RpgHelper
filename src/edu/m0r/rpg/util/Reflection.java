/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.m0r.rpg.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author m0r
 */
public class Reflection {
    private static ParameterizedType getGenericSuperclass(Object generic) {
        return (ParameterizedType) generic.getClass().getGenericSuperclass();
    }
    
    public static Class getParameterizedType(Object generic) {
        return getParameterizedType(generic, 0);
    }
    
    public static Class getParameterizedType(Object generic, int indexType) {
        return (Class) getGenericSuperclass(generic).getActualTypeArguments()[indexType];
    }
    
    public static Constructor getParameterizedConstructor(Object generic, int indexConstructor) {
        return getParameterizedType(generic).getConstructors()[indexConstructor];
    }
    
    public static Constructor getParameterizedConstructor(Object generic, Class... params) {
        try {
            return getParameterizedType(generic).getConstructor(params);
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static Constructor getParameterizedConstructor(Object generic) {
        return getParameterizedConstructor(generic, 0);
    }
    
    public static Object getParameterizedInstance(Object generic, int indexType) {
        try {
            return getParameterizedType(generic).newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Object getParameterizedInstance(Object generic) {
        return getParameterizedInstance(generic, 0);
    }
    
    public static Object getInstance(Constructor cons, Object... params) {
        try {
            return cons.newInstance(params);
        } catch (InstantiationException | InvocationTargetException |
                IllegalArgumentException | IllegalAccessException ex) {
            Logger.getLogger(Reflection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
