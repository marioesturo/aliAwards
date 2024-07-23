package com.aliAwards.controller;

import com.aliAwards.model.Nomination;
import com.aliAwards.service.NominationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nominations")
public class NominationController {

    @Autowired
    private NominationService nominationService;

    @PostMapping
    public Nomination saveNomination(@RequestBody Nomination nomination) {
        return nominationService.saveNomination(nomination);
    }

}