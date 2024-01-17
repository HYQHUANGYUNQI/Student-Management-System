package com.example.demo.entity;

import java.sql.ResultSet;

/**

  * @author oyc

  * @Description:用户实体类

  * @date 2018/7/8 22:51

  */

public class Student {


        public String getSid() {
                return sid;
        }

        public void setSid(String sid) {
                this.sid = sid;
        }

        public String getSname() {
                return sname;
        }

        public void setSname(String sname) {
                this.sname = sname;
        }

        public String getSex() {
                return sex;
        }

        public void setSex(String sex) {
                this.sex = sex;
        }

        public int getEn_age() {
                return en_age;
        }

        public void setEn_age(int en_age) {
                this.en_age = en_age;
        }

        public int getEn_year() {
                return en_year;
        }

        public void setEn_year(int en_year) {
                this.en_year = en_year;
        }

        public String getClazz() {
                return clazz;
        }

        public void setClazz(String clazz) {
                this.clazz = clazz;
        }

        private String sid;
        private String sname;
        private String sex;
        private int en_age;
        private int en_year;
        private String clazz;



        }