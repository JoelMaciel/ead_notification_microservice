package com.ead.notification.domain.converter;

import com.ead.notification.domain.dtos.NotificationCommandDTO;
import com.ead.notification.domain.dtos.NotificationDTO;
import com.ead.notification.domain.enums.NotificationStatus;
import com.ead.notification.domain.models.NotificationModel;

import java.time.OffsetDateTime;

public class NotificationConverter {
    private NotificationConverter() {

    }

    public static NotificationDTO toDTO(NotificationModel notificationModel) {
        return NotificationDTO.builder()
                .notificationId(notificationModel.getNotificationId())
                .title(notificationModel.getTitle())
                .message(notificationModel.getMessage())
                .notificationStatus(String.valueOf(notificationModel.getNotificationStatus()))
                .creationDate(notificationModel.getCreationDate())
                .build();
    }

    public static NotificationModel toEntity(NotificationCommandDTO notificationCommandDTO, NotificationStatus status) {
        return NotificationModel.builder()
                .userId(notificationCommandDTO.getUserId())
                .title(notificationCommandDTO.getTitle())
                .message(notificationCommandDTO.getMessage())
                .creationDate(OffsetDateTime.now())
                .notificationStatus(status)
                .build();
    }

}
