package org.example.criteria.api.helper.query.impl;

import org.example.criteria.api.helper.query.UpdateQuery;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

public class UpdateQueryImpl<R> extends BaseQueryImpl<R, UpdateQuery<R>> implements UpdateQuery<R> {
    private final CriteriaUpdate<R> query;
    private final Root<R> root;

    public UpdateQueryImpl(EntityManager em, Class<R> type) {
        super(em);
        this.query = cb.createCriteriaUpdate(type);
        this.root = query.from(type);
    }

    @Override
    public <V> UpdateQuery<R> set(SingularAttribute<R, V> attribute, V value) {
        query.set(attribute, value);
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

    @Override
    protected UpdateQueryImpl<R> self() {
        return this;
    }
}
