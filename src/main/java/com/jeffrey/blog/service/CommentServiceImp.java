package com.jeffrey.blog.service;

import com.jeffrey.blog.dto.CommentDto;
import com.jeffrey.blog.entity.Comment;
import com.jeffrey.blog.entity.Publication;
import com.jeffrey.blog.mapper.CommentDtoToComment;
import com.jeffrey.blog.mapper.CommentToCommentDto;
import com.jeffrey.blog.repository.CommentRepository;
import com.jeffrey.blog.repository.IPublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CommentServiceImp implements CommentService{
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    CommentDtoToComment mapperCDToToC;
    @Autowired
    CommentToCommentDto mapperCToCDto;
    @Autowired
    IPublicationRepository publicationRepository;

    @Override
    public List<CommentDto> getCommentsByPublicationId(Long publicationId) {
        List<Comment> comments=commentRepository.findByPublicationId(publicationId);
        return comments.stream().map(comment -> mapperCToCDto.map(comment)).collect(Collectors.toList());
    }
    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = mapperCDToToC.map(commentDto);
        Publication publication = publicationRepository.getPublication(commentDto.getPublicationId());
        comment.setPublication(publication);
        return mapperCToCDto.map(commentRepository.save(comment));
    }
    @Override
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id).orElse(null);
        if(comment!=null)
        commentRepository.delete(comment);
    }
}
