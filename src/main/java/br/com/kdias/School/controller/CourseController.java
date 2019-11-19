package br.com.kdias.School.controller;


import br.com.kdias.School.form.CourseForm;
import br.com.kdias.School.model.Course;
import br.com.kdias.School.service.CourseService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(
            value="Busca todos os cursos filtrado por nome")
    @GetMapping(value = "/{id}")
    public List<Course> getCourse(@RequestParam(required = false) String name){
        if(Objects.nonNull(name)){
            return courseService.getCourseByName(name);
        }
        return courseService.getAllCourse();
    }

    @ApiOperation(
            value="Cria um novo curso")
    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody @Valid CourseForm courseForm){
        return new ResponseEntity<>(courseService.save(courseForm), HttpStatus.CREATED);
    }

    @ApiOperation(
            value="Atualiza um curso")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody CourseForm courseForm){
        return ResponseEntity.ok(courseService.update(id ,courseForm));
    }

    @ApiOperation(
            value="Exclui um curso")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        courseService.delete(id);
        return ResponseEntity.ok().build();
    }
}
