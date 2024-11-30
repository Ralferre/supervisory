package com.example.supervisory.api.repository.action_event;

import com.example.supervisory.api.model.action_event.ActionUponEvent;
import com.example.supervisory.api.model.detector_event.DetectorEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public abstract interface ActionEventRepository extends JpaRepository<ActionUponEvent, Integer> {
    Page<ActionUponEvent> findAll(Pageable pageable);
//    Page<ActionUponEvent> findByTag(String tag, Pageable pageable);
    Page<ActionUponEvent> findByUser_UserName(String userName, Pageable pageable);
    Page<ActionUponEvent> findByUser_Name(String name, Pageable pageable);
    @Query("SELECT a FROM ActionUponEvent a WHERE a.detectorEvent.tag LIKE %:tag%")
    Page<ActionUponEvent> findByTag(@Param("tag") String tag, Pageable pageable);

    boolean existsByDetectorEventAndMutedOnNotNull(DetectorEvent detectorEvent);
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
