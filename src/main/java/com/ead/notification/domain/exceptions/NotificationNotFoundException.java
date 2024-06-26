package com.ead.notification.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotificationNotFoundException extends EntityNotFoundException{

    public NotificationNotFoundException(String message) {
        super(message);
    }
}
