package com.tweteroo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.service.TweetService;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {

    @Autowired
    private TweetService service;

    @GetMapping
    public Page<Tweet> getAll(@PageableDefault(page = 1, size = 5) Pageable page) {
        return service.getTweets(page);
    }

    @PostMapping
    public ResponseEntity<Tweet> create(@RequestBody TweetDTO req) {
        Tweet tweet = service.createTweet(req);
        if(tweet != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
