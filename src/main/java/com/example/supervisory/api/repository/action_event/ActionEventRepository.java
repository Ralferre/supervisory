package com.example.supervisory.api.repository.action_event;

import com.example.supervisory.api.model.action_event.ActionUponEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public abstract interface ActionEventRepository extends JpaRepository<ActionUponEvent, Integer> {
    Page<ActionUponEvent> findAll(Pageable pageable);
//    Page<ActionUponEvent> findByTag(String tag, Pageable pageable);
    Page<ActionUponEvent> findByUser(String user, Pageable pageable);
    @Query("SELECT a FROM ActionUponEvent a WHERE a.detectorEvent.tag LIKE %:tag%")
    Page<ActionUponEvent> findByTag(@Param("tag") String tag, Pageable pageable);
//    Page<ActionUponEvent> findByRearmedOn(String rearmed, Pageable pageable);
//    Page<ActionUponEvent> findByMutedOn(String muted, Pageable pageable);
//    Page<ActionUponEvent> findByRecognizedOn(String recognized, Pageable pageable);
//    Page<ActionUponEvent> findByRearmedOnOrMutedOnOrRecognizedOn(
//            String rearmedOn,
//            String mutedOn,
//            String recognizedOn,
//            Pageable pageable
//    );
}
