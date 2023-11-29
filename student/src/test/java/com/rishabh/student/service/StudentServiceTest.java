package com.rishabh.student.service;

import com.rishabh.student.entity.Student;
import com.rishabh.student.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class StudentServiceTest {
	
	@Mock
	private StudentRepository repository;
	
	@InjectMocks
	private StudentService service;
	
	@Test
	void saveStudent() {
		// Arrange
		Student student = Student.builder()
				.firstname("Rishabh")
				.lastname("Garg")
				.email("test@test.com")
				.schoolId(1)
				.build();
		
		// Act
		service.saveStudent(student);
		
		// Assert
		Mockito.verify(repository, Mockito.times(1)).save(any(Student.class));
	}
	
	@Test
	void findAllStudents() {
		// Arrange
		List<Student> students = Arrays.asList(
				new Student(1, "Rishabh", "Garg", "test@test.com", 1),
				new Student(2, "test", "test", "test1@test.com", 1)
		);
		
		Mockito.when(repository.findAll()).thenReturn(students);
		
		// Act
		List<Student> result = service.findAllStudents();
		
		// Assert
		assertEquals(students, result);
	}
	
	@Test
	void findAllStudentsBySchool() {
		// Arrange
		Integer schoolId = 1;
		List<Student> students = Arrays.asList(
				new Student(1, "Rishabh", "Garg", "test@test.com", schoolId),
				new Student(2, "test", "test", "test1@test.com", schoolId)
		);
		
		Mockito.when(repository.findAllBySchoolId(schoolId)).thenReturn(students);
		
		// Act
		List<Student> result = service.findAllStudentsBySchool(schoolId);
		
		// Assert
		assertEquals(students, result);
	}
}
