package com.ead.notification.domain.exceptions;

import org.springframework.security.access.AccessDeniedException;

public class UserDoesNotHavePermissionException extends AccessDeniedException {

    public UserDoesNotHavePermissionException(String message) {
        super(message);
    }
}
