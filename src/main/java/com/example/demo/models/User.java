package com.example.demo.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class User {

    private static int counter;
    private Integer id;
    private String username;
    private String email;
    private Map<Integer, String> polls = new HashMap<>();
    private Set<Vote> votes = new HashSet<>();

    public User(String username, String email) {
        this.id = ++counter;
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer userId) {
        this.id = userId;
    }

    public Map<Integer, String> getPolls() {
        return polls;
    }

    public void setPolls(Map<Integer, String> polls) {
        this.polls = polls;
    }

    public void addPoll(Poll poll) {
        if (this.polls.containsValue(poll.getQuestion())) {
            return;
        }
        this.polls.put(poll.getPollId(), poll.getQuestion());
    }

    public void removePoll(Integer id) {
        this.polls.remove(id);
    }

    public Set<Vote> getVotes() {
        return votes;
    }

    public void setVotes(Set<Vote> votes) {
        this.votes = votes;
    }

    public void addVote(Vote vote) {
        this.votes.add(vote);
    }
}
