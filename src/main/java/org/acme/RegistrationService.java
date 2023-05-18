package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RegistrationService {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void register(String name, String surname, String email) {
        var reg = new RegistrationEntity();
        reg.setName(name);
        reg.setSurname(surname);
        reg.setEmail(email);
        em.persist(reg);
    }
}
