package Practise7;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class P7Main {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Ali", 18, "Computer Science", 3.5),
                new Student("Ayşe", 20, "Biology", 3.2),
                new Student("Mehmet", 17, "Electrical Engineering", 3.0),
                new Student("Zeynep", 19, "Mathematics", 3.8),
                new Student("Ahmet", 21, "Physics", 3.1),
                new Student("Hayriye", 21, "Physics", 3.5),
                new Student("Veli", 49, "Computer Science", 3.0)
        ));

        System.out.println(calculateGpa(students));

        Map<java.lang.String, List<Student>> studentByDepartment = students.stream().collect(groupingBy(Student::getDepartment));

        System.out.println(studentByDepartment);

        Map<java.lang.String,Double> averageGpaByDepartment = students.stream().collect(groupingBy(Student::getDepartment, averagingDouble(Student::getGpa)));

        //String GpaHighestDepartment = Map.Entry.comparingByValue(averageGpaByDepartment);
        // My Way with loop
        Map.Entry<java.lang.String,Double> maxEntry = null;
        for (Map.Entry<java.lang.String,Double> entry : averageGpaByDepartment.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        // Final solution with stream
        String departmentWithHighestAverageGpa = averageGpaByDepartment.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");

        //.stream().collect(groupingBy(Student::getDepartment, maxBy(Comparator.comparingDouble(Student::getGpa))));
        System.out.println(averageGpaByDepartment);
        //"Department that The Highest Average Gpa = "
        System.out.println(maxEntry);


    }

    public static double calculateGpa(List<Student> studentList) {


        double result = studentList.stream().filter(a -> (a.getGpa() >= 3.0) && (a.getAge() < 20)).map(u -> u.getGpa()).reduce(0.0, Double::sum);

        return result;
    }
}
