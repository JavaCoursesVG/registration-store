package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class RegistrationService {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void register(String name, String surname, String email, boolean approved) {
        var reg = new RegistrationEntity();
        reg.setName(name);
        reg.setSurname(surname);
        reg.setEmail(email);
        reg.setApproved(approved);
        em.persist(reg);
    }

    @Transactional
    public Object getAll() {
        var resultList = em.createQuery("select entity from RegistrationEntity entity")
                .getResultList();
        RegistrationEntity reg = new RegistrationEntity();
        var resultList2 = em.createNativeQuery("SELECT * FROM public.registrations", RegistrationEntity.class)
                .getResultList();
        return resultList2;
    }

    @Transactional
    public void updateRegistrations(String name, String surname, String email, boolean approved) {
        var resultList2 = em.createNativeQuery(
                "UPDATE public.registrations SET approved=true WHERE name='"
                + name +"', surname='" + surname +"', email='" + email +"'")
                .getResultList();

    }
}
