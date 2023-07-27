package Practise7;

public class Student {
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Department: " + department + ", GPA: " + gpa;
    }

    Student(String name, int age, String department, double gpa) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.gpa = gpa;
    }

    private String name;
    private int age;
    private String department;
    private double gpa;


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getGpa() {
        return gpa;
    }


}
