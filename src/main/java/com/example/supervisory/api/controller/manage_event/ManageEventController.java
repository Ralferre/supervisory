package com.example.supervisory.api.controller.manage_event;

import com.example.supervisory.api.model.manage_event.ManageDetectorEvent;
import com.example.supervisory.api.repository.manage_event.ManageEventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-supervisory/manage-events")
public class ManageEventController {
    @Autowired
    private ManageEventRepository manageEventRepository;

    @GetMapping
    public Page<ManageDetectorEvent> getAllManageEvent(Pageable pageable) {
        return manageEventRepository.findAll(pageable);
    }

    @GetMapping("/date-action")
    public Page<ManageDetectorEvent> getByDate(String dateAction, Pageable pageable) {
        return manageEventRepository.findByDateAction(dateAction, pageable);
    }

    @GetMapping("/type-action")
    public Page<ManageDetectorEvent> getByTypeActionManage(String typeActionManage, Pageable pageable) {
        return manageEventRepository.findByTypeActionManage(typeActionManage, pageable);
    }

}
