package com.example.supervisory.api.controller.detector_event;

import com.example.supervisory.api.model.detector.Detector;
import com.example.supervisory.api.model.detector_event.DetectorEvent;
import com.example.supervisory.api.repository.detector_event.DetectorEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-supervisory/detectors-events")
public class DetectorEventController {
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
}
