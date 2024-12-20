package com.microservice.course.http.response;

import com.microservice.course.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentsByCourseResponse {

  private String course;

  private String teacher;

  private List<StudentDTO> studentList;

}
