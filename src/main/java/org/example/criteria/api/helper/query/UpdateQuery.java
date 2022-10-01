package org.example.criteria.api.helper.query;

import javax.persistence.metamodel.SingularAttribute;

public interface UpdateQuery<R> extends BaseQuery<R, UpdateQuery<R>> {
    <V> UpdateQuery<R> set(SingularAttribute<R, V> attribute, V value);

    int execute();
}
