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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long goatDisliker;
    private Long goatDisliked;
}
