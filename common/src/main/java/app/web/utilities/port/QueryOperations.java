package app.web.utilities.port;

import app.web.exception.NotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QueryOperations<T> {
    T findById(long id) throws NotFoundException;

    List<T> findAll(Pageable pageable);
}
