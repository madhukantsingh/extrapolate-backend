package com.anyaudit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "templateforControls")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TemplateforControls extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "shortAnswer")
    private String shortAnswer;

    @NotBlank
    @Size(max = 50)
    @Column(name = "frequency")
    private String frequency ;

    @NotBlank
    @Size(max = 50)
    @Column(name = "automation")
    private String automation;
}
