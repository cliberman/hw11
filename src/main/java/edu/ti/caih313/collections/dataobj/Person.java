package edu.ti.caih313.collections.dataobj;

import java.util.HashMap;

public class Person {
    private Name name;
    private EmailAddress emailAddress;
    private Gender gender;
    //age in years
    //TODO -- replace by Date birthday, and getAge that calculates age
    private Integer age;

    public enum Gender {MALE, FEMALE}

    public Person(Name name, Gender gender, Integer age, EmailAddress emailAddressMap) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        emailAddress = new EmailAddress();
        emailAddress.personsEmailAddress = new HashMap<EmailAddress.EmailType, String>();
    }

    public void EmailAddress(EmailAddress.EmailType emailType, String string ){
        emailAddress.personsEmailAddress.put(emailType, string); }

    public HashMap<EmailAddress.EmailType, String> getEmailMap() {
        return emailAddress.personsEmailAddress;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", gender=" + gender +
                ", age=" + age
                + "}";
    }
}
