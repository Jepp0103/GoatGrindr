package edu.kea.jnd.goatsite.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Goat goatLiker;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "goat_liked_id", nullable = false)
    @JsonIgnore
    private Goat goatLiked;

    public Long getId(){
        return id;
    }

    public Goat getGoat_liker() {
        return goatLiker;
    }

    public Goat getGoat_liked() {
        return goatLiked;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGoat_liker(Goat goat_liker) {
        this.goatLiker = goat_liker;
    }

    public void setGoat_liked(Goat goat_liked) {
        this.goatLiked = goat_liked;
    }
}
