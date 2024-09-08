package com.example.demo.models;


import java.time.Instant;

public class Vote {

    private Instant publishedAt;
    private Integer userId;
    private VoteOption voteOption;
    private Integer id;
    private static int counter;

    public Vote(User user, VoteOption voteOption) {
        this.id = ++counter;
        this.userId = user.getId();
        this.voteOption = voteOption;
        this.publishedAt = Instant.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public VoteOption getVoteOption() {
        return voteOption;
    }

    public void setVoteOption(VoteOption voteOption) {
        this.voteOption = voteOption;
    }
}
