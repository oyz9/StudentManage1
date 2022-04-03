package org.scut.java2022.oyz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentNumber;
    private String name;
    private String gender;
    private String grade;
    private String className;
    private String mobileNumber;
}
