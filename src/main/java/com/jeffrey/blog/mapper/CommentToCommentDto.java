package com.jeffrey.blog.mapper;

import com.jeffrey.blog.dto.CommentDto;
import com.jeffrey.blog.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentToCommentDto implements Imapper<Comment,CommentDto> {
    @Override
    public CommentDto map(Comment in) {
        CommentDto commentDto= new CommentDto();
        commentDto.setId(in.getId());
        commentDto.setName(in.getName());
        commentDto.setEmail(in.getEmail());
        commentDto.setContent(in.getContent());
        commentDto.setPublicationId(in.getPublication().getId());
        return commentDto;
    }
}