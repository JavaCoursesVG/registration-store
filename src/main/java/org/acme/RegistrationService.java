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
    public List<RegistrationEntity> getAll(int resNum) {
        var resultList = em.createQuery("select entity from RegistrationEntity entity")
                .setMaxResults(resNum)
                .getResultList();
        return resultList;
    }
}
