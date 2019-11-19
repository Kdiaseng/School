package br.com.kdias.School.controller;

import br.com.kdias.School.form.StudentForm;
import br.com.kdias.School.model.Student;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.kdias.School.service.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
   private StudentService studentService;

    @ApiOperation(
            value="Busca todos os estudantes paginadado")
    @GetMapping
    public Page<Student> getStudentPaged(Pageable pageable, @RequestParam(required = false) String name){
        if(Objects.nonNull(name)){
            return studentService.findAllByName(pageable,name);
        }
        return studentService.findAll(pageable);
    }

    @ApiOperation(
            value="Busca estudante por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.findById(id));
    }

    @ApiOperation(
            value="Cadastrar um novo estudante")

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody @Valid StudentForm studentForm){
        return new ResponseEntity<>(studentService.save(studentForm), HttpStatus.CREATED);
    }

    @ApiOperation(
            value="Atualiza estudante")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody StudentForm studentForm){
       return ResponseEntity.ok(studentService.update(id,studentForm));
    }

    @ApiOperation(
            value="Exclui estudante")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

}

