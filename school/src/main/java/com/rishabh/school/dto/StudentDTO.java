package com.rishabh.school.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
	private Integer id;
	private String firstname;
	private String lastname;
	private String email;
	private Integer schoolId;
}
