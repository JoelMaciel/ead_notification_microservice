package com.ead.notification.api.controllers;

import com.ead.notification.domain.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class NotificationController {

    private final NotificationService notificationService;
}
