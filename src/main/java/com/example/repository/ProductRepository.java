package com.example.repository;

import com.example.entity.Product;

import java.util.List;

public interface ProductRepository {
    /**
     *
     * Creates product in respective repository.
     *
     * @param item product to create
     * @return generated product id or -1 if product wasn't created
     */
    long create(Product item);

    Product read(long id);

    /**
     * Saves product updates.
     *
     * @param item product to update
     * @return true if saved successfully, false otherwise
     */
    boolean update(Product item);

    /**
     * Deletes product by id.
     *
     * @param id product id
     *
     * @return true if the product was deleted, false otherwise
     */
    boolean delete(long id);

    List<Product> getAll();
}
