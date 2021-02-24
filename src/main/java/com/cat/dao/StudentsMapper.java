package com.cat.dao;

import com.cat.pojo.Students;
import java.util.List;
import java.util.Map;

public interface StudentsMapper {
    //所有学生
    List<Students> listAllStudents();

    //删除一名学生信息
    int deleteStudent(int id);

    //新增一名学生
    int addStudent(Students students);

    //修改一名学生信息
    int updateStudentById(Students students);


}
