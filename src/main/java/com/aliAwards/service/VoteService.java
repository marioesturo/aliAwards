package com.aliAwards.service;

import com.aliAwards.model.Category;
import com.aliAwards.model.User;
import com.aliAwards.model.Vote;
import com.aliAwards.repository.CategoryRepository;
import com.aliAwards.repository.UserRepository;
import com.aliAwards.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Vote saveVote(Long userId, Long categoryId) {
        User user = userRepository.findById(userId).orElse(null);
        Category category = categoryRepository.findById(categoryId).orElse(null);

        if (user != null && category != null) {
            Vote vote = new Vote();
            vote.setUser(user);
            vote.setCategory(category);
            vote.setVoteDate(LocalDate.now());
            return voteRepository.save(vote);
        }
        return null;
    }
}