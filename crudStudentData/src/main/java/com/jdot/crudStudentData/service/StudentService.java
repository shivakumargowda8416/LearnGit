package com.jdot.crudStudentData.service;

import java.util.List;


import com.jdot.crudStudentData.entity.Student;

public interface StudentService {
	
	
	public Student saveStudent(Student st);
	public Student getStudentByNo(long rno);
	public List<Student> getStudents();
	public Student updateStudent(Student st);
	public void deleteStudent(long rno);

}
