package com.jeffrey.blog.mapper;

import com.jeffrey.blog.dto.CommentDto;
import com.jeffrey.blog.entity.Comment;
import com.jeffrey.blog.entity.Publication;
import org.springframework.stereotype.Component;

@Component
public class CommentDtoToComment implements Imapper<CommentDto, Comment> {
    @Override
    public Comment map(CommentDto in) {
        Comment comment = new Comment();
        comment.setName(in.getName());
        comment.setEmail(in.getEmail());
        comment.setContent(in.getContent());
        return comment;
    }
}
