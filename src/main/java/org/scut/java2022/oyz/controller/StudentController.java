package org.scut.java2022.oyz.controller;

import com.github.pagehelper.PageInfo;
import org.scut.java2022.oyz.dto.Result;
import org.scut.java2022.oyz.entity.Student;
import org.scut.java2022.oyz.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@Controller
//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用
//没加@ResponseBody的话，会返回一个jsp页面，加了的话，返回的就是json数据
@RestController
@RequestMapping("/api/student")
public class StudentController {


    @Autowired
    private StudentService studentService;

    @RequestMapping("/addOne")
    public String addOne(@RequestBody Student student){
        studentService.addStudent(student);
        return "success";
    }

    //批量增加学生
    @RequestMapping("/batchAdd")
    public String batchAll(@RequestBody List<Student> students){
        studentService.batcgAdd(students);
        return "success";
    }


    @RequestMapping("/deleteByNumber")
    public String deleteByNumber(@RequestParam("studentnumber") String studentnumber){
        studentService.deleteStudentByNumber(studentnumber);
        return "success";
    }

    @RequestMapping("/deleteByName")
    public String deleteByName(@RequestParam("name") String name){
        studentService.deleteStudentByName(name);
        return "success";
    }

    @RequestMapping("/update")
    public String update(@RequestBody Student student){
        studentService.updateByNumber(student);
        return "success";
    }
    @RequestMapping("/queryAll")
    public Result queryAll(){
        return studentService.getAll();
    }

    @RequestMapping("/queryByNumber")
    public Result queryByNumber(@RequestParam("studentnumber") String studentnumber){
        return studentService.getByNumber(studentnumber);
    }

    @RequestMapping("/queryByName")
    public Result queryByName(@RequestParam("name") String name){
        return studentService.getByName(name);
    }

    @RequestMapping("/queryByGender")
    public Result queryByGender(@RequestParam("gender") String gender){
        return studentService.getByGender(gender);
    }

    @RequestMapping("/queryByClass")
    public Result queryByClass(@RequestParam("classname") String classname){
        return studentService.getByClass(classname);
    }

    @RequestMapping("/queryByGrade")
    public Result queryByGrade(@RequestParam("grade") String grade){
        return studentService.getByGrade(grade);
    }

    @RequestMapping("/queryByMobileNumber")
    public Result queryByMobileNumber(@RequestParam("mobilenumber") String mobilenumber){
        return studentService.getByMobileNumber(mobilenumber);
    }


    @GetMapping("/queryByPage")
    public Result queryByPage(int pageNum, int pageSize){
        return studentService.getAllStudentByPage(pageNum, pageSize);
    }


}
