package br.com.kdias.School.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
public class StudentForm {

    @NotEmpty //Bean Validation
    private String name;

}
