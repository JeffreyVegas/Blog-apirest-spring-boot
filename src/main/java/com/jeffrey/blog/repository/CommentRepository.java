package com.jeffrey.blog.repository;
import com.jeffrey.blog.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    public List<Comment> findByPublicationId(Long publicationId);
}
