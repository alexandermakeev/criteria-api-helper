package org.example.criteria.api.helper.query.impl;

import org.example.criteria.api.helper.query.DeleteQuery;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

public class DeleteQueryImpl<R> extends BaseQueryImpl<R, DeleteQuery<R>> implements DeleteQuery<R> {
    private final CriteriaDelete<R> query;
    private final Root<R> root;

    public DeleteQueryImpl(EntityManager em, Class<R> type) {
        super(em);
        this.query = cb.createCriteriaDelete(type);
        this.root = query.from(type);
    }

    @Override
    protected DeleteQuery<R> self() {
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
