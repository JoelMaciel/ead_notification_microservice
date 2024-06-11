package com.ead.notification.domain.models;

import com.ead.notification.domain.enums.NotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "NOTIFICATIONS")
public class NotificationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID notificationId;
    private UUID userId;
    private String title;
    private String message;
    private OffsetDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private NotificationStatus notificationStatus;
}
