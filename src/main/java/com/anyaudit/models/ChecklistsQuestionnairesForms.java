package com.anyaudit.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "checklistsQuestionnairesForms")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ChecklistsQuestionnairesForms extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(max = 50)
    @Column(name = "chapter")
    private String chapter;

    @NotBlank
    @Size(max = 50)
    @Column(name = "scope")
    private String scope;

    @NotBlank
    @Size(max = 50)
    @Column(name = "type")
    private String type;


}

