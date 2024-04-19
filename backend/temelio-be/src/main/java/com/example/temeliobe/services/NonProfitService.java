package com.example.temeliobe.services;

import org.springframework.stereotype.Service;
import com.example.temeliobe.entities.NonProfit;
import com.example.temeliobe.repositories.NonProfitRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NonProfitService {

    private final NonProfitRepo nonProfitRepo;

    public NonProfit addFoundation(NonProfit nonProfit) {
        if (this.nonProfitRepo.getNonProfit(nonProfit.getEmail()) == null) {
            this.nonProfitRepo.addNonProfit(nonProfit);
            return nonProfit;
        }
        return null;
    }

    public NonProfit getFoundation(String email) {
        return this.nonProfitRepo.getNonProfit(email);
    }

}
