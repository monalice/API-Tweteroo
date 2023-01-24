package com.tweteroo.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.TweetRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository repository;

    public Page<Tweet> getTweets(Pageable pageable) {
        int page = Integer.parseInt(pageable.getPageParameter());
        int size = Integer.parseInt(pageable.getSizeParameter());
        PageRequest pageRequest = PageRequest.of(page, size);

        return new PageImpl<>(
            repository.findAll(),
            pageRequest, size
        );
    }

    public Tweet createTweet(TweetDTO req) {
        return repository.save(new Tweet(req));
    }
}
