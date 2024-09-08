package com.example.demo.controllers;

import com.example.demo.domains.PollManager;
import com.example.demo.models.Poll;
import com.example.demo.models.User;
import com.example.demo.models.Vote;
import com.example.demo.models.VoteOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private PollManager pollManager;

    private Integer getUserId(@RequestBody Map<String, Object> request) {
        return Integer.valueOf(request.get("userId").toString());
    }

    private Integer getVoteOptionId(@RequestBody Map<String, Object> request) {
        return Integer.valueOf(request.get("voteOptionId").toString());
    }

    private Integer getPollId(@RequestBody Map<String, Object> request) {
        return Integer.valueOf(request.get("pollId").toString());
    }

    @PostMapping
    public ResponseEntity<Vote> createVote(@RequestBody Map<String, Object> request) {
        Integer userId = getUserId(request);
        Integer pollId = getPollId(request);
        Integer voteOptionId = getVoteOptionId(request);

        User user = pollManager.getUserById(userId);
        Poll poll = pollManager.getPollById(pollId);
        VoteOption voteOption = poll.getVoteOptions().get(voteOptionId-1);
        if (user == null || voteOption == null) {
            return ResponseEntity.badRequest().build();
        }

        Vote vote = new Vote(user, voteOption);
        Vote createdVote = pollManager.addVote(vote);
        user.addVote(vote);
        return ResponseEntity.ok(createdVote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vote> updateVote(@PathVariable Integer id, @RequestBody Map<String, Object> request) {
        Integer userId = getUserId(request);
        Integer pollId = getPollId(request);
        Integer voteOptionId = getVoteOptionId(request);

        User user = pollManager.getUserById(userId);
        Poll poll = pollManager.getPollById(pollId);
        VoteOption voteOption = poll.getVoteOptions().get(voteOptionId-1);
        if (user == null || voteOption == null) {
            return ResponseEntity.badRequest().build();
        }

        Vote updatedVote = new Vote(user, voteOption);
        Vote vote = pollManager.updateVote(id, updatedVote);
        if (vote != null) {
            return ResponseEntity.ok(vote);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Vote>> getAllVotes() {
        return ResponseEntity.ok(pollManager.getAllVotes());
    }
}
