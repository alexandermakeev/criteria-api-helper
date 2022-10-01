package org.example.criteria.api.helper.query;

public interface DeleteQuery<R> extends BaseQuery<R, DeleteQuery<R>> {
    int execute();
}