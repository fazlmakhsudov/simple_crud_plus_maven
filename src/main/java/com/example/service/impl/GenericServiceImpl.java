package com.example.service.impl;

import com.example.repository.GenericRepository;
import com.example.service.GenericService;

import java.util.List;
import java.util.logging.Logger;

/**
 * implements GenericService
 *
 * @param <T>
 */
public abstract class GenericServiceImpl<T> implements GenericService<T> {
    protected GenericRepository<T> GenericRepository;
    protected final Logger logger;

    public GenericServiceImpl(GenericRepository<T> GenericRepository, String loggerClassName) {
        this.GenericRepository = GenericRepository;
        this.logger = Logger.getLogger(loggerClassName);
        logger.info(logger.getName() + " - initialization");
    }

    public long add(T item) {
        logger.info(String.format("Add: item = %s", item));
        return GenericRepository.create(item);
    }

    public T find(long id) {
        logger.info(String.format("Find: long id = %d", id));
        return GenericRepository.read(id);
    }

    public boolean save(T item) {
        logger.info(String.format("Save: item = %s", item));
        return GenericRepository.update(item);
    }

    public boolean remove(long id) {
        logger.info(String.format("Remove: long id = %d", id));
        return GenericRepository.delete(id);
    }

    public List<T> findAll() {
        logger.info(String.format("FindAll: no parameter"));
        return GenericRepository.getAll();
    }
}
