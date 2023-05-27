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
        var nativeQueryResultList = em.createNativeQuery("SELECT * FROM public.registrations", RegistrationEntity.class)
                .getResultList();
        return resultList;
    }

    @Transactional
    public void updateRegistrations(RegistrationEntity reg) {
        var updateRegistration = em.find(RegistrationEntity.class, reg.getId());
        updateRegistration.setApproved(reg.isApproved());
    }
}
