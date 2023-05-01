package com.security.jwt.exceptions;

public class UserRoleNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public UserRoleNotFoundException(String message) {
        super(message);
    }
}
