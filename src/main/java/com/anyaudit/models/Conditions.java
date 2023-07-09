package com.anyaudit.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Conditions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Conditions extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(max = 50)
    @Column(name = "name")
    private String Name;

    @NotBlank
    @Size(max = 50)
    @Column(name = "type")
    private String types;

    @NotBlank
    @Size(max = 50)
    @Column(name = "imapct")
    private String imapct;


    @NotBlank
    @Size(max = 50)
    @Column(name = "operater")
    private String operater;

    @NotBlank
    @Size(max = 50)
    @Column(name = "value1")
    private String value1;

    @NotBlank
    @Size(max = 50)
    @Column(name = "value2")
    private String value2;

}
