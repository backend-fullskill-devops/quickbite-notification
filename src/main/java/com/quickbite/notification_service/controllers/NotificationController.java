package com.quickbite.notification_service.controllers;

import com.quickbite.notification_service.models.dtos.ApiResponse;
import com.quickbite.notification_service.models.dtos.NotificationRequest;
import com.quickbite.notification_service.services.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping
    public ResponseEntity<ApiResponse<Void>> sendNotification(@Valid @RequestBody NotificationRequest request) {
        notificationService.sendNotification(request);
        return ResponseEntity.ok(ApiResponse.success("Notification sent successfully", null));
    }
}
