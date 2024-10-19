package com.example.supervisory.api.repository.detector;

import com.example.supervisory.api.model.detector.Detector;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface DetectorRepository extends JpaRepository<Detector, Integer> {
    Page<Detector> findAll(Pageable pageable);
    Page<Detector> findByTag(String tag, Pageable pageable);
    Page<Detector> findByName(String name, Pageable pageable);
    Page<Detector> findBySerialNumber(String serialNumber, Pageable pageable);
    Page<Detector> findByDetectorRange(String detectorRange, Pageable pageable);
    Page<Detector> findByInstalledArea(String installedArea, Pageable pageable);
    Page<Detector> findByLocationArea(String locationArea, Pageable pageable);
    Page<Detector> findByDateLastCalibration(String dateLastCalibration, Pageable pageable);
    Page<Detector> findByDateNextCalibration(String dateNextCalibration, Pageable pageable);
//    Page<Detector>
//    findByTagOrNameOrSerialNumberOrRangeOrInstalledAreaOrLocationAreaOrDateLastCalibrationOrDateNextCalibration(
//            String tag,
//            String name,
//            String serialNumber,
//            String detectorRange,
//            String installedArea,
//            String locationArea,
//            String dateLastCalibration,
//            String dateNextCalibration,
//            Pageable pageable
//    );
}
