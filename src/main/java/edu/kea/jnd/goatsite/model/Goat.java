package edu.kea.jnd.goatsite.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import java.util.Date;

@Data
@Entity
@DynamicUpdate
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

    @Length(max = 500)
    private String shortDescription;

    @Length(max = 10000)
    private String longDescription;

    @NotNull
    private String password;

    @NotNull
    @Email(message = "Should be an email")
    private String username;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Enumerated (EnumType.STRING)
    private Role role;

    @NotNull
    private boolean enabled;
}