package org.example.criteria.api.helper.query;

import org.example.criteria.api.helper.query.util.SubqueryPredicate;

import javax.persistence.metamodel.SingularAttribute;

public interface SubQuery<R, Q extends SubQuery<R, Q>> extends BaseQuery<R, Q> {
    SubqueryPredicate<R> select();

    <P> SubqueryPredicate<P> select(SingularAttribute<R, P> attribute);

    <P1, P2> SubqueryPredicate<P2> select(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    <P1, P2, P3> SubqueryPredicate<P3> select(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, SingularAttribute<P2, P3> attribute3);
}
