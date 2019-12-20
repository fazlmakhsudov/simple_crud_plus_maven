package com.example.service.impl;

import com.example.repository.PublicationRepository;
import com.example.service.PublicationService;

import java.util.List;

/**
 * implements PublicationService
 *
 * @param <T>
 */
public abstract class PublicationServiceImpl<T> extends GenericServiceImpl<T> implements PublicationService<T> {
    protected PublicationRepository<T> publicationRepository;

    public PublicationServiceImpl(PublicationRepository<T> publicationRepository, String loggerClassName) {
        super(publicationRepository, loggerClassName);
        this.publicationRepository = publicationRepository;
    }


    @Override
    public List<T> findAllByUserId(long user_id) {
        logger.info(String.format("FindAllByUserId: long user_id = %d", user_id));
        return publicationRepository.getAllByUserId(user_id);
    }

    @Override
    public T findByTitle(String title) {
        logger.info(String.format("FindByTitle: String title = %s", title));
        return publicationRepository.getByTitle(title);
    }
}
