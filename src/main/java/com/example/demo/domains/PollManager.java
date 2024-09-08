package com.example.demo.domains;

import com.example.demo.models.Poll;
import com.example.demo.models.User;
import com.example.demo.models.Vote;
import com.example.demo.models.VoteOption;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class PollManager {

    private Map<Integer, User> userMap = new HashMap<>();
    private Map<Integer, Poll> pollMap = new HashMap<>();
    private Map<Integer, VoteOption> voteOptionMap = new HashMap<>();
    private Map<Integer, Vote> voteMap = new HashMap<>();

    public PollManager() {
    }

    public User addUser(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    public Collection<User> getAllUsers() {
        return userMap.values();
    }

    public User getUserById(Integer userId) {
        return userMap.get(userId);
    }

    public User updateUser(Integer userId, User updatedUser) {
        if (userMap.containsKey(userId)) {
            updatedUser.setId(userId);
            userMap.put(userId, updatedUser);
            return updatedUser;
        }
        return null;
    }

    public boolean deleteUser(Integer userId) {
        return userMap.remove(userId) != null;
    }

    public Poll addPoll(Poll poll) {
        pollMap.put(poll.getPollId(), poll);
        return poll;
    }

    public Collection<Poll> getAllPolls() {
        return pollMap.values();
    }

    public Poll getPollById(Integer pollId) {
        return pollMap.get(pollId);
    }

    public Poll updatePoll(Integer pollId, Poll updatedPoll) {
        if (pollMap.containsKey(pollId)) {
            updatedPoll.setPollId(pollId);
            pollMap.put(pollId, updatedPoll);
            return updatedPoll;
        }
        return null;
    }

    public boolean deletePoll(Integer pollId) {
        return pollMap.remove(pollId) != null;
    }

    public VoteOption addVoteOption(VoteOption voteOption) {;
        voteOptionMap.put(voteOption.getId(), voteOption);
        return voteOption;
    }

    public Collection<VoteOption> getAllVoteOptions() {
        return voteOptionMap.values();
    }

    public VoteOption getVoteOptionById(Integer id) {
        return voteOptionMap.get(id);
    }

    public VoteOption updateVoteOption(Integer id, VoteOption updatedVoteOption) {
        if (voteOptionMap.containsKey(id)) {
            updatedVoteOption.setId(id);
            voteOptionMap.put(id, updatedVoteOption);
            return updatedVoteOption;
        }
        return null;
    }

    public boolean deleteVoteOption(Integer id) {
        return voteOptionMap.remove(id) != null;
    }
    
    public Vote addVote(Vote vote) {
        voteMap.put(vote.getId(), vote);
        return vote;
    }

    public Collection<Vote> getAllVotes() {
        return voteMap.values();
    }

    public Vote getVoteById(Integer id) {
        return voteMap.get(id);
    }

    public Vote updateVote(Integer id, Vote updatedVote) {
        if (voteMap.containsKey(id)) {
            updatedVote.setId(id);
            voteMap.put(id, updatedVote);
            return updatedVote;
        }
        return null;
    }

    public boolean deleteVote(Integer id) {
        return voteMap.remove(id) != null;
    }

}
