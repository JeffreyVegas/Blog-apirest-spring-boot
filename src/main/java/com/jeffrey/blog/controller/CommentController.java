package com.jeffrey.blog.controller;

import com.jeffrey.blog.dto.CommentDto;
import com.jeffrey.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;
import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto){
        System.out.println(commentDto.getPublicationId());
        return new ResponseEntity<>(commentService.createComment(commentDto), HttpStatus.CREATED);
    }
    @GetMapping("/publication/{publicationId}")
    public ResponseEntity<List<CommentDto>> getAllCommentsByPublicationId(@PathVariable(name = "publicationId") long id){
        return ResponseEntity.status(OK).body(commentService.getCommentsByPublicationId(id));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable(name = "commentId") Long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>(OK);
    }

}
