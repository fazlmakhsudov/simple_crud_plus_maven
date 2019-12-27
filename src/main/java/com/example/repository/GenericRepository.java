package com.example.repository;

import java.util.List;

/**
 * CRUD generic interface
 *
 * @param <T>
 */
public interface GenericRepository<T> {
    /**
     * Creates T in respective repository.
     *
     * @param item T to create
     * @return generated T id or -1 if T wasn't created
     */
    long create(T item);

    T read(long id);

    /**
     * Saves T updates.
     *
     * @param item T to update
     * @return true if saved successfully, false otherwise
     */
    boolean update(T item);

    /**
     * Deletes T by id.
     *
     * @param id T id
     * @return true if the T was deleted, false otherwise
     */
    boolean delete(long id);

    List<T> getAll();
}
