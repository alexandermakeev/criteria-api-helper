package org.example.criteria.api.helper.query.util;

import javax.persistence.criteria.CommonAbstractCriteria;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Subquery;

@FunctionalInterface
public interface SubqueryPredicate<P> {
    Subquery<P> apply(CommonAbstractCriteria criteria, CriteriaBuilder cb);
}