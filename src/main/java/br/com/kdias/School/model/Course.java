package br.com.kdias.School.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Course extends BaseEntity {
    private String name;
}
