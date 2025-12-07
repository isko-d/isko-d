package com.isko_d.isko_d.controller;

import com.isko_d.isko_d.model.Action;
import com.isko_d.isko_d.service.ActionService;
import com.isko_d.isko_d.dto.action.ActionResponseDTO;
import com.isko_d.isko_d.dto.action.ActionRequestDTO;
import com.isko_d.isko_d.validation.Create;
import com.isko_d.isko_d.validation.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.validation.annotation.Validated;
import java.util.List;

@RestController
@RequestMapping(path="/actions")
public class ActionController {
    private final ActionService actionService;

    public ActionController(ActionService actionService) {
        this.actionService = actionService;
    }

    @GetMapping
    public ResponseEntity<List<ActionResponseDTO>> findAll() {
        List<ActionResponseDTO> actions = actionService.findAll();

        if (actions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(actions);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<ActionResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(actionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ActionResponseDTO> save(
            @RequestBody @Validated(Create.class) ActionRequestDTO request
    ) {
        ActionResponseDTO savedAction = actionService.save(request);
        return ResponseEntity.status(201).body(savedAction);
    }

    @PatchMapping(path="/{id}")
    public ResponseEntity<ActionResponseDTO> update(
            @PathVariable Long id,
            @RequestBody @Validated(Update.class) ActionRequestDTO request
    ) {
        return ResponseEntity.ok(actionService.update(id, request));
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<ActionResponseDTO> delete(@PathVariable Long id) {
        return ResponseEntity.ok(actionService.delete(id));
    }
}
