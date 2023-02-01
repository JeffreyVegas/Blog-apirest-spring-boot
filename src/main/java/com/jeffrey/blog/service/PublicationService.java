package com.jeffrey.blog.service;


import com.jeffrey.blog.dto.PublicationRequest;
import com.jeffrey.blog.dto.PublicationResponse;
import com.jeffrey.blog.entity.Publication;
import com.jeffrey.blog.mapper.PublicationRequestToPublication;
import com.jeffrey.blog.mapper.PublicationToPublicationResponse;
import com.jeffrey.blog.repository.IPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PublicationService implements IPublicationService{
    @Autowired
    IPublicationRepository repository;
    @Autowired
    PublicationToPublicationResponse mapperPtoPRs;
    @Autowired
    PublicationRequestToPublication mapperPrqToP;

    @Override
    public PublicationResponse getPublication(Long id) {
        return mapperPtoPRs.map(repository.getPublication(id));
    }

    @Override
    public List<Publication> getPublications() {
        return repository.getPublications();
    }

    @Override
    public void createPublication(PublicationRequest publicationRequest) {
        Publication publication=mapperPrqToP.map(publicationRequest);
        repository.createPublication(publication);
    }

    @Override
    public void deletePublication(Long id) {
        repository.deletePublication(id);
    }
}
