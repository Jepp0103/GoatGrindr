package edu.kea.jnd.goatsite.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name = "likes")

public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "goat_liker_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Goat goatLiker;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "goat_liked_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Goat goatLiked;
}
