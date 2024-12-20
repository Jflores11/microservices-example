package com.microservice.course.client;

import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient( name = "msvc-student", url = "http://localhost:9090/api/students" )
public interface IStudentClient {

  @GetMapping( "/course/{courseId}" )
  List<StudentDTO> findStudentsByCourseId(@PathVariable Long courseId );

}
