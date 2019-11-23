package edu.kea.jnd.goatsite.model;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Goat goat1Id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Goat goat2Id;
}
