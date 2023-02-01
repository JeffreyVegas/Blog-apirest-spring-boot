package com.jeffrey.blog.mapper;

import com.jeffrey.blog.dto.PublicationResponse;
import com.jeffrey.blog.entity.Publication;
import org.springframework.stereotype.Component;

@Component
public class PublicationToPublicationResponse implements Imapper<Publication, PublicationResponse>{
    @Override
    public PublicationResponse map(Publication in) {
        PublicationResponse publicationResponse=new PublicationResponse();
        publicationResponse.setId(in.getId());
        publicationResponse.setTitle(in.getTitle());
        publicationResponse.setDescription(in.getDescription());
        publicationResponse.setContents(in.getContents());
        publicationResponse.setCreateAt(in.getCreateAt());
        return publicationResponse;
    }
}
