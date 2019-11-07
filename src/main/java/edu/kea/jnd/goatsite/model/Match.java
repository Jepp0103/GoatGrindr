package edu.kea.jnd.goatsite.model;
import javax.persistence.*;

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autogenererer alle felter i databasen.
    private Long id;
    private Long goat1Id;
    private Long goat2Id;
}
