package br.com.kdias.School.repository;


import br.com.kdias.School.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    public List<Course> findByNameContaining(String name);
}
