package com.quickbite.notification_service.services;

import com.quickbite.notification_service.models.dtos.NotificationRequest;
import com.quickbite.notification_service.models.entities.DeliveryStatus;
import com.quickbite.notification_service.models.entities.Notification;
import com.quickbite.notification_service.repositories.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final NotificationRepository notificationRepository;

    @Transactional
    public void sendNotification(NotificationRequest request) {
        Notification notification = Notification.builder()
                .userId(request.getUserId())
                .title(request.getTitle())
                .content(request.getContent())
                .type(request.getType())
                .deliveryStatus(DeliveryStatus.SENT) // Simulated sent
                .createdAt(LocalDateTime.now())
                .build();

        notificationRepository.save(notification);
        log.info("Notification sent successfully to user {}: Title='{}', Content='{}', Type={}",
                request.getUserId(), request.getTitle(), request.getContent(), request.getType());
    }
}
