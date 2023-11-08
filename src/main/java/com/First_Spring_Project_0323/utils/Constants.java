package com.First_Spring_Project_0323.utils;

public final class Constants {

    private Constants(){}

    public final static String CUSTOMER_TABLE_NAME = "customer";
    public final static int VIP_ALLOWED = 5;


    public static String insertInto(String tableName, String[] columnNames, String[] values){
        String columns = arrayToValues(columnNames);
        String newValues = arrayToValues(values);
        return "INSERT INTO" + tableName + " " + columns + " VALUES " + newValues;
    }

    private static String arrayToValues(String[] arr){
        String result = "(";
        for (int i = 0; i < arr.length; i++) {
            if(i < arr.length-1){
                 result += arr[i] + ",";
            }else{
                result += arr[i];
            }
        }
        result += ")";
        return result;
    }
}
