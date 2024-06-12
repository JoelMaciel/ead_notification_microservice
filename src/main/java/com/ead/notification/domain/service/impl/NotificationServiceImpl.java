package com.ead.notification.domain.service.impl;

import com.ead.notification.domain.converter.NotificationConverter;
import com.ead.notification.domain.dtos.NotificationCommandDTO;
import com.ead.notification.domain.dtos.NotificationDTO;
import com.ead.notification.domain.dtos.NotificationRequestDTO;
import com.ead.notification.domain.enums.NotificationStatus;
import com.ead.notification.domain.exceptions.NotificationNotFoundException;
import com.ead.notification.domain.models.NotificationModel;
import com.ead.notification.domain.repositories.NotificationRepository;
import com.ead.notification.domain.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

    public static final String NO_NOTIFICATION_FOR_THIS_USER = "There is no notification for this user";
    private final NotificationRepository notificationRepository;

    @Override
    public Page<NotificationDTO> findAllNotificationsByUser(UUID userId, Pageable pageable) {
        Page<NotificationModel> notificationStatus =
                notificationRepository.findByUserIdAndNotificationStatus(userId, NotificationStatus.CREATED, pageable);

        return NotificationConverter.toPageDTO(notificationStatus);
    }

    @Transactional
    @Override
    public NotificationDTO save(NotificationCommandDTO notificationCommandDTO) {
        NotificationModel notification = NotificationConverter.toEntity(notificationCommandDTO, NotificationStatus.CREATED);
        log.info("NotificationCommand : {}", notificationCommandDTO);
        return NotificationConverter.toDTO(notificationRepository.save(notification));
    }

    @Transactional
    @Override
    public NotificationDTO updateStatus(UUID userId, UUID notificationId, NotificationRequestDTO notificationRequestDTO) {
        var notificationModel = findByNotificationIdAndUserId(notificationId, userId);
        var updatedNotification = NotificationConverter.toUpdateEntity(notificationModel, notificationRequestDTO);

        log.info("NotificationStatus {} :", notificationRequestDTO.getNotificationStatus());
        return NotificationConverter.toDTO(notificationRepository.save(updatedNotification));
    }

    @Override
    public NotificationModel findByNotificationIdAndUserId(UUID notificationId, UUID userId) {
        return notificationRepository.findByNotificationIdAndUserId(notificationId, userId)
                .orElseThrow(() -> new NotificationNotFoundException(NO_NOTIFICATION_FOR_THIS_USER));
    }

}
