package br.com.kdias.School.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Student extends BaseEntity{

    private String name;

    public Student(Long id,String name) {
        this.name = name;
        this.setId(id);
    }
}
