package org.example.criteria.api.helper.query;

import javax.persistence.metamodel.SingularAttribute;
import java.util.List;
import java.util.Optional;

public interface SelectQuery<R> extends BaseQuery<R, SelectQuery<R>> {
    <P> SelectQuery<R> sort(SingularAttribute<R, P> attribute);

    <P> SelectQuery<R> sort(SingularAttribute<R, P> attribute, Sort sort);

    <P1, P2> SelectQuery<R> sort(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    <P1, P2> SelectQuery<R> sort(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, Sort sort);

    <P1, P2, P3> SelectQuery<R> sort(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, SingularAttribute<P2, P3> attribute3);

    <P1, P2, P3> SelectQuery<R> sort(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, SingularAttribute<P2, P3> attribute3, Sort sort);

    <P> SelectQuery<R> fetch(SingularAttribute<R, P> attribute);

    <P1, P2> SelectQuery<R> fetch(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    <P1, P2, P3> SelectQuery<R> fetch(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, SingularAttribute<P2, P3> attribute3);

    List<R> findAll();

    <P> List<P> findAll(SingularAttribute<R, P> attribute);

    <P1, P2> List<P2> findAll(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    R getOne();

    <P> P getOne(SingularAttribute<R, P> attribute);

    <P1, P2> P2 getOne(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    Optional<R> findOne();

    <P> Optional<P> findOne(SingularAttribute<R, P> attribute);

    <P1, P2> Optional<P2> findOne(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    List<R> getPage(int page);

    <P> List<P> getPage(SingularAttribute<R, P> attribute, int page);

    <P1, P2> List<P2> getPage(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, int page);

    List<R> getPage(int page, int pageSize);

    <P> List<P> getPage(SingularAttribute<R, P> attribute, int page, int pageSize);

    <P1, P2> List<P2> getPage(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2, int page, int pageSize);

    long count();

    <P> long count(SingularAttribute<R, P> attribute);

    <P1, P2> long count(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);

    boolean exists();

    <P> boolean exists(SingularAttribute<R, P> attribute);

    <P1, P2> boolean exists(SingularAttribute<R, P1> attribute1, SingularAttribute<P1, P2> attribute2);
}
