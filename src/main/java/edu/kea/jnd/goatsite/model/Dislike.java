package edu.kea.jnd.goatsite.model;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dislikes")
public class Dislike {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long goatDisliker;

    @NotNull
    private Long goatDisliked;
}
