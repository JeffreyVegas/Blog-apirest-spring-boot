package com.jeffrey.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private long id;
    private long publicationId;
    private String name;
    private String email;
    private String content;

}
