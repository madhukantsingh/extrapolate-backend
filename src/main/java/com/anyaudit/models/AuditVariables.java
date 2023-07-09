package com.anyaudit.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "auditVariables")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuditVariables extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank

    @Column(name = "name")
    private String Name;

    @NotBlank
    @Size(max = 50)
    @Column(name = "type")
    private String type;
}
