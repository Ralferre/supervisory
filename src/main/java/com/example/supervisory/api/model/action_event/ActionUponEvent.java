package com.example.supervisory.api.model.action_event;

import com.example.supervisory.api.model.detector_event.DetectorEvent;
import com.example.supervisory.api.model.user.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Action_Upon_Event")
public class ActionUponEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id_Action_Event")
    private Integer idActionEvent;
    @ManyToOne
    @JoinColumn(name = "Id_Detector_Event", nullable = false)
//    @JsonProperty("Id_Detector_Event")
    private DetectorEvent detectorEvent;
    @ManyToOne
    @JoinColumn(name = "Id_User", nullable = false)
//    @JsonProperty("Id_User")
    private User user;
    @JsonProperty("Rearmed_On")
    //REARMED means that the operator treated the leak and reamed it, changing the visual color in the screen
    private String rearmedOn;
    @JsonProperty("Muted_On")
    //MUTED means that the leak does not treat, so the operator muted the alarm, but there is a sign in the supervisory indicating detector active only by color
    private String mutedOn;
    @JsonProperty("Recognized_On")
    //RECOGNIZED means that the operator has done treat the leak and recognized the alarm, to change the color of the detector which was muted
    private String recognizedOn;

    public DetectorEvent getDetectorEvent() {
        return detectorEvent;
    }

    public void setDetectorEvent(DetectorEvent detectorEvent) {
        this.detectorEvent = detectorEvent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getIdActionEvent() {
        return idActionEvent;
    }

//    public void setIdActionEvent(Integer idActionEvent) {
//        this.idActionEvent = idActionEvent;
//    }

    public String getRearmedOn() {
        return rearmedOn;
    }

    public void setRearmedOn() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        this.rearmedOn = now.format(formatter);
    }

    public String getMutedOn() {
        return mutedOn;
    }

    public void setMutedOn() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        this.mutedOn = now.format(formatter);
    }

    public String getRecognizedOn() {
        return recognizedOn;
    }

    public void setRecognizedOn() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        this.recognizedOn = now.format(formatter);
    }

//    public void setRearmedOn(String rearmedOn) {
//        this.rearmedOn = rearmedOn;
//    }

//    public void setMutedOn(String mutedOn) {
//        this.mutedOn = mutedOn;
//    }

//    public void setRecognizedOn(String recognizedOn) {
//        this.recognizedOn = recognizedOn;
//    }


}
