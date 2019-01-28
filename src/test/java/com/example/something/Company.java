package com.example.something;

public class Company {
    String companyNam;
    static String country;
    static class Clear{
        String name;
        public Clear() {
            // TODO Auto-generated constructor stub
        }

        public Clear(String name) {
            super();
            this.name = name;
        }

        public void work(String name){
            int a = 0;
            int b = a=9;
            String na=new Company().companyNam ="联想";
            country="中国";
            System.out.println(name+"为"+na+"打扫卫生，该公司属于"+country);
        }
    }
}
