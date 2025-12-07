package com.isko_d.isko_d.dto.action;

import com.isko_d.isko_d.validation.Create;
import com.isko_d.isko_d.validation.Update;
import jakarta.validation.constraints.NotBlank;

public class ActionRequestDTO {

    @NotBlank(groups=Create.class)
    private String name;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}