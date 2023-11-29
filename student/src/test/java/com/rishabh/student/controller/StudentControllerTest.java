package com.rishabh.student.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rishabh.student.entity.Student;
import com.rishabh.student.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(StudentController.class)
class StudentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private StudentService service;
	
	@Test
	void save() throws Exception {
		// Arrange
		Student student = Student.builder()
				.firstname("Rishabh")
				.lastname("Garg")
				.email("test@test.com")
				.schoolId(1)
				.build();
		
		// Act and Assert
		mockMvc.perform(post("/api/v1/students")
						.content(asJsonString(student))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}
	
	@Test
	void findAllStudents() throws Exception {
		// Arrange
		List<Student> students = Arrays.asList(
				new Student(1, "Rishabh", "Garg", "test@test.com", 1),
				new Student(2, "test", "test", "test1@test.com", 1)
		);
		
		Mockito.when(service.findAllStudents()).thenReturn(students);
		
		// Act and Assert
		mockMvc.perform(get("/api/v1/students")
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(asJsonString(students)));
	}
	
	@Test
	void findAllStudentsBySchool() throws Exception {
		// Arrange
		Integer schoolId = 1;
		List<Student> students = Arrays.asList(
				new Student(1, "Rishabh", "Garg", "test@test.com", schoolId),
				new Student(2, "test", "test", "test1@test.com", schoolId)
		);
		
		Mockito.when(service.findAllStudentsBySchool(schoolId)).thenReturn(students);
		
		// Act and Assert
		mockMvc.perform(get("/api/v1/students/school/{school-id}", schoolId)
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(asJsonString(students)));
	}
	
	private String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
