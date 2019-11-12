package br.com.kdias.School.repository;

import br.com.kdias.School.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRespository extends JpaRepository<Student, Long> {
    Page<Student> findByNameContaining(Pageable pageable,String name);
}
