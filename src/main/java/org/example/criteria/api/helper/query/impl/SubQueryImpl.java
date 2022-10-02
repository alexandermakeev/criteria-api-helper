package org.example.criteria.api.helper.query.impl;

import org.example.criteria.api.helper.query.SubQuery;
import org.example.criteria.api.helper.query.util.SubqueryPredicate;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.persistence.metamodel.SingularAttribute;
import java.util.function.Function;

public class SubQueryImpl<R> extends BaseQueryImpl<R, SubQueryImpl<R>> implements SubQuery<R, SubQueryImpl<R>> {
    private final Class<R> type;

    public SubQueryImpl(Class<R> type) {
        this.type = type;
    }

    @Override
    public SubqueryPredicate<R> select() {
        return buildSubqueryPredicate(type, root -> root);
    }

    @Override
    public <P> SubqueryPredicate<P> select(SingularAttribute<R, P> attribute) {
        return buildSubqueryPredicate(attribute.getJavaType(), root -> root.get(attribute));
    }

    @Override
    public <P1, P2> SubqueryPredicate<P2> select(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2) {
        return buildSubqueryPredicate(attribute2.getJavaType(), root -> root.get(attribute1).get(attribute2));
    }

    @Override
    public <P1, P2, P3> SubqueryPredicate<P3> select(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, SingularAttribute<P2, P3> attribute3) {
        return buildSubqueryPredicate(attribute3.getJavaType(), root -> root.get(attribute1).get(attribute2).get(attribute3));
    }

    @Override
    protected SubQueryImpl<R> self() {
        return this;
    }

    private <P> SubqueryPredicate<P> buildSubqueryPredicate(Class<P> selectType, Function<Root<R>, Path<P>> pathFunction) {
        return (query, cb) -> {
            Subquery<P> subquery = query.subquery(selectType);
            Root<R> subqueryRoot = subquery.from(type);
            subquery
                    .select(pathFunction.apply(subqueryRoot))
                    .where(buildPredicates(subquery, predicates, cb, subqueryRoot));
            return subquery;
        };
    }
}
