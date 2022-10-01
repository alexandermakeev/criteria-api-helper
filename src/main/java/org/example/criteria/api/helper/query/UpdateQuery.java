package org.example.criteria.api.helper.query;

import javax.persistence.metamodel.SingularAttribute;

public interface UpdateQuery<R, Q extends UpdateQuery<R, Q>> extends BaseQuery<R, Q> {
    <V> UpdateQuery<R, Q> set(SingularAttribute<R, V> attribute, V value);

    int execute();
}
