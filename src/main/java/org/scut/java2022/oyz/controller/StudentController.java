package org.scut.java2022.oyz.controller;

import com.github.pagehelper.PageInfo;
import org.scut.java2022.oyz.dto.Result;
import org.scut.java2022.oyz.entity.Student;
import org.scut.java2022.oyz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Controller
//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
//没加@ResponseBody的话，会返回一个jsp页面，加了的话，返回的就是json数据
@RestController

public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/api/student/addOne")
    public String addOne(@RequestBody Student student){
        studentService.addStudent(student);
        return "success";
    }

    //批量增加学生
    @RequestMapping("/api/student/batchAdd")
    public String batchAll(@RequestBody List<Student> students){
        studentService.batcgAdd(students);
        return "success";
    }


    @RequestMapping("/api/student/deleteByNumber")
    public String deleteByNumber(@RequestParam("studentnumber") String studentnumber){
        studentService.deleteStudentByNumber(studentnumber);
        return "success";
    }

    @RequestMapping("/api/student/deleteByName")
    public String deleteByName(@RequestParam("name") String name){
        studentService.deleteStudentByName(name);
        return "success";
    }

    @RequestMapping("/api/student/update")
    public String update(@RequestBody Student student){
        studentService.updateByNumber(student);
        return "success";
    }
    @RequestMapping("/api/student/queryAll")
    public Result queryAll(){
        return studentService.getAll();
    }

    @RequestMapping("/api/student/queryByNumber")
    public Result queryByNumber(@RequestParam("studentnumber") String studentnumber){
        return studentService.getByNumber(studentnumber);
    }

    @RequestMapping("/api/student/queryByName")
    public Result queryByName(@RequestParam("name") String name){
        return studentService.getByName(name);
    }

    @RequestMapping("/api/student/queryByGender")
    public Result queryByGender(@RequestParam("gender") String gender){
        return studentService.getByGender(gender);
    }

    @RequestMapping("/api/student/queryByClass")
    public Result queryByClass(@RequestParam("classname") String classname){
        return studentService.getByClass(classname);
    }

    @RequestMapping("/api/student/queryByGrade")
    public Result queryByGrade(@RequestParam("grade") String grade){
        return studentService.getByGrade(grade);
    }

    @RequestMapping("/api/student/queryByMobileNumber")
    public Result queryByMobileNumber(@RequestParam("mobilenumber") String mobilenumber){
        return studentService.getByMobileNumber(mobilenumber);
    }


    @GetMapping("/api/student/queryByPage")
    public Result queryByPage(int pageNum, int pageSize){
        return studentService.getAllStudentByPage(pageNum, pageSize);
    }


}
