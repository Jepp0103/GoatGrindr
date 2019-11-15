package edu.kea.jnd.goatsite.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "goat_id", nullable = false)
    private Goat goat;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;
}
