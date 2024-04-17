package dto.model.manage_event;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Manage_Detector_Event")
public class ManageDetectorEvent {
    @JsonProperty("Id_Action_Manage")
    private Integer idActionManage;
    @JsonProperty("Id_Detector")
    private Integer idDetector;
    @JsonProperty("Id_User")
    private Integer idUser;
    @JsonProperty("Date_Action")
    private String dateAction;
    @JsonProperty("Type_Action_Manage")
    @Pattern(regexp = "ˆ(ALARM)$", message = "It means that the detector event is active and requires some intervention")
    private String typeActionManage;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdActionManage() {
        return idActionManage;
    }

    public Integer getIdDetector() {
        return idDetector;
    }

    public void setIdDetector(Integer idDetector) {
        this.idDetector = idDetector;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getDateAction() {
        return dateAction;
    }

    public void setDateAction(String dateAction) {
        this.dateAction = dateAction;
    }

    public String getTypeActionManage() {
        return typeActionManage;
    }

    public void setTypeActionManage(String typeActionManage) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        this.typeActionManage = now.format(formatter);
    }
}
