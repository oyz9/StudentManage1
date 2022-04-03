package org.scut.java2022.oyz.service;

import com.github.pagehelper.PageInfo;
import org.scut.java2022.oyz.dto.Result;
import org.scut.java2022.oyz.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     * CRUD
     * 对应各种条件的增删改查
     */
    Result addStudent(Student student);
    void batcgAdd(List<Student> students);

    Result deleteStudentByNumber(String number);
    Result deleteStudentByName(String name);

    Result updateByNumber(Student student);

    /**
     *对应各种条件的查询
     */
    Result getByNumber(String number);
    Result getByName(String name);
    Result getByGender(String gender);
    Result getByGrade(String grade);
    Result getByClass(String classname);
    Result getByMobileNumber(String mobilenumber);
    Result getAll() ;



     Result getAllStudentByPage(int pageNum, int pageSize);

}
