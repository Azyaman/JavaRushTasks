package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry <String, String> entry : params.entrySet()) {
            if (entry.getValue() != null) {
                sb.append(entry.getKey())
                    .append(" = ")
                    .append("'")
                    .append(entry.getValue())
                    .append("'")
                    .append(" and ");
            }
        }
        if (sb.length() == 0) { return ""; }
        else { return sb.toString().substring(0, sb.lastIndexOf(" and")); }
    }
}
