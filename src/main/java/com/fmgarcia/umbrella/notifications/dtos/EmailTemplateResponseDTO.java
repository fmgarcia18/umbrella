package com.fmgarcia.umbrella.notifications.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailTemplateResponseDTO {

    private String name;
    private String description;
    private String subject;
    private String content;
    private Boolean enabled;
    private String type;
    private String uuid;
}
