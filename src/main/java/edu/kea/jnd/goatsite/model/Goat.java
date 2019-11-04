package edu.kea.jnd.goatsite.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Long getId(){
        return id;
    }
}
