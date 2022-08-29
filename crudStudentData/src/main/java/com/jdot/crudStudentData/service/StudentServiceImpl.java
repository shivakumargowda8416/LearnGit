package com.jdot.crudStudentData.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdot.crudStudentData.entity.Student;
import com.jdot.crudStudentData.error.RecordNotFoundException;
import com.jdot.crudStudentData.repository.StudentRepositary;




	@Service
	public class StudentServiceImpl implements StudentService {
		
		private static final Student updateStudent = null;
		@Autowired
		StudentRepositary studentRepositary;
		
		@Override
		public Student saveStudent(Student st) {
			return studentRepositary.save(st);
		}

		@Override
		public Student getStudentByNo(long no) {
		 Optional<Student> studentDb=studentRepositary.findById(no);
		 
		 if(studentDb.isPresent())
		 {
			 return studentDb.get();
		 }
		 else
		 {
			 throw new RecordNotFoundException("Record not found!!");
		 }
		}

		@Override
		public List<Student> getStudents() {
			return studentRepositary.findAll();
		}

		@Override
		public Student updateStudent(Student st) {
			Optional<Student> studentDb=studentRepositary.findById(st.getRno());
			
			if(studentDb.isPresent())
			{
				Student employeeUpdate=studentDb.get();
				updateStudent.setName(st.getName());
				updateStudent.setMobile(st.getMobile());
				studentRepositary.save(employeeUpdate);
				return employeeUpdate;
			}
			else
			{
				throw new com.jdot.crudStudentData.error.RecordNotFoundException("Record not found!!");
			}
		}

		@Override
		public void deleteStudent(long no) {
		   Optional<Student> studentDb=studentRepositary.findById(no);
		   
		   if(studentDb.isPresent())
		   {
			   studentRepositary.delete(studentDb.get());
		   }
		   else
		   {
			   throw new RecordNotFoundException("Record not found!!");
			   
		   }
		}

		

	
	

}
