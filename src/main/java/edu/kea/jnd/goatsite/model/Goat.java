package edu.kea.jnd.goatsite.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
@Entity
@Table(name = "goats")

public class Goat {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @NotNull
    @Length(max = 500)
    private String shortDescription;

    @NotNull
    @Length(max = 10000)
    private String longDescription;

    @NotNull
    private String password;

    @NotNull
    @Email(message = "Should be an email")
    private String username;

    //Create with an enum
    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

 /*  //Goat_liker relation
    @OneToMany(mappedBy = "goatLiker")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Like> goatLikers;

    //Goat_liked relation
    @OneToMany(mappedBy = "goatLiked")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Like> goatLikeds;*/
}