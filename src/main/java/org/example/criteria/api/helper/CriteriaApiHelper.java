package org.example.criteria.api.helper;

import org.example.criteria.api.helper.query.impl.*;
import org.example.criteria.api.helper.query.util.SubqueryPredicate;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.SingularAttribute;
import java.util.Collection;

public class CriteriaApiHelper {
    private final EntityManager em;

    public CriteriaApiHelper(EntityManager em) {
        this.em = em;
    }

    public <T> SelectQueryImpl<T> select(Class<T> type) {
        return new SelectQueryImpl<>(em, type);
    }

    public <T> UpdateQueryImpl<T> update(Class<T> type) {
        return new UpdateQueryImpl<>(em, type);
    }

    public <T> DeleteQueryImpl<T> delete(Class<T> type) {
        return new DeleteQueryImpl<>(em, type);
    }

    public static <R, V> QueryPart<R> equal(SingularAttribute<R, V> attribute, V value) {
        return new QueryPart<R>()
                .equal(attribute, value);
    }

    public static <R, P, V> QueryPart<R> equal(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2,
                                               V value) {
        return new QueryPart<R>()
                .equal(attribute1, attribute2, value);
    }

    public static <R, P1, P2, V> QueryPart<R> equal(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                    SingularAttribute<P2, V> attribute3, V value) {
        return new QueryPart<R>()
                .equal(attribute1, attribute2, attribute3, value);
    }

    public static <R, P1, P2, P3, V> QueryPart<R> equal(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                        SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, V> attribute4,
                                                        V value) {
        return new QueryPart<R>()
                .equal(attribute1, attribute2, attribute3, attribute4, value);
    }

    public static <R, V> QueryPart<R> notEqual(SingularAttribute<R, V> attribute, V value) {
        return new QueryPart<R>()
                .notEqual(attribute, value);
    }

    public static <R, P, V> QueryPart<R> notEqual(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2,
                                                  V value) {
        return new QueryPart<R>()
                .notEqual(attribute1, attribute2, value);
    }

    public static <R, P1, P2, V> QueryPart<R> notEqual(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                       SingularAttribute<P2, V> attribute3, V value) {
        return new QueryPart<R>()
                .notEqual(attribute1, attribute2, attribute3, value);
    }

    public static <R, P1, P2, P3, V> QueryPart<R> notEqual(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                           SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, V> attribute4,
                                                           V value) {
        return new QueryPart<R>()
                .notEqual(attribute1, attribute2, attribute3, attribute4, value);
    }

    public static <R> QueryPart<R> isTrue(SingularAttribute<R, Boolean> attribute) {
        return new QueryPart<R>()
                .isTrue(attribute);
    }

    public static <R, P> QueryPart<R> isTrue(SingularAttribute<R, P> attribute1, SingularAttribute<P, Boolean> attribute2) {
        return new QueryPart<R>()
                .isTrue(attribute1, attribute2);
    }

    public static <R, P1, P2> QueryPart<R> isTrue(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                  SingularAttribute<P2, Boolean> attribute3) {
        return new QueryPart<R>()
                .isTrue(attribute1, attribute2, attribute3);
    }

    public static <R, P1, P2, P3> QueryPart<R> isTrue(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                      SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, Boolean> attribute4) {
        return new QueryPart<R>()
                .isTrue(attribute1, attribute2, attribute3, attribute4);
    }

    public static <R> QueryPart<R> isFalse(SingularAttribute<R, Boolean> attribute) {
        return new QueryPart<R>()
                .isFalse(attribute);
    }

    public static <R, P> QueryPart<R> isFalse(SingularAttribute<R, P> attribute1, SingularAttribute<P, Boolean> attribute2) {
        return new QueryPart<R>()
                .isFalse(attribute1, attribute2);
    }

    public static <R, P1, P2> QueryPart<R> isFalse(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                   SingularAttribute<P2, Boolean> attribute3) {
        return new QueryPart<R>()
                .isFalse(attribute1, attribute2, attribute3);
    }

    public static <R, P1, P2, P3> QueryPart<R> isFalse(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                       SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, Boolean> attribute4) {
        return new QueryPart<R>()
                .isFalse(attribute1, attribute2, attribute3, attribute4);
    }

    public static <R, V> QueryPart<R> isNull(SingularAttribute<R, V> attribute) {
        return new QueryPart<R>()
                .isNull(attribute);
    }

    public static <R, P, V> QueryPart<R> isNull(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2) {
        return new QueryPart<R>()
                .isNull(attribute1, attribute2);
    }

    public static <R, P1, P2, V> QueryPart<R> isNull(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                     SingularAttribute<P2, V> attribute3) {
        return new QueryPart<R>()
                .isNull(attribute1, attribute2, attribute3);
    }

    public static <R, P1, P2, P3, V> QueryPart<R> isNull(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                         SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, V> attribute4) {
        return new QueryPart<R>()
                .isNull(attribute1, attribute2, attribute3, attribute4);
    }

    public static <R, V> QueryPart<R> isNotNull(SingularAttribute<R, V> attribute) {
        return new QueryPart<R>()
                .isNotNull(attribute);
    }

    public static <R, P, V> QueryPart<R> isNotNull(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2) {
        return new QueryPart<R>()
                .isNotNull(attribute1, attribute2);
    }

    public static <R, P1, P2, V> QueryPart<R> isNotNull(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                        SingularAttribute<P2, V> attribute3) {
        return new QueryPart<R>()
                .isNotNull(attribute1, attribute2, attribute3);
    }

    public static <R, P1, P2, P3, V> QueryPart<R> isNotNull(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                            SingularAttribute<P2, P3> attribute3, SingularAttribute<P3, V> attribute4) {
        return new QueryPart<R>()
                .isNotNull(attribute1, attribute2, attribute3, attribute4);
    }

    public static <R, V extends Comparable<? super V>> QueryPart<R> greaterThan(SingularAttribute<R, V> attribute, V value) {
        return new QueryPart<R>()
                .greaterThan(attribute, value);
    }

    public static <R, P, V extends Comparable<? super V>> QueryPart<R> greaterThan(SingularAttribute<R, P> attribute1,
                                                                                   SingularAttribute<P, V> attribute2,
                                                                                   V value) {
        return new QueryPart<R>()
                .greaterThan(attribute1, attribute2, value);
    }

    public static <R, P1, P2, V extends Comparable<? super V>> QueryPart<R> greaterThan(SingularAttribute<R, P1> attribute1,
                                                                                        SingularAttribute<P1, P2> attribute2,
                                                                                        SingularAttribute<P2, V> attribute3,
                                                                                        V value) {
        return new QueryPart<R>()
                .greaterThan(attribute1, attribute2, attribute3, value);
    }

    public static <R, P1, P2, P3, V extends Comparable<? super V>> QueryPart<R> greaterThan(SingularAttribute<R, P1> attribute1,
                                                                                            SingularAttribute<P1, P2> attribute2,
                                                                                            SingularAttribute<P2, P3> attribute3,
                                                                                            SingularAttribute<P3, V> attribute4,
                                                                                            V value) {
        return new QueryPart<R>()
                .greaterThan(attribute1, attribute2, attribute3, attribute4, value);
    }

    public static <R, V extends Comparable<? super V>> QueryPart<R> lessThan(SingularAttribute<R, V> attribute,
                                                                             V value) {
        return new QueryPart<R>()
                .lessThan(attribute, value);
    }

    public static <R, P, V extends Comparable<? super V>> QueryPart<R> lessThan(SingularAttribute<R, P> attribute1,
                                                                                SingularAttribute<P, V> attribute2,
                                                                                V value) {
        return new QueryPart<R>()
                .lessThan(attribute1, attribute2, value);
    }

    public static <R, P1, P2, V extends Comparable<? super V>> QueryPart<R> lessThan(SingularAttribute<R, P1> attribute1,
                                                                                     SingularAttribute<P1, P2> attribute2,
                                                                                     SingularAttribute<P2, V> attribute3,
                                                                                     V value) {
        return new QueryPart<R>()
                .lessThan(attribute1, attribute2, attribute3, value);
    }

    public static <R, P1, P2, P3, V extends Comparable<? super V>> QueryPart<R> lessThan(SingularAttribute<R, P1> attribute1,
                                                                                         SingularAttribute<P1, P2> attribute2,
                                                                                         SingularAttribute<P2, P3> attribute3,
                                                                                         SingularAttribute<P3, V> attribute4,
                                                                                         V value) {
        return new QueryPart<R>()
                .lessThan(attribute1, attribute2, attribute3, attribute4, value);
    }

    public static <R> QueryPart<R> like(SingularAttribute<R, String> attribute, String value) {
        return new QueryPart<R>()
                .like(attribute, value);
    }

    public static <R, P> QueryPart<R> like(SingularAttribute<R, P> attribute1, SingularAttribute<P, String> attribute2,
                                           String value) {
        return new QueryPart<R>()
                .like(attribute1, attribute2, value);
    }

    public static <R, P1, P2> QueryPart<R> like(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                SingularAttribute<P2, String> attribute3, String value) {
        return new QueryPart<R>()
                .like(attribute1, attribute2, attribute3, value);
    }

    public static <R, P1, P2, P3> QueryPart<R> like(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                    SingularAttribute<P2, P3> attribute3,
                                                    SingularAttribute<P3, String> attribute4, String value) {
        return new QueryPart<R>()
                .like(attribute1, attribute2, attribute3, attribute4, value);
    }

    @SafeVarargs
    public static <R> QueryPart<R> and(QueryPart<R>... partQueries) {
        return new QueryPart<R>()
                .and(partQueries);
    }

    @SafeVarargs
    public static <R, P> QueryPart<R> and(SingularAttribute<R, P> attribute, QueryPart<P>... partQueries) {
        return new QueryPart<R>()
                .and(attribute, partQueries);
    }

    @SafeVarargs
    public static <R, P1, P2> QueryPart<R> and(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                               QueryPart<P2>... partQueries) {
        return new QueryPart<R>()
                .and(attribute1, attribute2, partQueries);
    }

    @SafeVarargs
    public static <R, P1, P2, P3> QueryPart<R> and(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                   SingularAttribute<P2, P3> attribute3, QueryPart<P3>... partQueries) {
        return new QueryPart<R>()
                .and(attribute1, attribute2, attribute3, partQueries);
    }

    @SafeVarargs
    public static <R> QueryPart<R> or(QueryPart<R>... partQueries) {
        return new QueryPart<R>()
                .or(partQueries);
    }

    @SafeVarargs
    public static <R, P> QueryPart<R> or(SingularAttribute<R, P> attribute, QueryPart<P>... partQueries) {
        return new QueryPart<R>()
                .or(attribute, partQueries);
    }

    @SafeVarargs
    public static <R, P1, P2> QueryPart<R> or(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                              QueryPart<P2>... partQueries) {
        return new QueryPart<R>()
                .or(attribute1, attribute2, partQueries);
    }

    @SafeVarargs
    public static <R, P1, P2, P3> QueryPart<R> or(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                  SingularAttribute<P2, P3> attribute3, QueryPart<P3>... partQueries) {
        return new QueryPart<R>()
                .or(attribute1, attribute2, attribute3, partQueries);
    }

    public static <R> SubQueryImpl<R> subquery(Class<R> type) {
        return new SubQueryImpl<>(type);
    }

    @SafeVarargs
    public static <R> QueryPart<R> in(SubqueryPredicate<R>... values) {
        return new QueryPart<R>()
                .in(values);
    }

    public static <R, V> QueryPart<R> in(SingularAttribute<R, V> attribute, Collection<V> values) {
        return new QueryPart<R>()
                .in(attribute, values);
    }

    @SafeVarargs
    public static <R, V> QueryPart<R> in(SingularAttribute<R, V> attribute, SubqueryPredicate<V>... values) {
        return new QueryPart<R>()
                .in(attribute, values);
    }

    public static <R, P, V> QueryPart<R> in(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2,
                                            Collection<V> values) {
        return new QueryPart<R>()
                .in(attribute1, attribute2, values);
    }

    @SafeVarargs
    public static <R, P, V> QueryPart<R> in(SingularAttribute<R, P> attribute1, SingularAttribute<P, V> attribute2,
                                            SubqueryPredicate<V>... values) {
        return new QueryPart<R>()
                .in(attribute1, attribute2, values);
    }

    public static <R, P1, P2, V> QueryPart<R> in(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                 SingularAttribute<P2, V> attribute3, Collection<V> values) {
        return new QueryPart<R>()
                .in(attribute1, attribute2, attribute3, values);
    }

    @SafeVarargs
    public static <R, P1, P2, V> QueryPart<R> in(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2,
                                                 SingularAttribute<P2, V> attribute3, SubqueryPredicate<V>... values) {
        return new QueryPart<R>()
                .in(attribute1, attribute2, attribute3, values);
    }
}
