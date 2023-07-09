package com.anyaudit.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "assignment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Assignment extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assignment_id")
    private Long id;

    @NotBlank
    @Column(name = "assignment_name")
    private String assignmentName;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeofAssignment_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TypeofAssignment typeofAssignment;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "year_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Year year;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userEP_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User engagementPartner;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userRP_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User reviewPartner;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_client",
            joinColumns = @JoinColumn(name = "assignment_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Set<User> users = new HashSet<>();


    @NotBlank
    @Size(max = 20)
    @Column(name = "value")
    private String value;

//    @NotBlank
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @Column(name = "startdate")
    private Date startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    @Column(name = "enddate")
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Client client;
//    @NotBlank

}
