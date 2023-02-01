package com.jeffrey.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicationRequest {
    private String title;
    private String description;
    private String contents;
}
