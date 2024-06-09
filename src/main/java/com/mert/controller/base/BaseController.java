package com.mert.controller.base;

import org.springframework.http.ResponseEntity;
import java.util.List;

public interface BaseController<T, R, ID> {
    ResponseEntity<R> save(T dto);
    ResponseEntity<R> update(ID id, T dto);
    ResponseEntity<R> findById(ID id);
    ResponseEntity<List<R>> findAll();
    ResponseEntity<Void> deleteById(ID id);
}
