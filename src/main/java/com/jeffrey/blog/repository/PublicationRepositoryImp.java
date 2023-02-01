package com.jeffrey.blog.repository;

import com.jeffrey.blog.dto.PublicationRequest;
import com.jeffrey.blog.entity.Publication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class PublicationRepositoryImp implements IPublicationRepository{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public Publication getPublication(Long id) {
        return entityManager.find(Publication.class, id);
    }

    @Override
    public List<Publication> getPublications() {
        String query = "FROM Publication";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Publication createPublication(Publication publication) {
        return entityManager.merge(publication);
    }


    @Override
    public void deletePublication(Long id) {
        Publication publication= entityManager.find(Publication.class,id);
        entityManager.remove(publication);
    }


}


