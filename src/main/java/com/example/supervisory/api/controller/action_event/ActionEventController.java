package com.example.supervisory.api.controller.action_event;

import com.example.supervisory.api.model.action_event.ActionUponEvent;
import com.example.supervisory.api.model.detector_event.DetectorEvent;
import com.example.supervisory.api.model.user.User;
import com.example.supervisory.api.repository.action_event.ActionEventRepository;
import com.example.supervisory.api.repository.detector.DetectorRepository;
import com.example.supervisory.api.repository.detector_event.DetectorEventRepository;
import com.example.supervisory.api.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api-supervisory/action-upon-event")
public class ActionEventController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DetectorRepository detectorRepository;

    @Autowired
    private DetectorEventRepository detectorEventRepository;

    @Autowired
    private ActionEventRepository actionEventRepository;

    @GetMapping
    public Page<ActionUponEvent> getAllActionUponEvent(Pageable pageable) {
        return actionEventRepository.findAll(pageable);
    }

    @GetMapping("/actions-user")
    public ResponseEntity<List<ActionUponEvent>> getActionByName(
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String name,
            Pageable pageable) {

        if ((userName == null || userName.isBlank()) && (name == null || name.isBlank())) {
            return ResponseEntity.badRequest()
                    .body(null);
        }

        Page<ActionUponEvent> actionUponEventPage;

        if (userName != null && !userName.isBlank()) {
            actionUponEventPage = actionEventRepository.findByUser_UserName(userName, pageable);
        } else {
            actionUponEventPage = actionEventRepository.findByUser_Name(name, pageable);
        }

        if (actionUponEventPage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(actionUponEventPage.getContent());

    }

    @GetMapping("/actions-tag")
    public ResponseEntity<List<ActionUponEvent>> getActionByTag(
            @RequestParam(required = false) String tag,
            Pageable pageable) {

        if (tag == null) {
            return ResponseEntity.badRequest()
                    .body(null);
        }

        Page<ActionUponEvent> actionUponEventPage = null;

        if (tag != null && !tag.isBlank()) {
            actionUponEventPage = actionEventRepository.findByTag(tag,pageable);
        }

        if (actionUponEventPage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(actionUponEventPage.getContent());

    }

    @PostMapping("/action-event")
    public ResponseEntity<String> handlerActionEvent(
            @RequestBody Map<String, String> actionData,
            @RequestParam Integer detectorEventId,
            @RequestParam String tag,
            @RequestParam String userName,
            Pageable pageable) {

        Optional<User> userOptional = userRepository.findByUserName(userName);

        if (userOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User '" + userName + "' not found.");
        }

        User user = userOptional.get();

        Optional<DetectorEvent> detectorEventOptional = detectorEventRepository.findById(Integer.valueOf(detectorEventId));
        if (detectorEventOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("DetectorEvent with ID '" + detectorEventId + "' not found.");
        }
        
        DetectorEvent detectorEvent = detectorEventOptional.get();

        if (!detectorEvent.getTag().equalsIgnoreCase(tag)) {
            return ResponseEntity.badRequest()
                    .body("The provided tag '" + tag + "' does not match the tag of the specified DetectorEvent.");
        }

        ActionUponEvent actionUponEvent = new ActionUponEvent();
        actionUponEvent.setDetectorEvent(detectorEvent);
        actionUponEvent.setUser(user);

        if (actionData.containsKey("Rearmed_On")) {
            if (actionUponEvent.getRearmedOn() != null || actionUponEvent.getRearmedOn() != "") {
                return ResponseEntity.badRequest()
                        .body("This event has already been rearmed and cannot be modified further.");
                
            }
            actionUponEvent.setRearmedOn();
        }

        if (actionData.containsKey("Muted_On")) {
            if (actionUponEvent.getMutedOn() != null || actionUponEvent.getMutedOn() != "") {
                return ResponseEntity.badRequest()
                        .body("This event has already been muted and cannot be modified further.");
            }
            actionUponEvent.setMutedOn();
        }

        if (actionData.containsKey("Recognized_On")) {
            if (actionUponEvent.getMutedOn() == null) {
                return ResponseEntity.badRequest()
                        .body("Recognized_On action is only allowed for detectors with a previous Muted_On action.");
            }
            actionUponEvent.setRecognizedOn();
        }

        if ((actionUponEvent.getRearmedOn() == null || actionUponEvent.getRearmedOn() == "") &&
                (actionUponEvent.getMutedOn() == null || actionUponEvent.getMutedOn() == "") &&
                (actionUponEvent.getRecognizedOn() == null || actionUponEvent.getRecognizedOn() == "")) {
            return ResponseEntity.badRequest()
                    .body("At least one action (Rearmed_On, Muted_On, Recognized_On) must be provided.");
        }

        ActionUponEvent savedAction = actionEventRepository.save(actionUponEvent);

        return ResponseEntity.status(HttpStatus.CREATED).body(String.valueOf(savedAction));
    }

}
