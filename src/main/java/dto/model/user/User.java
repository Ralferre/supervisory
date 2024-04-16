package dto.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "Users")
public class User {
    @JsonProperty("Id_User")
    private Integer idUser;
    @JsonProperty("User_Name")
    @NotBlank(message = "UserName cannot be blank")
    private String userName;
    @JsonProperty("Name")
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @JsonProperty("User_Password")
    @NotBlank(message = "UserPassword cannot be blank")
    @Length(min = 8, max = 14, message = "Password must contain between 8 and 14 characters")
    private String userPassword;
    @JsonProperty("Profile")
    @NotBlank(message = "Profile cannot be blank")
    @Pattern(regexp = "ˆ(MANAGER|SUPERVISOR|OPERATOR)$",
    message = "Only these types of profile are accepted inside the application")
    private String profile;
    @JsonProperty("Created_On")
    private String createdOn;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdUser() {
        return idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        this.createdOn = now.format(formatter);
    }
}
