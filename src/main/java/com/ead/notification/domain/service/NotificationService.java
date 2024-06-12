package com.ead.notification.domain.service;

import com.ead.notification.domain.dtos.NotificationCommandDTO;
import com.ead.notification.domain.dtos.NotificationDTO;
import com.ead.notification.domain.dtos.NotificationRequestDTO;
import com.ead.notification.domain.models.NotificationModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface NotificationService {

    NotificationDTO save(NotificationCommandDTO notificationCommandDTO);

    Page<NotificationDTO> findAllNotificationsByUser(UUID userId, Pageable pageable);

    NotificationDTO updateStatus(UUID userId, UUID notificationId, NotificationRequestDTO notificationRequestDTO);

    NotificationModel findByNotificationIdAndUserId(UUID notificationId, UUID userId);
}
