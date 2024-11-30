package com.example.supervisory.api.model.detector_event;

import com.example.supervisory.api.model.detector.Detector;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Detector_Event")
public class DetectorEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id_Event")
    private Integer idEvent;
    @JsonProperty("Tag")
    @NotBlank(message = "Tag detector cannot be blank")
    private String tag;
    @JsonProperty("Max_Register")
    @NotNull(message = "Maximum value registered cannot be blank")
    private Double maxRegister;
    @JsonProperty("Date_Register")
    private String dateRegister;

    @ManyToOne
    @JoinColumn(name = "Id_Detector", nullable = false)
    @JsonProperty("Id_Detector")
    private Detector detector;

    public Detector getDetector() {
        return detector;
    }

    public void setDetector(Detector detector) {
        this.detector = detector;
    }

    public String getTag() {
        return tag;
    }

    public Double getMaxRegister() {
        return maxRegister;
    }

    public void setMaxRegister(Double maxRegister) {
        this.maxRegister = maxRegister;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        this.dateRegister = now.format(formatter);
    }
}
