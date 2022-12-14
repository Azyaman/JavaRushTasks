package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;
        IncomeDataAdapter (IncomeData data) {
            this.data = data;
        }

        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        public String getCompanyName() {
            return data.getCompany();
        }

        public String getPhoneNumber() {
            String phone = String.valueOf(data.getPhoneNumber());
            StringBuilder allNumber = new StringBuilder(data.getCountryPhoneCode());
            if (phone.length()< 10){
                for (int i = 0; i < 10 - phone.length(); i++) {
                    allNumber.insert(0,'0');
                }
            }
            allNumber.append(phone);
            return  String.format( "+" + data.getCountryPhoneCode() + "("+ allNumber.substring(0,3) + ")"
                    + allNumber.substring(3,6) + "-" + allNumber.substring(6,8) + "-" + allNumber.substring(8,10));
        }

        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }



    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
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