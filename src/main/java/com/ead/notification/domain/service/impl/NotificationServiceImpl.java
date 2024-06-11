package com.ead.notification.domain.service.impl;

import com.ead.notification.domain.converter.NotificationConverter;
import com.ead.notification.domain.dtos.NotificationCommandDTO;
import com.ead.notification.domain.dtos.NotificationDTO;
import com.ead.notification.domain.enums.NotificationStatus;
import com.ead.notification.domain.models.NotificationModel;
import com.ead.notification.domain.repositories.NotificationRepository;
import com.ead.notification.domain.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@RequiredArgsConstructor
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Transactional
    @Override
    public NotificationDTO save(NotificationCommandDTO notificationCommandDTO) {
        NotificationModel notification = NotificationConverter.toEntity(notificationCommandDTO, NotificationStatus.CREATED);
        log.info("NotificationCommand : {}", notificationCommandDTO);
        return NotificationConverter.toDTO(notificationRepository.save(notification));
    }
}
