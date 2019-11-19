package br.com.kdias.School.form;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class CourseForm {
    @NotEmpty //Bean Validation
    private String name;

}
