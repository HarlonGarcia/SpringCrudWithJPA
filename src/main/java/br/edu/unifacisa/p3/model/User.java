package br.edu.unifacisa.p3.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String password;
}
