package giuseppetuccilli.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "location_id")
    private UUID locationId;
    private String nome;
    private String città;

    public Location() {
    }

}
