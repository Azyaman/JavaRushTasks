package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        public String getCountryCode() {
            String code = null;
            for (Map.Entry<String, String> pair : countries.entrySet()) {
                if (customer.getCountryName().equals(pair.getValue())) {code = pair.getKey();}
            }
            return code;
        }

        public String getCompany() {
            return customer.getCompanyName();
        }

        public String getContactFirstName() {
            String name = contact.getName().replaceAll(",", "");
            String[] names = name.split(" ");
            return names[1];
        }

        public String getContactLastName() {
            String name = contact.getName().replaceAll(",", "");
            String[] names = name.split(" ");
            return names[0];
        }

        public String getDialString() {
            String phone = contact.getPhoneNumber().replaceAll("[(]|[)]|[-]", "");
            return "callto://" + phone;

        }




    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}