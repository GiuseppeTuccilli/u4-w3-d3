package giuseppetuccilli;

import giuseppetuccilli.dao.EventiDAO;
import giuseppetuccilli.dao.PersoneDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4-w3-d3pu");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        EventiDAO ed = new EventiDAO(em);
        PersoneDAO pd = new PersoneDAO(em);


        System.out.println("Hello World!");
    }
}
