package com.example.temeliobe.services;

import java.util.Set;

import org.springframework.stereotype.Service;
import com.example.temeliobe.entities.NonProfit;
import com.example.temeliobe.repositories.NonProfitRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NonProfitService {

    private final NonProfitRepo nonProfitRepo;

    public NonProfit addNonProfit(NonProfit nonProfit) {
        if (this.nonProfitRepo.getNonProfit(nonProfit.getEmail()) == null) {
            this.nonProfitRepo.addNonProfit(nonProfit);
            return nonProfit;
        }
        return null;
    }

    public NonProfit getNonProfit(String email) {
        return this.nonProfitRepo.getNonProfit(email);
    }
    
    public Set<String> getAllNonProfit() {
        return this.nonProfitRepo.getAllNonProfit();
    }

}
