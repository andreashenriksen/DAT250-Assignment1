package com.example.demo.controllers;

import com.example.demo.domains.PollManager;
import com.example.demo.models.Poll;
import com.example.demo.models.User;
import com.example.demo.models.VoteOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollManager pollManager;

    @PostMapping
    public ResponseEntity<Poll> createPoll(@RequestBody Map<String, Object> request) {
        Integer userId = Integer.valueOf(request.get("userId").toString());
        String question = request.get("question").toString();
        User user = pollManager.getUserById(userId);
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        if (user.getPolls().containsValue(question)) {
            return ResponseEntity.badRequest().build();
        }
        Poll poll = new Poll(question, user);
        VoteOption voteOption1 = new VoteOption("yes", 1);
        VoteOption voteOption2 = new VoteOption("no", 2);
        poll.addVoteOption(voteOption1);
        poll.addVoteOption(voteOption2);
        pollManager.addVoteOption(voteOption1);
        pollManager.addVoteOption(voteOption2);
        Poll createdPoll = pollManager.addPoll(poll);
        user.addPoll(poll);
        return ResponseEntity.ok(createdPoll);
    }

    @GetMapping
    public ResponseEntity<Collection<Poll>> getAllPolls() {
        return ResponseEntity.ok(pollManager.getAllPolls());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoll(@PathVariable Integer id) {
        Poll poll = pollManager.getPollById(id);
        User user = poll.getUser();
        user.removePoll(id);
        boolean deleted = pollManager.deletePoll(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
