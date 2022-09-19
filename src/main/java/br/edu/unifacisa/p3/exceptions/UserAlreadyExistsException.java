package br.edu.unifacisa.p3.exceptions;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException() {
        super("The user already exists");
    }
}
