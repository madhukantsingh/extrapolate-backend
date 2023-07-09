package com.anyaudit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "templateforRisks")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class TemplateforRisks  extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(max = 50)
    @Column(name = "discription")
    private String discription;

    @NotBlank
    @Size(max = 50)
    @Column(name = "type")
    private String type;
}
