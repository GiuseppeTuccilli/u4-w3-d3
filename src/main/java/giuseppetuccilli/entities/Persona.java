package giuseppetuccilli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue
    private UUID personaId;
    private String nome;
    private String cognome;
    private String email;
    private LocalDate dataNascita;
    private String sesso;


    @OneToMany(mappedBy = "persona")
    private List<Partecipazioni> listaPartecipazioni;

    public Persona() {
    }


}
