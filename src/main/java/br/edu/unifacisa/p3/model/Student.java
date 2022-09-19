package br.edu.unifacisa.p3.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "students")
@Getter @Setter @NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue
    private int rdm;
    @Column
    private String name;
    @Column
    private String course;
}
