package com.tweteroo.api.model;

import com.tweteroo.api.dto.TweetDTO;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tweets")
@NoArgsConstructor
public class Tweet {

    public Tweet (TweetDTO data) {
        this.username = data.username();
        this.avatar = data.avatar();
        this.text = data.text();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 20, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    private String avatar;

    @Column(length = 140, nullable = false)
    private String text;
}
