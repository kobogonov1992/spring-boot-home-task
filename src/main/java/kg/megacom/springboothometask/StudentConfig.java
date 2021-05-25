package kg.megacom.springboothometask;

import org.springframework.context.annotation.*;

@Configuration
//@Configuration Эта аннотация, прописанная перед классом, означает,
// что класс может быть использован контейнером Spring IoC
// в данном случае  как конфигурационный класс для бинов.
// И может быть вызван через AnnotationConfigApplicationContext (Student.class)

@ComponentScan(basePackageClasses = Mentor.class)
public class StudentConfig {

    @Bean(name={"student1"})
    public Student getStudent (){
        return  new Student("Dima", 9.9);
    }

    @Bean(name="student2")
    public Student getNewStudent (){
        return  new Student("Elina", 8.8);
    }

    @Bean
    //@Primary  // Bean in case of two similar parameters as String
    // Doesn't work when we using @Qualifier in @Component class
    public String getStudentName1(){
        return "Dilbara";
    }

    @Bean
    public String getStudentName2(){
        return "Lisa";
    }

    @Bean
    public double getAverageGrade(){
        return 6.6;
    }
}
