package br.com.kdias.School.controller;


import br.com.kdias.School.model.Course;
import br.com.kdias.School.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getCourse(@RequestParam(required = false) String name){
        if(Objects.nonNull(name)){
            return courseService.getCourseByName(name);
        }
        return courseService.getAllCourse();
    }
}
