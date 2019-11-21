package edu.kea.jnd.goatsite.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "likes")

public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Goat goatLiker;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Goat goatLiked;
}
