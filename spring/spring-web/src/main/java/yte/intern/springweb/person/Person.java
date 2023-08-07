package yte.intern.springweb.person;


public record Person(String name,
                     String surname,
                     Long age){}
//public class Person {
//
//    private String name;
//    private String surname;
//    private Long age;
//
//    public Person(String name, String surname, Long age) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public Long getAge() {
//        return age;
//    }
//
//    public void setAge(Long age) {
//        this.age = age;
//    }
//}
