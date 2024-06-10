package com.ead.notification.domain.service.impl;

import com.ead.notification.domain.repositories.NotificationRepository;
import com.ead.notification.domain.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
}
