package kg.megacom.springboothometask;

import kg.megacom.springboothometask.service.StudentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
// Prototype отлично подходит для тестирования, отсюда и название prototype, а не create new или что-то еще,
// описание создания нового экземпляра bean-компонента каждый раз, когда вы запрашиваете его из контейнера Spring.
// Prototype используется для всех bean-компонентов с сохранением состояния

public class Mentor {
    private String name;
    private Student student;

    //  @Autowired
    // Тоже внедряет DI через поле и сработает, но более правильный и безопасный способ
    // внедрение через конструктор, поэтому практиковать такой способ внедрения буду избегать ))

    private StudentService studentService;
    // Также через @Qualifier выбираем 1 из 2 Impl методов в пакете Service
    // для нашей модели Mentor
    public Mentor( Student student, @Qualifier("studentServiceImpl2") StudentService studentService) {
        this.student = student;
        this.studentService = studentService;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Mentor{"+ student +"";
    }

    public void mentorConstructor(){

        Student student = studentService.getStudent();
        System.out.println("Constructor Mentor with StudentService DI : \n" + student+"\n");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
