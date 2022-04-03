package org.scut.java2022.oyz.dao;

import org.apache.ibatis.annotations.*;
import org.scut.java2022.oyz.entity.Student;

import java.util.List;


public interface StudentMapper {
    @Insert("insert into student(student_number,name,gender, grade, class,mobile_no) values(#{studentNumber},#{name},#{gender},#{grade},#{className},#{mobileNumber})")
    @Results({
            @Result(property="studentNumber", column="student_number"),
            @Result(property="name", column="name"),
            @Result(property="gender", column="gender"),
            @Result(property="grade", column="grade"),
            @Result(property="className", column="class"),
            @Result(property="mobileNumber", column="mobile_no")
    })
    void addStudent(Student student);

    //delete student by number
    @Delete("delete from student where student_number = #{studentNumber}")
    void deleteStudentByStudentNumber(String studentNumber);

    //delete student by name
    @Delete("delete from student where name = #{name}")
    void deleteStudentByStudentName(String name);

    //update student by number
    @Update("update student set student_number = #{studentNumber},name = #{name},grade = #{grade},class = #{className},mobile_no = #{mobileNumber} where student_number = #{studentNumber}")
    @Results({
            @Result(property="studentNumber", column="student_number"),
            @Result(property="name", column="name"),
            @Result(property="gender", column="gender"),
            @Result(property="grade", column="grade"),
            @Result(property="className", column="class"),
            @Result(property="mobileNumber", column="mobile_no")
    })
    void updateStudentByStudentNumber(Student student);

    //query student by number
    @Select("select * from student where student_number = #{student_number}")
    @Results({
            @Result(property="studentNumber", column="student_number"),
            @Result(property="name", column="name"),
            @Result(property="gender", column="gender"),
            @Result(property="grade", column="grade"),
            @Result(property="className", column="class"),
            @Result(property="mobileNumber", column="mobile_no")
    })
    Student selectStudentByStudentNumber(String student_number);

    //query student by name
    @Select("select * from student where name = #{name}")
    @Results({
            @Result(property="studentNumber", column="student_number"),
            @Result(property="name", column="name"),
            @Result(property="gender", column="gender"),
            @Result(property="grade", column="grade"),
            @Result(property="className", column="class"),
            @Result(property="mobileNumber", column="mobile_no")
    })
    Student selectStudentByStudentName(String name);

    //query student by gender
    @Select("select * from student where gender = #{gender}")
    @Results({
            @Result(property="studentNumber", column="student_number"),
            @Result(property="name", column="name"),
            @Result(property="gender", column="gender"),
            @Result(property="grade", column="grade"),
            @Result(property="className", column="class"),
            @Result(property="mobileNumber", column="mobile_no")
    })
    List<Student> selectStudentByGender(String gender);

    //query student by class
    @Select("select * from student where class = #{className}")
    @Results({
            @Result(property="studentNumber", column="student_number"),
            @Result(property="name", column="name"),
            @Result(property="gender", column="gender"),
            @Result(property="grade", column="grade"),
            @Result(property="className", column="class"),
            @Result(property="mobileNumber", column="mobile_no")
    })
    List<Student> selectStudentByClass(String className);

    //query student by grade
    @Select("select * from student where grade = #{grade}")
    @Results({
            @Result(property="studentNumber", column="student_number"),
            @Result(property="name", column="name"),
            @Result(property="gender", column="gender"),
            @Result(property="grade", column="grade"),
            @Result(property="className", column="class"),
            @Result(property="mobileNumber", column="mobile_no")
    })
    List<Student> selectStudentByGrade(String grade);

    //query student by mobileNumber
    @Select("select * from student where mobile_no = #{mobile_no}")
    @Results({
            @Result(property="studentNumber", column="student_number"),
            @Result(property="name", column="name"),
            @Result(property="gender", column="gender"),
            @Result(property="grade", column="grade"),
            @Result(property="className", column="class"),
            @Result(property="mobileNumber", column="mobile_no")
    })
    Student selectStudentByMobileNumber(String mobile_no);

    //query all students
    @Select("select * from student")
    @Results({
            @Result(property="studentNumber", column="student_number"),
            @Result(property="name", column="name"),
            @Result(property="gender", column="gender"),
            @Result(property="grade", column="grade"),
            @Result(property="className", column="class"),
            @Result(property="mobileNumber", column="mobile_no")
    })
    public List<Student> selectAllStudent();
}
