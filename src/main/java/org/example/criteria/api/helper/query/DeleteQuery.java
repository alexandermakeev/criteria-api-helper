package org.example.criteria.api.helper.query;

public interface DeleteQuery<R, Q extends DeleteQuery<R, Q>> extends BaseQuery<R, Q> {
    int execute();
}