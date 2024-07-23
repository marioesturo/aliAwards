package com.aliAwards.service;

import com.aliAwards.model.Nomination;
import com.aliAwards.repository.NominationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NominationService {

    @Autowired
    private NominationRepository nominationRepository;

    public Nomination saveNomination(Nomination nomination) {
        return nominationRepository.save(nomination);
    }
}
