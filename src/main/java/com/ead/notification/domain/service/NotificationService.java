package com.ead.notification.domain.service;

import com.ead.notification.domain.dtos.NotificationCommandDTO;
import com.ead.notification.domain.dtos.NotificationDTO;

public interface NotificationService {

    NotificationDTO save(NotificationCommandDTO notificationCommandDTO);
}
