package edu.kea.jnd.goatsite.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Table(name = "goats")
public class Goat {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Past
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dob;

    @Length(max = 500)
    private String shortDescription;

    @Length(max = 10000)
    private String longDescription;

    private String password;

    @Email(message = "Should be an email")
    private String username;

    //Create with an enum
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    //Goat_liker relation
    @OneToMany(mappedBy = "goatLiker")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Like> goatLikers;

    //Goat_liked relation
    @OneToMany(mappedBy = "goatLiked")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Like> goatLikeds;


    //Getters
    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Gender getGender() {
        return gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}