package com.jeffrey.blog.mapper;

import com.jeffrey.blog.dto.PublicationRequest;
import com.jeffrey.blog.entity.Publication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class PublicationRequestToPublication implements Imapper<PublicationRequest, Publication>{
    @Override
    public Publication map(PublicationRequest in) {
        Publication publication= new Publication();
        publication.setTitle(in.getTitle());
        publication.setDescription(in.getDescription());
        publication.setContents(in.getContents());
        publication.setCreateAt(LocalDateTime.now());
        return publication;
    }
}
