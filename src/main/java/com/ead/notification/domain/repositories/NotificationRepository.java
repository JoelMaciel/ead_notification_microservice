package com.ead.notification.domain.repositories;

import com.ead.notification.domain.enums.NotificationStatus;
import com.ead.notification.domain.models.NotificationModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationModel, UUID> {

    Page<NotificationModel> findByUserIdAndNotificationStatus(
            UUID userId, NotificationStatus notificationStatus, Pageable pageable
    );

    Optional<NotificationModel> findByNotificationIdAndUserId(UUID notificationId, UUID userId);
}
