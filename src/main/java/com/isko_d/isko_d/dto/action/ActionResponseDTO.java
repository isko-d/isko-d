package com.isko_d.isko_d.dto.action;

import com.isko_d.isko_d.model.Action;
import java.time.LocalDateTime;

public class ActionResponseDTO {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ActionResponseDTO(Action action) {
        this.id = action.getId();
        this.name = action.getName();
        this.createdAt = action.getCreatedAt();
        this.updatedAt = action.getUpdatedAt();
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}