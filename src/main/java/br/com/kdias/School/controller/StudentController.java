package br.com.kdias.School.controller;

import br.com.kdias.School.form.StudentForm;
import br.com.kdias.School.model.Student;
import br.com.kdias.School.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Page<Student> helloWorld(Pageable pageable, @RequestParam(required = false) String name){
        if(Objects.nonNull(name)){
            return studentService.findAllByName(pageable,name);
        }
        return studentService.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> findByid(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody @Valid StudentForm studentForm){
        return new ResponseEntity<>(studentService.save(studentForm), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentForm studentForm){
       return ResponseEntity.ok(studentService.update(id,studentForm));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

}

