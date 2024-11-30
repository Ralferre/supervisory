package com.example.supervisory.api.controller.detector_event;

import com.example.supervisory.api.model.detector.Detector;
import com.example.supervisory.api.model.detector_event.DetectorEvent;
import com.example.supervisory.api.model.detector_event.NullDetectorEvent;
import com.example.supervisory.api.repository.detector.DetectorRepository;
import com.example.supervisory.api.repository.detector_event.DetectorEventRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-supervisory/detectors-events")
public class DetectorEventController {
  @Autowired
  private DetectorRepository detectorRepository;
  @Autowired
    private DetectorEventRepository detectorEventRepository;

  @GetMapping
    public Page<DetectorEvent> getAllDetectorsEvents(Pageable pageable) {
      return detectorEventRepository.findAll(pageable);
  }

  @GetMapping("/max-register")
  public Page<DetectorEvent> getByMaxRegister(@RequestParam Double maxRegister, Pageable pageable) {
    return detectorEventRepository.findByMaxRegister(maxRegister, pageable);
  }

  @GetMapping("/date-register")
  public Page<DetectorEvent> getByDateRegister(@RequestParam String dateRegister, Pageable pageable) {
    return detectorEventRepository.findByDateRegister(dateRegister, pageable);
  }

  @GetMapping("/tag")
  public Page<DetectorEvent> getByTag(@RequestParam String tag, Pageable pageable) {
    return detectorEventRepository.findByTag(tag, pageable);
  }

  @PostMapping("/create-detector-event")
  public ResponseEntity<DetectorEvent> createDetectorEvent(@Valid @RequestBody DetectorEvent detectorEvent) {
    Detector detector = detectorRepository.findByTag(detectorEvent.getTag());

    if (detector == null) {
      return new ResponseEntity<>(new NullDetectorEvent(), HttpStatus.NO_CONTENT);
    }

    detectorEvent.setDetector(detector);
    detectorEvent.setDateRegister();
    DetectorEvent savedDetectorEvent = detectorEventRepository.save(detectorEvent);

    return new ResponseEntity<>(savedDetectorEvent, HttpStatus.CREATED);
  }

}
