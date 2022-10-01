package org.example.criteria.api.helper.query.impl;

import org.example.criteria.api.helper.query.DeleteQuery;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

public class DeleteQueryImpl<R> extends BaseQueryImpl<R, DeleteQueryImpl<R>> implements DeleteQuery<R, DeleteQueryImpl<R>> {
    private final EntityManager em;
    private final CriteriaBuilder cb;
    private final CriteriaDelete<R> query;
    private final Root<R> root;

    public DeleteQueryImpl(EntityManager em, Class<R> type) {
        this.em = em;
        this.cb = em.getCriteriaBuilder();
        this.query = cb.createCriteriaDelete(type);
        this.root = query.from(type);
    }

    @Override
    protected DeleteQueryImpl<R> self() {
        return this;
    }

    @Override
    public int execute() {
        if (!predicates.isEmpty()) {
            query.where(buildPredicates(query, predicates, cb, root));
        }
        return em.createQuery(query)
                .executeUpdate();
    }
}
