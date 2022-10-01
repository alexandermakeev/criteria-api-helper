package org.example.criteria.api.helper;

import org.example.criteria.api.helper.query.DeleteQuery;
import org.example.criteria.api.helper.query.SelectQuery;
import org.example.criteria.api.helper.query.UpdateQuery;
import org.example.criteria.api.helper.query.impl.DeleteQueryImpl;
import org.example.criteria.api.helper.query.impl.SelectQueryImpl;
import org.example.criteria.api.helper.query.impl.UpdateQueryImpl;

import javax.persistence.EntityManager;

public class CriteriaApiHelper {
    private final EntityManager em;

    public CriteriaApiHelper(EntityManager em) {
        this.em = em;
    }

    public <T> SelectQuery<T> select(Class<T> type) {
        return new SelectQueryImpl<>(em, type);
    }

    public <T> UpdateQuery<T> update(Class<T> type) {
        return new UpdateQueryImpl<>(em, type);
    }

    public <T> DeleteQuery<T> delete(Class<T> type) {
        return new DeleteQueryImpl<>(em, type);
    }
}
