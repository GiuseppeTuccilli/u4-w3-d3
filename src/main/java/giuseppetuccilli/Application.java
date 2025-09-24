package giuseppetuccilli;

import giuseppetuccilli.dao.EventiDAO;
import giuseppetuccilli.dao.LoactionsDAO;
import giuseppetuccilli.dao.PartecipazioniDao;
import giuseppetuccilli.dao.PersoneDAO;
import giuseppetuccilli.entities.Evento;
import giuseppetuccilli.entities.Location;
import giuseppetuccilli.entities.Partecipazioni;
import giuseppetuccilli.entities.Persona;
import giuseppetuccilli.enums.EventType;
import giuseppetuccilli.enums.Stato;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d3pu");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        EventiDAO ed = new EventiDAO(em);
        PersoneDAO pd = new PersoneDAO(em);
        LoactionsDAO ld = new LoactionsDAO(em);
        PartecipazioniDao pard = new PartecipazioniDao(em);
        LocalDate d = LocalDate.of(1991, 10, 10);
        LocalDate d2 = LocalDate.of(2025, 5, 10);

        Persona p1 = new Persona("pippo", "pluto", "emaildipippo", d, "M");
        Location loc1 = new Location("location1", "Milano");
        // ld.save(loc1);
        Location locFromDb = ld.getById("1f2ae604-0021-43dc-884d-db5144a76b0e");

        Evento ev1 = new Evento("titolo1", d2, "descrizione1", EventType.PRIVATO, 10, locFromDb);
        //ed.save(ev1);


        // pd.save(p1);

        Persona pFromDb = pd.getById("e4083e4c-d8a4-45e9-ab25-0c6abe89a944");
        System.out.println(pFromDb);
        Evento evFromDb = ed.getById("c0cd8115-645f-4cd3-9e2d-033b06c63019");
        System.out.println(evFromDb);

        Partecipazioni part1 = new Partecipazioni(pFromDb, evFromDb, Stato.CONFERMATA);
        // pard.save(part1);
        System.out.println(pFromDb);

        em.close();
        emf.close();


        System.out.println("Hello World!");
    }
}
