package com.gmail.libra.learn.oddfilter;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class UserInformationBean implements UserInformation {
    @PersistenceContext(unitName = "OddFilterPU")
    private EntityManager em;

    @Override
    public User find(String id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> list() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        System.out.println("list()");
        return query.getResultList();
    }
}
