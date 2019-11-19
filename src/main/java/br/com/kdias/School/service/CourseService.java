package br.com.kdias.School.service;

import br.com.kdias.School.form.CourseForm;
import br.com.kdias.School.model.Course;
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

    public Course save(CourseForm courseForm){
        Course course = new Course();
        course.setName(courseForm.getName());
        return courseRepository.save(course);
    }

    public Course update(Long id,CourseForm courseForm){
        Optional<Course> courseOptional = courseRepository.findById(id);

        super.verifyNotFound("Course not found",courseOptional);
        Course course = courseOptional.get();
        course.setName(courseForm.getName());
        return courseRepository.save(course);
    }

    public void delete(Long id){
        Optional<Course> courseOptional = courseRepository.findById(id);
        super.verifyNotFound("Course not found",courseOptional);
        courseRepository.deleteById(id);
    }
    public List<Course> getAllCourse(){
        return courseRepository.findAll();
    }

    public List<Course> getCourseByName(String name){
        return courseRepository.findByNameContaining(name);
    }

}
