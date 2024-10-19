package com.example.supervisory.api.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Create_New_User")
public class NewUser{
    @JsonProperty("Id_New_User")
    private Integer idNewUser;
    @JsonProperty("Id_User")
    @NotBlank(message = "Id user cannot be blank")
    private Integer idUser;
    @JsonProperty("User_Name")
    @NotBlank(message = "User name cannot be blank")
    private String userName;
    @JsonProperty("Name")
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @JsonProperty("E_Mail")
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @JsonProperty("Default_Password")
    private String defaultPassword;
    @JsonProperty("Created_On")
    private String createdOn;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getIdNewUser() {
        return idNewUser;
    }

    public void setIdNewUser(Integer idNewUser) {
        this.idNewUser = idNewUser;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public void setDefaultPassword(String defaultPassword) {
        this.defaultPassword = PasswordGenerator.generatePassword();
    }

}
