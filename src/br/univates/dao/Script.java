package br.univates.dao;

import java.util.ArrayList;

/**
 *
 * @author Matheus
 */
public class Script {

    /**
     * 
     * @param obj - Object
     * @return Retorna o Script do Insert
     */
    public static String getInsert(Object obj) {
        ArrayList<String[]> aColumnsDataType = new ArrayList();
        ArrayList<String> aValues = new ArrayList();
        
        String table = ManipulateClass.getTableClass(obj);
        String primarykey = ManipulateClass.getPrimaryKeyClass(obj);
        String valuePrimaryKey = ManipulateClass.getValuePrimaryKey(obj);
        aColumnsDataType = Util.getDataColumns(table);
        aValues = ManipulateClass.getValuesClass(obj, aColumnsDataType);
        
        int i = 0;
        String query = "INSERT INTO " + table + " (";
        for (String[] string : aColumnsDataType) {
            if ((i < (aColumnsDataType.size() - 1)) 
                    && (!aColumnsDataType.get(i)[0].equals(primarykey))) {
                query += aColumnsDataType.get(i)[0] + ", ";
            } else if (!aColumnsDataType.get(i)[0].equals(primarykey)) {
                query += aColumnsDataType.get(i)[0] + ")";
            }
            i++;
        }
        query += " VALUES (";
        i = 0;
        for (String string : aValues) {
            if ((i < aValues.size() - 1) && (!aColumnsDataType.get(i)[0].equals(primarykey))) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char") 
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")) {
                    query += "'" + aValues.get(i) + "', ";
                } else {
                    query += aValues.get(i) + ", ";
                }
            } else if (!aColumnsDataType.get(i)[0].equals(primarykey)) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char") 
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")) {
                    query += "'" + aValues.get(i) + "')";
                } else {
                    query += aValues.get(i) + ") ";
                }
            }
            i++;
        }
        return query;
    }

    /**
     * 
     * @param obj - Object
     * @return Retorna o Script do Update
     */
    public static String getUpdate(Object obj) {
        ArrayList<String[]> aColumnsDataType = new ArrayList();
        ArrayList<String> aValues = new ArrayList();
        String query;
        
        String table = ManipulateClass.getTableClass(obj);
        String primaryKey = ManipulateClass.getPrimaryKeyClass(obj);
        String valuePrimaryKey = ManipulateClass.getValuePrimaryKey(obj);
        
        aColumnsDataType = Util.getDataColumns(table);
        aValues = ManipulateClass.getValuesClass(obj, aColumnsDataType);
        
        query = "UPDATE " + table + " SET ";
        int i = 0;
        for (String string : aValues) {
            if ((i < aValues.size() - 1) && (!aColumnsDataType.get(i)[0].equals(primaryKey))) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char") 
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")) {
                    query += aColumnsDataType.get(i)[0] + " = '" + aValues.get(i) + "', ";
                } else {
                    query += aColumnsDataType.get(i)[0] + " = " + aValues.get(i) + ", ";
                }
            } else if (!aColumnsDataType.get(i)[0].equals(primaryKey)) {
                if (aColumnsDataType.get(i)[1].equals("varchar") || aColumnsDataType.get(i)[1].equals("char") 
                        || aColumnsDataType.get(i)[1].equals("date") || aColumnsDataType.get(i)[1].equals("datetime")) {
                    query += aColumnsDataType.get(i)[0] + " = '" + aValues.get(i) + "' ";
                } else {
                    query += aColumnsDataType.get(i)[0] + " = " + aValues.get(i) + " ";
                }
            }
            i++;
        }
        query += "WHERE " + primaryKey + " = " + valuePrimaryKey;
        return query;
    }
    
}
