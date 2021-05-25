package kg.megacom.springboothometask.service.impl;

import kg.megacom.springboothometask.Student;
import kg.megacom.springboothometask.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public Student getStudent() {

        return new Student("Жылдызбек", 7.7);

    }

}
