package br.edu.unifacisa.p3.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "student")
@Data
public class Student extends User {
    @Column
    private int rdm;
    @Column
    private String course;
}
