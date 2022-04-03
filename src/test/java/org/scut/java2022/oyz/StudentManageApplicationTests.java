package org.scut.java2022.oyz;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.scut.java2022.oyz.dto.Result;
import org.scut.java2022.oyz.entity.User;
import org.scut.java2022.oyz.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentManageApplicationTests {

//    @Autowired
//    StudentService studentService;

    @Autowired
    UserServiceImpl userService;

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
        User user = new User("oyz", "123456",null);
        Result result = userService.login(user);
        System.out.println(result.toString());
    }

}
