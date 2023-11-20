package com.app.controllers;

import com.app.models.Toy;
import com.app.services.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final ToyService toyService;

    @Autowired
    public SearchController(ToyService toyService) {
        this.toyService = toyService;
    }

    @GetMapping
    public ResponseEntity<List<Toy>> searchToys(@RequestParam String searchTerm) {
        List<Toy> searchResults = toyService.searchToys(searchTerm);
        return ResponseEntity.ok(searchResults);
    }
}
