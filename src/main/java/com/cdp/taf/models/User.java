package com.cdp.taf.models;

import com.opencsv.bean.CsvBindByName;

public class User {

    @CsvBindByName
    private String fName;
    @CsvBindByName
    private String lName;
    @CsvBindByName
    private String email;
    @CsvBindByName
    private String password;
    @CsvBindByName
    private int DOBday;
    @CsvBindByName
    private int DOBmonth;
    @CsvBindByName
    private int DOByear;
    @CsvBindByName
    private int gender;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDOBday() {
        return DOBday;
    }

    public void setDOBday(int DOBday) {
        this.DOBday = DOBday;
    }

    public int getDOBmonth() {
        return DOBmonth;
    }

    public void setDOBmonth(int DOBmonth) {
        this.DOBmonth = DOBmonth;
    }

    public int getDOByear() {
        return DOByear;
    }

    public void setDOByear(int DOByear) {
        this.DOByear = DOByear;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public User() {
    }

    public User(String fName, String lName, String email, String password, int DOBday, int DOBmonth, int DOByear, int gender) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.DOBday = DOBday;
        this.DOBmonth = DOBmonth;
        this.DOByear = DOByear;
        this.gender = gender;
    }


    public static class Builder {
        private String fName;
        private String lName;
        private String email;
        private String password;
        private int doBday;
        private int doBmonth;
        private int doByear;
        private int gender;

        public Builder setfName(String fName) {
            this.fName = fName;
            return this;
        }

        public Builder setlName(String lName) {
            this.lName = lName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setDOBday(int doBday) {
            this.doBday = doBday;
            return this;
        }

        public Builder setDOBmonth(int doBmonth) {
            this.doBmonth = doBmonth;
            return this;
        }

        public Builder setDOByear(int doByear) {
            this.doByear = doByear;
            return this;
        }

        public Builder setGender(int gender) {
            this.gender = gender;
            return this;
        }

        public User build() {
            return new User(fName, lName, email, password, doBday, doBmonth, doByear, gender);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", DOBday=" + DOBday +
                ", DOBmonth=" + DOBmonth +
                ", DOByear=" + DOByear +
                ", gender=" + gender +
                '}';
    }
}
