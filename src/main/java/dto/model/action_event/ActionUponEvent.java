package dto.model.action_event;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Action_Upon_Event")
public class ActionUponEvent {
    @JsonProperty("Id_Action_Event")
    private Integer idActionEvent;
    @JsonProperty("Id_Action_Manage")
    @NotBlank(message = "Id action manage cannot be blank")
    private Integer idActionManage;
    @JsonProperty("Id_User")
    @NotBlank(message = "Id user cannot be blank")
    private Integer idUser;
    @JsonProperty("Rearmed_On")
    //REARMED means that the operator treated the leak and reamed it, changing the visual color in the screen
    private String rearmedOn;
    @JsonProperty("Muted_On")
    //MUTED means that the leak does not treat, so the operator muted the alarm, but there is a sign in the supervisory indicating detector active only by color
    private String mutedOn;
    @JsonProperty("Recognized_On")
    //RECOGNIZED means that the operator has done treat the leak and recognized the alarm, to change the color of the detector which was muted
    private String recognizedOn;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdActionEvent() {
        return idActionEvent;
    }

    public Integer getIdActionManage() {
        return idActionManage;
    }

    public void setIdActionManage(Integer idActionManage) {
        this.idActionManage = idActionManage;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

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
}
