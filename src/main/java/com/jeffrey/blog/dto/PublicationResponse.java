package com.jeffrey.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationResponse {
    private Long id;
    private String title;
    private String description;
    private String contents;
    private LocalDateTime createAt;
}
