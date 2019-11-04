package edu.kea.jnd.goatsite.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "likes")
public class Like {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long goatLiker;
    private Long goatLiked;
}
