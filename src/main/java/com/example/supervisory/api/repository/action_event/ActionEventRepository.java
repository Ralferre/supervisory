package com.example.supervisory.api.repository.action_event;

import com.example.supervisory.api.model.action_event.ActionUponEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface ActionEventRepository extends JpaRepository<ActionUponEvent, Integer> {
    Page<ActionUponEvent> findAll(Pageable pageable);
    Page<ActionUponEvent> findByRearmedOnOrMutedOnOrRecognizedOn(
            String rearmedOn,
            String mutedOn,
            String recognizedOn,
            Pageable pageable
    );
}
