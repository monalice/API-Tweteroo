package com.tweteroo.api.repository;

import com.tweteroo.api.model.Tweet;
import org.springframework.data.repository.CrudRepository;

public interface TweetRepository extends CrudRepository<Tweet, Long>  {
    
}
