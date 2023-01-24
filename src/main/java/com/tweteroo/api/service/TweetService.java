package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.TweetRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository repository;

    public Tweet createTweet(TweetDTO req) {
        return repository.save(new Tweet(req));
    }
}
