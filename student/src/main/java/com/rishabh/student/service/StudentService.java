package com.rishabh.student.service;

import com.rishabh.student.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.rishabh.student.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
	private final StudentRepository repository;
	
	public void saveStudent(Student student) {
		repository.save(student);
	}
	
	public List<Student> findAllStudents() {
		return repository.findAll();
	}
	
	public List<Student> findAllStudentsBySchool(Integer schoolId) {
		return repository.findAllBySchoolId(schoolId);
	}
}
