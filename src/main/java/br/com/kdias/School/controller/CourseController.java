package br.com.kdias.School.controller;


import br.com.kdias.School.form.CourseForm;
import br.com.kdias.School.model.Course;
import br.com.kdias.School.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/{id}")
    public List<Course> getCourse(@RequestParam(required = false) String name){
        if(Objects.nonNull(name)){
            return courseService.getCourseByName(name);
        }
        return courseService.getAllCourse();
    }

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody @Valid CourseForm courseForm){
        return new ResponseEntity<>(courseService.save(courseForm), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody CourseForm courseForm){
        return ResponseEntity.ok(courseService.update(id ,courseForm));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        courseService.delete(id);
        return ResponseEntity.ok().build();
    }
}
