package org.example.criteria.api.helper.query.impl;

import org.example.criteria.api.helper.query.BaseQuery;
import org.example.criteria.api.helper.query.QueryPredicate;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CommonAbstractCriteria;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseQueryImpl<R, Q extends BaseQuery<R, Q>> implements BaseQuery<R, Q> {
    protected final EntityManager em;
    protected final CriteriaBuilder cb;
    protected final Collection<QueryPredicate<R>> predicates;

    public BaseQueryImpl(EntityManager em) {
        this.em = em;
        this.cb = em.getCriteriaBuilder();
        this.predicates = new ArrayList<>();
    }

    @Override
    public <V> Q equal(SingularAttribute<R, V> attribute, V value) {
        predicates.add((criteria, cb, root) -> cb.equal(root.get(attribute), value));
        return self();
    }

    @Override
    public <P, V> Q equal(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2, V value) {
        predicates.add((criteria, cb, root) -> cb.equal(root.get(attribute1).get(attribute2), value));
        return self();
    }

    @Override
    public <P1, P2, V> Q equal(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                               SingularAttribute<P2, V> attribute3, V value) {
        predicates.add((criteria, cb, root) -> cb.equal(root.get(attribute1).get(attribute2).get(attribute3), value));
        return self();
    }

    @Override
    public <P1, P2, P3, V> Q equal(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                   SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, V> attribute4, V value) {
        predicates.add((criteria, cb, root) -> cb.equal(root.get(attribute1).get(attribute2).get(attribute3).get(attribute4), value));
        return self();
    }

    @Override
    public <V> Q notEqual(SingularAttribute<R, V> attribute, V value) {
        predicates.add((criteria, cb, root) -> cb.notEqual(root.get(attribute), value));
        return self();
    }

    @Override
    public <P, V> Q notEqual(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2, V value) {
        predicates.add((criteria, cb, root) -> cb.notEqual(root.get(attribute1).get(attribute2), value));
        return self();
    }

    @Override
    public <P1, P2, V> Q notEqual(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                  SingularAttribute<P2, V> attribute3, V value) {
        predicates.add((criteria, cb, root) -> cb.notEqual(root.get(attribute1).get(attribute2).get(attribute3), value));
        return self();
    }

    @Override
    public <P1, P2, P3, V> Q notEqual(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                      SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, V> attribute4, V value) {
        predicates.add((criteria, cb, root) -> cb.notEqual(root.get(attribute1).get(attribute2).get(attribute3).get(attribute4), value));
        return self();
    }

    @Override
    public <V extends Comparable<? super V>> Q greaterThan(SingularAttribute<R, V> attribute, V value) {
        predicates.add((criteria, cb, root) -> cb.greaterThan(root.get(attribute), value));
        return self();
    }

    @Override
    public <P, V extends Comparable<? super V>> Q greaterThan(SingularAttribute<R, P> attribute1,
                                                              SingularAttribute<P, V> attribute2, V value) {
        predicates.add((criteria, cb, root) -> cb.greaterThan(root.get(attribute1).get(attribute2), value));
        return self();
    }

    @Override
    public <P1, P2, V extends Comparable<? super V>> Q greaterThan(SingularAttribute<R, P1> attribute1,
                                                                   SingularAttribute<P1, P2> attribute2,
                                                                   SingularAttribute<P2, V> attribute3, V value) {
        predicates.add((criteria, cb, root) -> cb.greaterThan(root.get(attribute1).get(attribute2).get(attribute3), value));
        return self();
    }

    @Override
    public <P1, P2, P3, V extends Comparable<? super V>> Q greaterThan(SingularAttribute<R, P1> attribute1,
                                                                       SingularAttribute<P1, P2> attribute2,
                                                                       SingularAttribute<P2, P3> attribute3,
                                                                       SingularAttribute<P3, V> attribute4, V value) {
        predicates.add((criteria, cb, root) -> cb.greaterThan(root.get(attribute1).get(attribute2).get(attribute3).get(attribute4), value));
        return self();
    }

    @Override
    public <V extends Comparable<? super V>> Q lessThan(SingularAttribute<R, V> attribute, V value) {
        predicates.add((criteria, cb, root) -> cb.lessThan(root.get(attribute), value));
        return self();
    }

    @Override
    public <P, V extends Comparable<? super V>> Q lessThan(SingularAttribute<R, P> attribute1,
                                                           SingularAttribute<P, V> attribute2, V value) {
        predicates.add((criteria, cb, root) -> cb.lessThan(root.get(attribute1).get(attribute2), value));
        return self();
    }

    @Override
    public <P1, P2, V extends Comparable<? super V>> Q lessThan(SingularAttribute<R, P1> attribute1,
                                                                SingularAttribute<P1, P2> attribute2,
                                                                SingularAttribute<P2, V> attribute3, V value) {
        predicates.add((criteria, cb, root) -> cb.lessThan(root.get(attribute1).get(attribute2).get(attribute3), value));
        return self();
    }

    @Override
    public <P1, P2, P3, V extends Comparable<? super V>> Q lessThan(SingularAttribute<R, P1> attribute1,
                                                                    SingularAttribute<P1, P2> attribute2,
                                                                    SingularAttribute<P2, P3> attribute3,
                                                                    SingularAttribute<P3, V> attribute4, V value) {
        predicates.add((criteria, cb, root) -> cb.lessThan(root.get(attribute1).get(attribute2).get(attribute3).get(attribute4), value));
        return self();
    }

    @Override
    public Q like(SingularAttribute<R, String> attribute, String value) {
        predicates.add((criteria, cb, root) -> cb.like(root.get(attribute), "%" + value + "%"));
        return self();
    }

    @Override
    public <P> Q like(SingularAttribute<R, P> attribute1, SingularAttribute<P, String> attribute2, String value) {
        predicates.add((criteria, cb, root) -> cb.like(root.get(attribute1).get(attribute2), "%" + value + "%"));
        return self();
    }

    @Override
    public <P1, P2> Q like(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                           SingularAttribute<P2, String> attribute3, String value) {
        predicates.add((criteria, cb, root) -> cb.like(root.get(attribute1).get(attribute2).get(attribute3), "%" + value + "%"));
        return self();
    }

    @Override
    public <P1, P2, P3> Q like(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                               SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, String> attribute4,
                               String value) {
        predicates.add((criteria, cb, root) -> cb.like(root.get(attribute1).get(attribute2).get(attribute3).get(attribute4), "%" + value + "%"));
        return self();
    }

    //subclasses must override this method to return "this"
    protected abstract Q self();

    protected <T> Predicate[] buildPredicates(CommonAbstractCriteria criteria, Collection<QueryPredicate<T>> predicates,
                                              CriteriaBuilder cb, Path<T> root) {
        return predicates
                .stream()
                .map(t -> t.apply(criteria, cb, root))
                .toArray(Predicate[]::new);
    }
}
