package com.jeffrey.blog.service;

import com.jeffrey.blog.dto.PublicationRequest;
import com.jeffrey.blog.dto.PublicationResponse;
import com.jeffrey.blog.entity.Publication;

import java.util.List;

public interface IPublicationService {
    PublicationResponse getPublication(Long id);
    List<Publication>  getPublications();
    void createPublication(PublicationRequest publicationRequest);
    void deletePublication(Long id);

}
