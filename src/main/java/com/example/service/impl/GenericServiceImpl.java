package com.example.service.impl;

import com.example.repository.GenericRepository;
import com.example.service.GenericService;

import java.util.List;

/**
 * implements GenericService
 *
 * @param <T>
 */
public class GenericServiceImpl<T> implements GenericService<T> {
    private GenericRepository<T> GenericRepository;

    public GenericServiceImpl(GenericRepository<T> GenericRepository) {
        this.GenericRepository = GenericRepository;
    }

    public long add(T item) {
        return GenericRepository.create(item);
    }

    public T find(long id) {
        return GenericRepository.read(id);
    }

    public boolean save(T item) {
        return GenericRepository.update(item);
    }

    public boolean remove(long id) {
        return GenericRepository.delete(id);
    }

    public List<T> findAll() {
        return GenericRepository.getAll();
    }
}
