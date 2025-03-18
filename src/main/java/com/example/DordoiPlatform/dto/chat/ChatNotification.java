package com.example.DordoiPlatform.dto.chat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatNotification {
    private Long id;
    private String senderId;
    private String recipientId;
    private String content;
}
