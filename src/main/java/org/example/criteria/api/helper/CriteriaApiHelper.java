package org.example.criteria.api.helper;

import javax.persistence.EntityManager;

public class CriteriaApiHelper {
    private final EntityManager em;

    public CriteriaApiHelper(EntityManager em) {
        this.em = em;
    }
}
