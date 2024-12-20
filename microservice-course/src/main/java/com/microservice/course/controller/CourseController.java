package com.microservice.course.controller;

import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/courses" )
public class CourseController {

  @Autowired
  private ICourseService courseService;

  @PostMapping
  public ResponseEntity<Course> saveCourse( @RequestBody Course course ) {
    courseService.save( course );
    return new ResponseEntity<>( HttpStatus.CREATED );
  }

  @GetMapping( "/{id}" )
  public ResponseEntity<Course> findById( @PathVariable Long id ) {
    return ResponseEntity.ok( courseService.findById( id ) );
  }

  @GetMapping
  public ResponseEntity<List<Course>> findAll() {
    return ResponseEntity.ok( courseService.findAll() );
  }

  @GetMapping( "/studentsByCourse/{courseId}" )
  public ResponseEntity<StudentsByCourseResponse> findAllStudentsByCourseId( @PathVariable Long courseId ) {
    return ResponseEntity.ok( courseService.findStudentsByCourseId( courseId ) );
  }

}
