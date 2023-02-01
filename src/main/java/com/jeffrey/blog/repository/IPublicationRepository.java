package com.jeffrey.blog.repository;

import com.jeffrey.blog.entity.Publication;

import java.util.List;

public interface IPublicationRepository {
    Publication getPublication(Long id);
    List<Publication> getPublications();
    Publication createPublication(Publication publication);
    void deletePublication(Long id);
}
