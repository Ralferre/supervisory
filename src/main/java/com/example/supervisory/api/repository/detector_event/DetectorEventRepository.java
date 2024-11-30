package com.example.supervisory.api.repository.detector_event;

import com.example.supervisory.api.model.detector_event.DetectorEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface DetectorEventRepository extends JpaRepository<DetectorEvent, Integer> {
    Page<DetectorEvent> findAll(Pageable pageable);
    Page<DetectorEvent> findByMaxRegister(Double maxRegister, Pageable pageable);
    Page<DetectorEvent> findByDateRegister(String dateRegister, Pageable pageable);
    Page<DetectorEvent> findByTag(String tag, Pageable pageable);
    //Page<DetectorEvent> findByMaxRegisterOrDateRegister(Double maxRegister, String dateRegister, Pageable pageable);
}
