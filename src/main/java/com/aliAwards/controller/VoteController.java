package com.aliAwards.controller;

import com.aliAwards.model.Vote;
import com.aliAwards.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping
    public Vote saveVote(@RequestParam Long userId, @RequestParam Long categoryId) {
        return voteService.saveVote(userId, categoryId);
    }
}
