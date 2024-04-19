package com.example.temeliobe.services;

import org.springframework.stereotype.Service;

import com.example.temeliobe.entities.Foundation;
import com.example.temeliobe.repositories.FoundationRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FoundationService {

    private final FoundationRepo foundationRepo;

    public Foundation addFoundation(Foundation foundation) {
        if (this.foundationRepo.getFoundation(foundation.getEmail()) == null) {
            this.foundationRepo.addFoundation(foundation);
            return foundation;
        }
        return null;
    }

    public Foundation getFoundation(String email) {
        return this.foundationRepo.getFoundation(email);
    }

}
