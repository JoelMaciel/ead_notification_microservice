package com.ead.notification.domain.converter;

import com.ead.notification.domain.dtos.NotificationCommandDTO;
import com.ead.notification.domain.dtos.NotificationDTO;
import com.ead.notification.domain.dtos.NotificationRequestDTO;
import com.ead.notification.domain.enums.NotificationStatus;
import com.ead.notification.domain.models.NotificationModel;
import org.springframework.data.domain.Page;

import java.time.OffsetDateTime;
import java.util.UUID;

public class NotificationConverter {
    private NotificationConverter() {

    }

    public static Page<NotificationDTO> toPageDTO(Page<NotificationModel> notificationModelPage) {
        return notificationModelPage.map(NotificationConverter::toDTO);
    }

    public static NotificationDTO toDTO(NotificationModel notificationModel) {
        return NotificationDTO.builder()
                .notificationId(notificationModel.getNotificationId())
                .userId(notificationModel.getUserId())
                .title(notificationModel.getTitle())
                .message(notificationModel.getMessage())
                .notificationStatus(String.valueOf(notificationModel.getNotificationStatus()))
                .creationDate(notificationModel.getCreationDate())
                .build();
    }

    public static NotificationModel toEntity(NotificationCommandDTO notificationCommandDTO, NotificationStatus status) {
        return NotificationModel.builder()
                .notificationId(UUID.randomUUID())
                .userId(notificationCommandDTO.getUserId())
                .title(notificationCommandDTO.getTitle())
                .message(notificationCommandDTO.getMessage())
                .creationDate(OffsetDateTime.now())
                .notificationStatus(status)
                .build();
    }

    public static NotificationModel toUpdateEntity(NotificationModel notification, NotificationRequestDTO notificationRequestDTO) {
        return notification.toBuilder()
                .notificationStatus(notificationRequestDTO.getNotificationStatus())
                .build();
    }

}
