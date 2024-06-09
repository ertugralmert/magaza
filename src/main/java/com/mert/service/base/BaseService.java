package com.mert.service.base;

import java.util.List;

public interface BaseService<T, R, ID> {
    R save(T dto);
    R update(ID id, T dto);
    R findById(ID id);
    List<R> findAll();
    void deleteById(ID id);
}
