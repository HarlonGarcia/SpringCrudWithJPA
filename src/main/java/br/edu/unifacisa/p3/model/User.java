package br.edu.unifacisa.p3.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "user")
@Data
public class User {
    @Id @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String password;
}
