package org.scut.java2022.oyz;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.scut.java2022.oyz.entity.Student;
import org.scut.java2022.oyz.service.StudentService;
import org.scut.java2022.oyz.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentManageApplicationTests {

    @Autowired
    StudentService studentService;

    @Test
    void contextLoads() {
//        Student s = studentService.getByNumber("20220003");
//        System.out.println(s.getStudentNumber());
//        System.out.println(s.getClassName());
//        System.out.println(s.getMobileNumber());
//        System.out.println(s.toString());
//        List <Student> students = studentService.getAll();
//        for (Student student : students) {
//            System.out.println(student.toString());
//        }

    }

}
