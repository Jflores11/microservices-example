package com.microservice.course.service;

import com.microservice.course.client.IStudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entities.Course;
import com.microservice.course.http.response.StudentsByCourseResponse;
import com.microservice.course.persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

  @Autowired
  private ICourseRepository courseRepository;

  @Autowired
  private IStudentClient studentClient;

  @Override
  public List<Course> findAll() {
    return courseRepository.findAll();
  }

  @Override
  public Course findById( Long id ) {
    return courseRepository.findById( id ).orElseThrow();
  }

  @Override
  public void save( Course course ) {
    courseRepository.save( course );
  }

  @Override
  public StudentsByCourseResponse findStudentsByCourseId( Long courseId ) {
    Course course = courseRepository.findById( courseId ).orElseThrow();
    List<StudentDTO> studentList = studentClient.findStudentsByCourseId( courseId );
    return buildStudentsByCourseResponse( course, studentList );
  }

  private StudentsByCourseResponse buildStudentsByCourseResponse( Course course,
                                                                  List<StudentDTO> studentList ) {
    return StudentsByCourseResponse.builder()
      .course( course.getName() )
      .teacher( course.getTeacher() )
      .studentList( studentList )
      .build();
  }

}
