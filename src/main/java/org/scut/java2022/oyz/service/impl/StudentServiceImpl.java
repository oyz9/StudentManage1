package org.scut.java2022.oyz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.scut.java2022.oyz.dao.StudentMapper;
import org.scut.java2022.oyz.dto.Result;
import org.scut.java2022.oyz.entity.Student;
import org.scut.java2022.oyz.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service

public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Resource
    private StudentMapper studentDao;


    //增加学生
    public Result addStudent(Student student){
        Result result = new Result();
        //插入前判断是否已存在
        for (Student student1 : studentDao.selectAllStudent()) {
            if (student1.getStudentNumber().equals(student.getStudentNumber())) {
                logger.debug("学号{}的学生信息已存在",student.getStudentNumber());
                result.setMsg("学号("+student.getStudentNumber()+")的学生信息已存在,");
                result.setCode("2004");
                result.setData(student);
                return result;
            }
        }
        studentDao.addStudent(student);
        //判断是否插入成功
        for (Student student1 : studentDao.selectAllStudent()) {
            if (student1.getStudentNumber().equals(student.getStudentNumber())) {
                logger.info("学号{}的学生信息插入成功",student.getStudentNumber());
                result.setCode("1000");
                result.setMsg("学号("+student.getStudentNumber()+")的学生信息插入成功");
                result.setData(student);
            }
        }
        return result;
    }


    //批量增加学生
    public Result batchAdd(List<Student> students) {
        Result result = new Result();
        result.setMsg("");
        result.setData("");
        out:for (Student student : students) {
            List<Student> allStudent = studentDao.selectAllStudent();
            for (Student student1 : allStudent) {
                if (student1.getStudentNumber().equals(student.getStudentNumber())) {
                    logger.debug("学号{}的学生信息已存在",student.getStudentNumber());
                    result.setMsg(result.getMsg()+"学号("+student.getStudentNumber()+")的学生信息已存在,");
                    continue out;
                }
            }
            studentDao.addStudent(student);
            logger.info("学号{}的学生信息插入成功",student.getStudentNumber());
            result.setMsg(result.getMsg()+"学号("+student.getStudentNumber()+")的学生信息插入成功,");
            result.setData(result.getData()+student.toString()+",");
        }
        result.setCode("1000");
        return result;
    }

    //通过学号删除学生
    public Result deleteStudentByNumber(String number) {
        Result result = new Result();
        studentDao.deleteStudentByStudentNumber(number);
        List<Student> students = studentDao.selectAllStudent();
        boolean flag = true;
        for (Student student : students) {
            if (student.getStudentNumber().equals(number)) {
                logger.debug("学号("+student.getStudentNumber()+")的学生信息删除失败");
                result.setCode("3001");
                result.setMsg("学号("+student.getStudentNumber()+")的学生信息删除失败");
                flag =false;
                break;
            }
        }
        if (flag) {
            logger.debug("学号("+number+")的学生信息删除成功");
            result.setCode("1000");
            result.setMsg("学号("+number+")的学生信息删除成功");
        }
        return result;
    }
    //通过姓名删除学生
    public Result deleteStudentByName(String name) {
        studentDao.deleteStudentByStudentName(name);
        Result result = new Result();
        List<Student> students = studentDao.selectAllStudent();
        boolean flag = true;
        for (Student student : students) {
            if (student.getName().equals(name)) {
                logger.debug("姓名("+student.getName()+")的学生信息删除失败");
                result.setCode("3001");
                result.setMsg("姓名("+student.getName()+")的学生信息删除失败");
                flag =false;
                break;
            }
        }
        if (flag) {
            logger.debug("姓名("+name+")的学生信息删除成功");
            result.setCode("1000");
            result.setMsg("姓名("+name+")的学生信息删除成功");
        }
        return result;
    }

    //更新学生
    public Result updateByNumber(Student student) {
        Result result = new Result();
        studentDao.updateStudentByStudentNumber(student);
        List<Student> students = studentDao.selectAllStudent();
        for (Student student1 : students) {
            if (student1.toString().equals(student.toString())) {
                logger.debug("学号("+student.getStudentNumber()+")的学生信息更新成功");
                result.setCode("1000");
                result.setMsg("学号("+student.getStudentNumber()+")的学生信息更新成功");
                return result;
            }
        }
        logger.debug("学号("+student.getStudentNumber()+")的学生信息更新失败");
        result.setCode("3001");
        result.setMsg("学号("+student.getStudentNumber()+")的学生信息更新失败");
        return result;
    }

    //通过学号查询学生信息
    public Result getByNumber(String number) {
        Result result = new Result();
        Student student = studentDao.selectStudentByStudentNumber(number);
        if (student != null) {
            logger.debug("found student: {}", student);
            result.setCode("1000");
            result.setMsg("found student: {"+student+"}");
            result.setData(student);
        } else {
            logger.debug("学号("+number+")的学生信息不存在");
            result.setCode("3001");
            result.setMsg("学号("+number+")的学生信息不存在");
        }
        return result;
    }

    //通过姓名查询学生信息
    public Result getByName(String name) {
        Result result = new Result();
        Student student = studentDao.selectStudentByStudentName(name);
        if (student != null) {
            logger.debug("found student: {}", student);
            result.setCode("1000");
            result.setMsg("found student: {"+student+"}");
            result.setData(student);
        } else {
            logger.debug("姓名("+name+")的学生信息不存在");
            result.setCode("3001");
            result.setMsg("姓名("+name+")的学生信息不存在");
        }

        return result;
    }

    //通过性别查询学生信息
    public Result getByGender(String gender){
        Result result = new Result();
        List<Student> students = studentDao.selectStudentByGender(gender);
        if (!students.isEmpty()) {
            logger.debug("found student: {}", students);
            result.setCode("1000");
            result.setMsg("found student: {"+students+"}");
            result.setData(students);
        } else {
            logger.debug("性别("+gender+")的学生信息不存在");
            result.setCode("3001");
            result.setMsg("性别("+gender+")的学生信息不存在");
        }
        return result;


    }

    //通过班级查询学生信息
    public Result getByClass(String classname){
        Result result = new Result();
        List<Student> students = studentDao.selectStudentByClass(classname);
        if (!students.isEmpty()) {
            logger.debug("found student: {}", students);
            result.setCode("1000");
            result.setMsg("found student: {"+students+"}");
            result.setData(students);
        } else {
            logger.debug("班级("+classname+")的学生信息不存在");
            result.setCode("3001");
            result.setMsg("班级("+classname+")的学生信息不存在");
        }
        return result;
    }

    //通过年级查询学生信息
    public Result getByGrade(String grade){
        Result result = new Result();
        List<Student> students = studentDao.selectStudentByGrade(grade);
        if (!students.isEmpty()) {
            logger.debug("found student: {}", students);
            result.setCode("1000");
            result.setMsg("found student: {"+students+"}");
            result.setData(students);
        } else {
            logger.debug("年级("+grade+")的学生信息不存在");
            result.setCode("3001");
            result.setMsg("年级("+grade+")的学生信息不存在");
        }
        return result;
    }

    //通过手机号查询学生信息
    public Result getByMobileNumber(String mobilenumber){
        Result result = new Result();
        Student student = studentDao.selectStudentByStudentName(mobilenumber);
        if (student != null) {
            logger.debug("found student: {}", student);
            result.setCode("1000");
            result.setMsg("found student: {"+student+"}");
            result.setData(student);
        } else {
            logger.debug("电话("+mobilenumber+")的学生信息不存在");
            result.setCode("3001");
            result.setMsg("电话("+mobilenumber+")的学生信息不存在");
        }
        return result;
    }

    //查询所有学生信息
    public Result getAll() {
        Result result = new Result();
        List<Student> students = studentDao.selectAllStudent();
        if (!students.isEmpty()) {
            logger.debug("found student: {}", students);
            result.setCode("1000");
            result.setMsg("found student: {"+students+"}");
            result.setData(students);
        } else {
            logger.debug("表中不存在学生信息");
            result.setCode("3001");
            result.setMsg("表中不存在学生信息");
        }
        return result;
    }

    //分页查询
    public Result getAllStudentByPage(int pageNum, int pageSize) {


        Result result = new Result();
        PageHelper.startPage(pageNum, pageSize);
        List<Student> students = studentDao.selectAllStudent();
        PageInfo<Student> pageInfo = new PageInfo<Student>(students);
        if (pageInfo.getTotal()>0) {
            logger.debug("found student: {}", pageInfo );
            result.setCode("1000");
            result.setMsg("found student: {"+pageInfo+"}");
            result.setData(pageInfo);
        } else {
            logger.debug("表中不存在学生信息");
            result.setCode("3001");
            result.setMsg("表中不存在学生信息");
        }
        return result;
    }
}
