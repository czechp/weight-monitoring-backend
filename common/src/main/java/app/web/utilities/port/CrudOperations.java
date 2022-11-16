package app.web.utilities.port;

import java.util.Optional;

public interface CrudOperations<T> {
    Optional<T> findById(long id);

    T findByIdOrThrowException(long id);

    T save(T t);

    T delete(T t);
}
