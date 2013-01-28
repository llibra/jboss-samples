package com.gmail.libra.learn.oddfilter;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class LoggerBean implements Logger {
    @PersistenceContext(unitName = "OddFilterPU")
    private EntityManager em;

    @Override
    public void log(String input) {
        Log log = new Log(input);
        em.persist(log);
    }

    @Override
    public List<Log> list() {
        TypedQuery<Log> query = em.createQuery("SELECT l FROM Log l", Log.class);
        return query.getResultList();
    }
}
