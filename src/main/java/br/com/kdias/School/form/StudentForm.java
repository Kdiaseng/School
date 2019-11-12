package br.com.kdias.School.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class StudentForm {

    @NotEmpty //Bean Validation
    private String name;

    @NotNull
    private Long curso;

}
