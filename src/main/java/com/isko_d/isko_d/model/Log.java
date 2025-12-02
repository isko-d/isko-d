package com.isko_d.isko_d.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Log {
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    // TODO: Add foreign key to user when available

    @NotBlank
    private String actionType;

    // TODO: Add a locations table for scalability
    private String location;

    @NotBlank
    private String deviceId;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    public Integer getId() { return id; }
    // TODO: Add user_id getter once established
    public String getActionType() { return actionType; }
    public String getLocation() { return location; }
    public String getDeviceId() { return deviceId; }

    public void setId(Integer id) { this.id = id; }
    // TODO: Add user_id setter once established
    public void setActionType(String actionType) { this.actionType = actionType; }
    public void setLocation(String location) { this.location = location; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
}
