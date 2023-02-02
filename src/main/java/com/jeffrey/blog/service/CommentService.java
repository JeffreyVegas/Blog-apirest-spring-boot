package com.jeffrey.blog.service;

import com.jeffrey.blog.dto.CommentDto;
import com.jeffrey.blog.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CommentService {
    public List<CommentDto> getCommentsByPublicationId(Long idPublication);
    public CommentDto createComment(CommentDto commentDto);
    public void deleteComment(Long id);

}
