package com.microservice.student.controller;

import com.microservice.student.entities.Student;
import com.microservice.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/api/students" )
public class StudentController {

  @Autowired
  private IStudentService studentService;

  @PostMapping
  public ResponseEntity<Student> saveStudent( @RequestBody Student student ) {
    studentService.save( student );
    return new ResponseEntity<>( HttpStatus.CREATED );
  }

  @GetMapping( "/{id}" )
  public ResponseEntity<Student> getStudentById( @PathVariable Long id ) {
    return ResponseEntity.ok( studentService.findById( id ) );
  }

  @GetMapping
  public ResponseEntity<List<Student>> getAllStudents() {
    return ResponseEntity.ok( studentService.findAll() );
  }

  @GetMapping( "/course/{courseId}" )
  public ResponseEntity<List<Student>> getStudentsByCourseId( @PathVariable Long courseId ) {
    return ResponseEntity.ok( studentService.findByCourseId( courseId ) );
  }

}
