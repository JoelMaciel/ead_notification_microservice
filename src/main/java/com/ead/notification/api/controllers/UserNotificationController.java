package com.ead.notification.api.controllers;

import com.ead.notification.domain.dtos.NotificationDTO;
import com.ead.notification.domain.dtos.NotificationRequestDTO;
import com.ead.notification.domain.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users/{userId}/notifications")
public class UserNotificationController {

    private final NotificationService notificationService;

    @PreAuthorize("hasAnyRole('STUDENT')")
    @GetMapping
    public Page<NotificationDTO> getAllNotificationsByUser(@PathVariable UUID userId, @PageableDefault(
            page = 0, size = 10, sort = "notificationId", direction = Sort.Direction.ASC) Pageable pageable,
                                                           Authentication authentication) {
        return notificationService.findAllNotificationsByUser(userId, pageable);
    }

    @PreAuthorize("hasAnyRole('STUDENT')")
    @PutMapping("/{notificationId}")
    public NotificationDTO updateNotification(@PathVariable UUID userId, @PathVariable UUID notificationId,
                                              @RequestBody @Valid NotificationRequestDTO notificationRequestDTO) {
        return notificationService.updateStatus(userId, notificationId, notificationRequestDTO);
    }
}
