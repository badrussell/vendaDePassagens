package br.univates.persistencia;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class ManipulateClass {

    public static String getTableClass(Object obj) {
        String ret = "";

        try {
        
            Class classe = obj.getClass();
            for (Method m : classe.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Bd.class)) {
                    if (m.getName().toLowerCase().replace("get", "").equals("table")) {
                        ret = m.invoke(obj).toString();
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return ret;
    }


    public static String getPrimaryKeyClass(Object obj) {
        String ret = "";

        try {
            Class classe = obj.getClass();
            for (Method m : classe.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Bd.class)) {
                    if (m.getName().toLowerCase().replace("get", "").equals("primarykey")) {
                        ret = m.invoke(obj).toString();
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return ret;
    }


    public static ArrayList<String> getValuesClass(Object obj, ArrayList<String []> aColumns) {

        Class classe = obj.getClass();
        ArrayList<String> aValues = new ArrayList();
        int i = 0;
        try {
            for (String[] aColumn : aColumns) {
                for (Method m : classe.getDeclaredMethods()) {
                    if (m.getName().toLowerCase().replace("get", "").equals(aColumns.get(i)[0].toLowerCase())) {
                        aValues.add(m.invoke(obj).toString());
                    }
                }
                i++;
            }
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
        }

        return aValues;
    }


    public static String getValuePrimaryKey(Object obj) {
        String ret = "";
        String primaryKey = getPrimaryKeyClass(obj);

        try {
            Class classe = obj.getClass();
            for (Method m : classe.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Bd.class)) {
                    if (m.getName().toLowerCase().replace("get", "").equals(primaryKey.toLowerCase())) {
                        ret = m.invoke(obj).toString();
                    }
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return ret;

    }

}
