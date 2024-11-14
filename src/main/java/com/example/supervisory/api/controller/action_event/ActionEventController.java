package com.example.supervisory.api.controller.action_event;

import com.example.supervisory.api.model.action_event.ActionUponEvent;
import com.example.supervisory.api.model.detector.Detector;
import com.example.supervisory.api.model.user.User;
import com.example.supervisory.api.repository.action_event.ActionEventRepository;
import com.example.supervisory.api.repository.detector.DetectorRepository;
import com.example.supervisory.api.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-supervisory/action-upon-event")
public class ActionEventController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DetectorRepository detectorRepository;

    @Autowired
    private ActionEventRepository actionEventRepository;

    @GetMapping
    public Page<ActionUponEvent> getAllActionUponEvent(Pageable pageable) {
        return actionEventRepository.findAll(pageable);
    }

    @GetMapping("/actions-user")
    public ResponseEntity<String> getActionByName(@RequestParam String name, Pageable pageable) {
        Page<User> userOptional = userRepository.findByName(name,pageable);
        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User name not found");
        }

        User user = (User) userOptional.get();
        List<ActionUponEvent> actions = (List<ActionUponEvent>) actionEventRepository.findByUser(user.getUserName(),pageable);
        return ResponseEntity.ok(actions.toString());
    }

    @GetMapping("/actions-tag")
    public ResponseEntity<String> getActionByTag(@RequestParam String tag, Pageable pageable) {
        Page<Detector> detectorOptional = detectorRepository.findByTag(tag,pageable);
        if (detectorOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Detector not found");
        }

        Detector detector = (Detector) detectorOptional.get();
        List<ActionUponEvent> actions = (List<ActionUponEvent>) actionEventRepository.findByTag(detector.getTag(),pageable);
        return ResponseEntity.ok(actions.toString());
    }
}
