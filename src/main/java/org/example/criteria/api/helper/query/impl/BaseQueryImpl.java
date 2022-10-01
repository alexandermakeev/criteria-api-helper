package org.example.criteria.api.helper.query.impl;

import org.example.criteria.api.helper.query.BaseQuery;
import org.example.criteria.api.helper.query.util.QueryPredicate;

import javax.persistence.criteria.CommonAbstractCriteria;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public abstract class BaseQueryImpl<R, Q extends BaseQueryImpl<R, Q>> implements BaseQuery<R, Q> {
    protected final Collection<QueryPredicate<R>> predicates;

    public BaseQueryImpl() {
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

    @SafeVarargs
    @Override
    public final Q and(QueryPart<R>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.and(buildPredicates(criteria, partQuery.predicates, cb, root)))
                    .toArray(Predicate[]::new);
            return cb.and(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <P> Q and(SingularAttribute<R, P> attribute, QueryPart<P>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.and(buildPredicates(criteria, partQuery.predicates, cb, root.get(attribute))))
                    .toArray(Predicate[]::new);
            return cb.and(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <P1, P2> Q and(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, QueryPart<P2>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.and(buildPredicates(criteria, partQuery.predicates, cb, root.get(attribute1).get(attribute2))))
                    .toArray(Predicate[]::new);
            return cb.and(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <P1, P2, P3> Q and(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, SingularAttribute<P2, P3> attribute3, QueryPart<P3>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.and(buildPredicates(criteria, partQuery.predicates, cb, root.get(attribute1).get(attribute2).get(attribute3))))
                    .toArray(Predicate[]::new);
            return cb.and(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final Q or(QueryPart<R>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.or(buildPredicates(criteria, partQuery.predicates, cb, root)))
                    .toArray(Predicate[]::new);
            return cb.or(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <P> Q or(SingularAttribute<R, P> attribute, QueryPart<P>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.or(buildPredicates(criteria, partQuery.predicates, cb, root.get(attribute)))).toArray(Predicate[]::new);
            return cb.or(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <P1, P2> Q or(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, QueryPart<P2>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.or(buildPredicates(criteria, partQuery.predicates, cb, root.get(attribute1).get(attribute2)))).toArray(Predicate[]::new);
            return cb.or(predicates);
        });
        return self();
    }

    @SafeVarargs
    @Override
    public final <P1, P2, P3> Q or(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                   SingularAttribute<P2, P3> attribute3, QueryPart<P3>... partQueries) {
        predicates.add((criteria, cb, root) -> {
            Predicate[] predicates = Arrays.stream(partQueries)
                    .map(partQuery -> cb.or(buildPredicates(criteria, partQuery.predicates, cb, root.get(attribute1).get(attribute2).get(attribute3)))).toArray(Predicate[]::new);
            return cb.or(predicates);
        });
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
