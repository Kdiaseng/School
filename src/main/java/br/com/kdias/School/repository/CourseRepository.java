package br.com.kdias.School.repository;


import br.com.kdias.School.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
