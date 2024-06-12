package com.ead.notification.domain.dtos;

import com.ead.notification.domain.enums.NotificationStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class NotificationRequestDTO {

    @NotNull
    private NotificationStatus notificationStatus;
}
