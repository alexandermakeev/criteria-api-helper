package org.example.criteria.api.helper.query.impl;

public class QueryPart<R> extends BaseQueryImpl<R, QueryPart<R>> {
    @Override
    protected QueryPart<R> self() {
        return this;
    }
}
