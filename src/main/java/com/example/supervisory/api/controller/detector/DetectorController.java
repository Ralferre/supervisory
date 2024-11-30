package com.example.supervisory.api.controller.detector;

import com.example.supervisory.api.model.detector.Detector;
import com.example.supervisory.api.repository.detector.DetectorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-supervisory/detectors")
public class DetectorController {
    @Autowired
    private DetectorRepository detectorRepository;

    @GetMapping
    public Page<Detector> getAllDetectors(Pageable pageable) {
        return detectorRepository.findAll(pageable);
    }

    @GetMapping("/tag")
    public Detector getByTag(@RequestParam String tag) {
        return detectorRepository.findByTag(tag);
    }

    @GetMapping("/name")
    public Page<Detector> getByName(@RequestParam String name, Pageable pageable) {
        return detectorRepository.findByName(name, pageable);
    }

    @GetMapping("/serial-number")
    public Page<Detector> getBySerialNumber(@RequestParam String serialNumber, Pageable pageable) {
        return detectorRepository.findBySerialNumber(serialNumber, pageable);
    }

    @GetMapping("/detector-range")
    public Page<Detector> getByDetectorRange(@RequestParam String detectorRange, Pageable pageable) {
        return detectorRepository.findByDetectorRange(detectorRange, pageable);
    }

    @GetMapping("/installed-area")
    public Page<Detector> getByInstalledArea(@RequestParam String installedArea, Pageable pageable) {
        return detectorRepository.findByInstalledArea(installedArea, pageable);
    }

    @GetMapping("/location-area")
    public Page<Detector> getByLocationArea(@RequestParam String locationArea, Pageable pageable) {
        return detectorRepository.findByLocationArea(locationArea, pageable);
    }

    @GetMapping("/date-last-calibration")
    public Page<Detector> getByDateLastCalibration(@RequestParam String dateLastCalibration, Pageable pageable) {
        return detectorRepository.findByDateLastCalibration(dateLastCalibration, pageable);
    }

    @GetMapping("/date-next-calibration")
    public Page<Detector> getByDateNextCalibration(@RequestParam String dateNextCalibration, Pageable pageable) {
        return detectorRepository.findByDateNextCalibration(dateNextCalibration, pageable);
    }

    @PostMapping("/create-detector")
    public ResponseEntity<Detector> createDetector(@Valid @RequestBody Detector detector) {
        Detector savedDetector = detectorRepository.save(detector);

        return new ResponseEntity<>(savedDetector, HttpStatus.CREATED);
    }
}
