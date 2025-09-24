package giuseppetuccilli.entities;

import giuseppetuccilli.enums.Stato;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "patecipazioni")
public class Partecipazioni {

    @Id
    @GeneratedValue
    private UUID partId;

    @ManyToOne
    @JoinColumn(name = "personaid", nullable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazioni() {
    }


}
