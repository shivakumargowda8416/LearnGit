package com.jdot.crudStudentData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdot.crudStudentData.entity.Student;
import com.jdot.crudStudentData.service.StudentService;



@RestController
public class StudentControIIer {
	
	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("/student")   //http://localhost:8080/student
	public ResponseEntity<Student> saveStudent(@RequestBody Student st) {
		
		return ResponseEntity.ok().body(studentService.saveStudent(st));	
	}
	
	
	@GetMapping("/student{no}") //http://localhost:8080/student/1
	public ResponseEntity<Student> getStudentByNo(@PathVariable long no) {	
		return ResponseEntity.ok().body(studentService.getStudentByNo(no));
	}


	@GetMapping("/students")   //http://localhost:8080/students
	public ResponseEntity<List<Student>> getStudents() {
		return ResponseEntity.ok().body(studentService.getStudents());
	}
	
	@PutMapping("/student/{no}")  //http://localhost:8080/student/1
	public ResponseEntity<Student> updateStudent(@PathVariable long no,@RequestBody Student st) {
		st.setRno(no);
		return ResponseEntity.ok().body(studentService.updateStudent(st));	
	}
	
	
	@DeleteMapping("/student/{no}") //http://localhost:8080/student/1
	public ResponseEntity<String> deleteStudent(@PathVariable long no) {
		studentService.deleteStudent(no);
		return ResponseEntity.ok().body("Record Deleted");
	}
	
	
	
}
