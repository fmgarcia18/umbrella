package com.fmgarcia.umbrella.notifications.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailRequest {

    private String email;
    private String content;
    private String subject;
    private String template;
}
