package com.fmgarcia.umbrella.notifications.dtos;

import com.fmgarcia.umbrella.notifications.domain.EmailType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailTemplateNewRequest {

    @NotNull
    private String name;
    private String description;
    @NotNull
    private String subject;
    @NotNull
    private String content;
    @NotNull
    private Boolean enabled;
    @NotNull
    private String type;
}
