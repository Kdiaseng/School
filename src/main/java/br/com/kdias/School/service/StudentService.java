package br.com.kdias.School.service;

import br.com.kdias.School.form.StudentForm;
import br.com.kdias.School.model.Course;
import br.com.kdias.School.model.Student;
import br.com.kdias.School.repository.StudentRespository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService extends BaseService {

    @Autowired
    private StudentRespository studentRespository;

    @Autowired
    private CourseService courseService;

    public Page<Student> findAll(Pageable pageable){
        return studentRespository.findAll(pageable);
    }

    public Page<Student> findAllByName(Pageable pageable,String name){
        return studentRespository.findByNameContaining(pageable,name);
    }

    public Student findById(Long id){
        Optional<Student> student = studentRespository.findById(id);
        super.verifyNotFound("Student not found",student);
        return student.get();
    }

    public Student save(StudentForm studentForm){
        Student student = new Student();
        Course course = courseService.findById(studentForm.getCurso());

        student.setName(studentForm.getName());
        student.setCourse(course);

        return studentRespository.save(student);
    }

    public Student update(Long id,StudentForm studentForm){
        Optional<Student> studentOptional = studentRespository.findById(id);

        super.verifyNotFound("Student not found",studentOptional);

        Student student = studentOptional.get();
        student.setName(studentForm.getName());
        return studentRespository.save(student);
    }

    public void delete(Long id){
        Optional<Student> student = studentRespository.findById(id);
        super.verifyNotFound("Student not found",student);
        studentRespository.deleteById(id);
    }

}
