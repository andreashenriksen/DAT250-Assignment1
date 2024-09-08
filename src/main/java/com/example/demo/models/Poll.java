package com.example.demo.models;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Poll {

    private String question;
    private Instant publishedAt;
    private Instant validUntil;
    private User user;
    private ArrayList<VoteOption> voteOptions = new ArrayList<>();
    private Integer pollId;
    private static int counter;

    public Poll(String question, User user) {
        this.pollId = ++counter;
        this.question = question;
        this.publishedAt = Instant.now();
        this.validUntil = this.publishedAt.plus(1, ChronoUnit.HOURS);
        this.user = user;

    }

    public Integer getPollId() {
        return pollId;
    }

    public void setPollId(Integer pollId) {
        this.pollId = pollId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<VoteOption> getVoteOptions() {
        return voteOptions;
    }

    public void setVoteOptions(ArrayList<VoteOption> voteOptions) {
        this.voteOptions = voteOptions;
    }

    public void addVoteOption(VoteOption voteOption) {
        this.voteOptions.add(voteOption);
    }
}
