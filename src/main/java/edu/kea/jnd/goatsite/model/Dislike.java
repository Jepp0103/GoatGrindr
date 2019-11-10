package edu.kea.jnd.goatsite.model;
import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "dislikes")
public class Dislike {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "goat_disliker_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Goat goatDisliker;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "goat_disliked_id", nullable = false)
    private Goat goatDisliked;
}
