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
@Table(name = "client")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client extends BaseModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "client_id")
  private Long id;

  @NotBlank
  @Column(name = "name")
  private String name;

  @NotBlank
  @Size(max = 50)
  @Column(name = "phone_no")
  private String phoneNo;

  @NotBlank
  @Size(max = 50)
  @Column(name = "email")
  private String email;

  @NotBlank
  @Size(max = 50)
  @Column(name = "file_no")
  private String fileNo;

//  @NotBlank
//  @Size(max = 50)
//  @Column(name = "financial_framework")
//  private String financialFramework;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "framework_id", referencedColumnName = "id")
  @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
  private Framework framework;

}
