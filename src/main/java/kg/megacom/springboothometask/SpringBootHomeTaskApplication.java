package kg.megacom.springboothometask;

import kg.megacom.springboothometask.service.StudentService;
import kg.megacom.springboothometask.service.impl.StudentServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringBootHomeTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHomeTaskApplication.class, args);

        // Бины можно вызывать с помощью 4 способов конфигураций: 1 xml config - ClassPathXmlApplicationContext(”context.xml”)
        // 2 Groovy config - GenericGroovyApplicationContext(”context.groovy”)
        // 3 Наш случай описанный в примере через @аннотацию и указанием пакета для сканирования
        // 4 JavaConfig - конфигурация через аннотации с указанием класса (или массива классов)
        // аннотацией @Configuration — AnnotationConfigApplicationContext(JavaConfig.class).

        ApplicationContext context = new AnnotationConfigApplicationContext("kg.megacom.springboothometask");

        Student student1 =  context.getBean("student1",Student.class);
        System.out.println("student1 @Bean from @Configuration class: \n" + student1+"\n");

        Student student2 = (Student) context.getBean("student2");
        System.out.println("student2 @Bean from  @Configuration class: \n" + student2
                +"\n" + "____________________________________________________");


        Mentor mentor = context.getBean("mentor",Mentor.class);
        System.out.println("Initialization of student @Bean with @Component and DI in Mentor class: \n"
                + mentor+"\n____________________________________________");

        StudentService studentService = context.getBean("studentServiceImpl", StudentServiceImpl.class);
        System.out.println("Realization of get student method with interface, implementation class and @Service:" +
                "\n  " + studentService.getStudent() + "\n "+"_________________________________________");

        Mentor mentor2 = context.getBean("mentor",Mentor.class);
        Mentor mentor3 = context.getBean("mentor",Mentor.class);

        mentor3.mentorConstructor();

        System.out.println( "Comparing bean Mentor for equality after using scope(prototype): " +
                mentor2.equals(mentor3) +" "+(mentor2 == mentor3));

    }
}
