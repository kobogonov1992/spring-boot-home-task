package kg.megacom.springboothometask;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Student {
    private String name;
    private double averageGrade;

    public Student(@Qualifier("getStudentName2") String name, double averageGrade) {
        // @Qualifier подставляет один из String параметров Бинов из @Config class
        // Используем @Qualifier вместо @Primary
        this.name = name;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", averageGrade=" + averageGrade +
                '}';
    }
}
