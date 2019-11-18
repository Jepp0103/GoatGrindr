package edu.kea.jnd.goatsite.model;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Goat goat1Id;

    @NotNull
    @ManyToOne
    private Goat goat2Id;
}
