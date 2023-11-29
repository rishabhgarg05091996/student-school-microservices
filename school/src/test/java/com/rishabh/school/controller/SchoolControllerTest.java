package com.rishabh.school.controller;

import com.rishabh.school.dto.FullSchoolResponse;
import com.rishabh.school.entity.School;
import com.rishabh.school.service.SchoolService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class SchoolControllerTest {
	@InjectMocks
	private SchoolController schoolController;
	private AutoCloseable closeable;
	
	@Mock
	private SchoolService schoolService;
	
	@BeforeEach
	public void setUp() {
		closeable = MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	void closeService() throws Exception {
		closeable.close();
	}
	
	@Test
	void testSave() {
		School school = new School();
		schoolController.save(school);
		
		verify(schoolService, times(1)).saveSchool(school);
	}
	
	@Test
	void testFindAllSchools() {
		List<School> schools = Collections.singletonList(new School());
		when(schoolService.findAllSchools()).thenReturn(schools);
		
		ResponseEntity<List<School>> response = schoolController.findAllSchools();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(schools, response.getBody());
	}
	
	@Test
	void testFindAllStudentsBySchoolId() {
		Integer schoolId = 1;
		
		FullSchoolResponse fullSchoolResponse = new FullSchoolResponse();
		when(schoolService.findSchoolsWithStudents(schoolId)).thenReturn(fullSchoolResponse);
		
		ResponseEntity<FullSchoolResponse> response = schoolController.findAllStudentsBySchoolId(schoolId);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(fullSchoolResponse, response.getBody());
	}
}
