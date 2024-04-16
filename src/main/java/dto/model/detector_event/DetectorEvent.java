package dto.model.detector_event;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Detector_Event")
public class DetectorEvent {
    @JsonProperty("Id_Event")
    private Integer idEvent;
    @JsonProperty("Id_Detector")
    @NotBlank(message = "Id detector cannot be blank")
    private Integer idDetector;
    @JsonProperty("Max_Register")
    @NotBlank(message = "Maximum value registered cannot be blank")
    private Double maxRegister;
    @JsonProperty("Date_Register")
    @NotBlank(message = "Date of register cannot be blank")
    private String dateRegister;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdEvent() {
        return idEvent;
    }

    public Integer getIdDetector() {
        return idDetector;
    }

    public void setIdDetector(Integer idDetector) {
        this.idDetector = idDetector;
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

    public void setDateRegister(String dateRegister) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        this.dateRegister = now.format(formatter);
    }
}
