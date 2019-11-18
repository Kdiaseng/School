package br.com.kdias.School.service;

import br.com.kdias.School.form.StudentForm;
import br.com.kdias.School.model.Course;
import br.com.kdias.School.model.Student;
import br.com.kdias.School.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService extends BaseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course findById(Long id){
        Optional<Course> course = courseRepository.findById(id);
        super.verifyNotFound("Course not found",course);
        return course.get();
    }

    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

}
