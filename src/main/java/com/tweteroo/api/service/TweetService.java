package com.tweteroo.api.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.tweteroo.api.model.User;
import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository repository;

    @Autowired
    private UserRepository userRepository;

    public Page<Tweet> getTweets(Pageable pageable) {
        int page = pageable.getPageNumber();
        int size = pageable.getPageSize();
        PageRequest pageRequest = PageRequest.of(page, size);

        return new PageImpl<>(
            repository.findAll(),
            pageRequest, size
        );
    }

    public List<Tweet> getTweetsByUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        if(user.isPresent()) {
            return repository.findByUsername(username);
        }
        return List.of();
    }

    public Tweet createTweet(TweetDTO req) {
        Optional<User> user = userRepository.findByUsername(req.username()); 

        if(user.isPresent()) {
            return repository.save(new Tweet(req, user.get().getAvatar()));
        }
        return null;
    }
}
