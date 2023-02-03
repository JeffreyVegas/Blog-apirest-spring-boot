package com.jeffrey.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private long id;
    @NotEmpty(message = "enter a publication Id")
    private long publicationId;
    @NotEmpty(message = "please enter a name")
    private String name;
    @Email(message = "format is not correct")
    private String email;
    @NotEmpty(message = "enter a content")
    private String content;

}
