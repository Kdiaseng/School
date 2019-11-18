package br.com.kdias.School.controller;


import br.com.kdias.School.service.CourseService;
import br.com.kdias.School.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private CourseService courseService;
}
