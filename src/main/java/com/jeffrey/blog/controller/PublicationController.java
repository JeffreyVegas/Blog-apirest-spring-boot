package com.jeffrey.blog.controller;

import com.jeffrey.blog.dto.PublicationRequest;
import com.jeffrey.blog.dto.PublicationResponse;
import com.jeffrey.blog.entity.Publication;
import com.jeffrey.blog.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/publication")
public class PublicationController {
    @Autowired
    PublicationService service;
    @PostMapping
    public void createPublication(@RequestBody PublicationRequest publicationRequest){
        service.createPublication(publicationRequest);
        System.out.println("publication created");
    }
    @GetMapping("/{id}")
    public PublicationResponse getPublicationById(@PathVariable("id") Long id){
        PublicationResponse publication= service.getPublication(id);
        return publication;
    }
    @GetMapping
    public List<Publication> getAllPublications(){
        return service.getPublications();
    }
    @DeleteMapping("/{id}")
    public void deletePublicationById(@PathVariable("id") Long id){
        service.deletePublication(id);
        System.out.println("publication deleted");
    }

}
