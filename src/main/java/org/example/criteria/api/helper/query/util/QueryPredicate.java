package org.example.criteria.api.helper.query.util;

import javax.persistence.criteria.CommonAbstractCriteria;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

@FunctionalInterface
public interface QueryPredicate<R> {
    Predicate apply(CommonAbstractCriteria criteria, CriteriaBuilder cb, Path<R> root);
}