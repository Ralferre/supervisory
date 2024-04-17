package dto.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import static dto.model.user.PasswordGenerator.generatePassword;

@Entity
@Table(name = "Create_New_User")
public class NewUser extends User{
    @JsonProperty("Id_New_User")
    private Integer idNewUser;
    @JsonProperty("E_Mail")
    private String email;
    @JsonProperty("Default_Password")
    private String defaultPassword;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdNewUser() {
        return idNewUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEMail(String email) {
        this.email = email;
    }

    public String getDefaultPassword() {
        return defaultPassword;
    }

    public void setDefaultPassword(String defaultPassword) {
        this.defaultPassword = generatePassword();
    }

}
