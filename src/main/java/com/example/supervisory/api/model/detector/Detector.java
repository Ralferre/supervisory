package com.example.supervisory.api.model.detector;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Detectors")
public class Detector {
    @JsonProperty("Id_Detector")
    private Integer idDetector;
    @JsonProperty("Tag")
    @NotBlank(message = "Tag cannot be blank")
    private String tag;
    @JsonProperty("Name")
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @JsonProperty("Serial_Number")
    @NotBlank(message = "Serial number cannot be blank")
    private String serialNumber;
    @JsonProperty("Detector_Range")
    @NotBlank(message = "Detector range cannot be blank")
    private String detectorRange;
    @JsonProperty("Installed_Area")
    @NotBlank(message = "Installed area cannot be blank")
    private String installedArea;
    @JsonProperty("Location_Area")
    @NotBlank(message = "Location area cannot be blank")
    private String locationArea;
    @JsonProperty("Date_Last_Calibration")
    @NotBlank(message = "Date last calibration cannot be blank")
    private String dateLastCalibration;
    @JsonProperty("Date_Next_Calibration")
    @NotBlank(message = "Date next calibration cannot be blank")
    private String dateNextCalibration;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdDetector() {
        return idDetector;
    }

    public void setDateNextCalibration(String dateNextCalibration) {
        this.dateNextCalibration = dateNextCalibration;
    }

    public void setIdDetector(Integer idDetector) {
        this.idDetector = idDetector;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDetectorRange() {
        return detectorRange;
    }

    public void setDetectorRange(String detectorRange) {
        this.detectorRange = detectorRange;
    }

    public String getInstalledArea() {
        return installedArea;
    }

    public void setInstalledArea(String installedArea) {
        this.installedArea = installedArea;
    }

    public String getLocationArea() {
        return locationArea;
    }

    public void setLocationArea(String locationArea) {
        this.locationArea = locationArea;
    }

    public String getDateLastCalibration() {
        return dateLastCalibration;
    }

    public void setDateLastCalibration(String dateLastCalibration) {
        LocalDate newDate = LocalDate.parse(dateLastCalibration, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        LocalDate now = LocalDate.now();
        if (newDate.isAfter(now) || newDate.equals(now)) {
            this.dateLastCalibration = dateLastCalibration;
            this.dateNextCalibration = newDate.plusYears(1).format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
    } else {
        throw new IllegalArgumentException("Invalid date. It must be equals or higher than current date.");
        }
    }

    public String getDateNextCalibration() {
        return dateNextCalibration;
    }

}
