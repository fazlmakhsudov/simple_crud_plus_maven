package com.example.service.impl;

import com.example.repository.PublicationRepository;
import com.example.service.PublicationService;

import java.util.List;

/**
 * implements GenericService
 *
 * @param <T>
 */
public class PublicationServiceImpl<T> implements PublicationService<T> {
    private PublicationRepository<T> publicationRepository;

    public PublicationServiceImpl(PublicationRepository<T> publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public long add(T item) {
        return publicationRepository.create(item);
    }

    @Override
    public T find(long id) {
        return publicationRepository.read(id);
    }

    @Override
    public boolean save(T item) {
        return publicationRepository.update(item);
    }

    @Override
    public boolean remove(long id) {
        return publicationRepository.delete(id);
    }

    @Override
    public List<T> findAll() {
        return publicationRepository.getAll();
    }

    @Override
    public List<T> findAllByUserId(long user_id) {
        return publicationRepository.getAllByUserId(user_id);
    }

    @Override
    public T findByTitle(String title) {
        return publicationRepository.getByTitle(title);
    }
}
