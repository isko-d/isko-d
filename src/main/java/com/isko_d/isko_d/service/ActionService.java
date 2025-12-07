package com.isko_d.isko_d.service;

import com.isko_d.isko_d.model.Action;
import com.isko_d.isko_d.dto.action.ActionRequestDTO;
import com.isko_d.isko_d.dto.action.ActionResponseDTO;
import com.isko_d.isko_d.repository.ActionRepository;
import com.isko_d.isko_d.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ActionService {
    private final ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    public List<ActionResponseDTO> findAll() {
        return actionRepository.findAll()
                .stream()
                .map((action) -> new ActionResponseDTO(action))
                .toList();
    }

    public ActionResponseDTO findById(Long id) {
        return actionRepository.findById(id)
                .map((action) -> new ActionResponseDTO(action))
                .orElseThrow(() -> new NotFoundException(Action.class, id));
    }

    public ActionResponseDTO save(ActionRequestDTO request) {
        Action saved = actionRepository.save(new Action(
                request.getName()
        ));

        return new ActionResponseDTO(saved);
    }

    public ActionResponseDTO update(Long id, ActionRequestDTO request) {
        Action existing = actionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Action.class, id));

        if (request.getName() != null && !request.getName().isBlank()) existing.setName(request.getName());
        Action saved = actionRepository.save(existing);

        return new ActionResponseDTO(saved);
    }

    public ActionResponseDTO delete(Long id) {
        Action deleted = actionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Action.class, id));

        actionRepository.deleteById(id);

        return new ActionResponseDTO(deleted);
    }
}