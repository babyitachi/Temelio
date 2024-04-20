package com.example.temeliobe.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;

import com.example.temeliobe.entities.Email;
import com.example.temeliobe.entities.Foundation;
import com.example.temeliobe.entities.NonProfit;
import com.example.temeliobe.repositories.EmailRepo;
import com.example.temeliobe.repositories.FoundationRepo;
import com.example.temeliobe.repositories.NonProfitRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailService {

    private final EmailRepo emailRepo;
    private final NonProfitRepo nonProfitRepo;
    private final FoundationRepo foundationRepo;

    public boolean addEmails(String senderEmailId, List<String> nonProfitEmailIds) {
        if (this.foundationRepo.getFoundation(senderEmailId) == null) {
            return false;
        }
        this.emailRepo.addEmails(senderEmailId, nonProfitEmailIds);
        return true;
    }

    public List<String> getEmails(String nonProfitEmailId) {
        NonProfit nonProfit = this.nonProfitRepo.getNonProfit(nonProfitEmailId);
        if (nonProfit == null) {
            return new ArrayList<>();
        }
        List<String> messages = new ArrayList<>();
        Set<Email> emails = this.emailRepo.getEmails(nonProfitEmailId);
        if (emails == null) {
            return new ArrayList<>();

        }
        emails.forEach(email -> {
            String text = "Sending money to nonprofit " + nonProfit.getName() + " at address " + nonProfit.getAddress()+" - by " + email.getSender();
            messages.add(text);
        });
        return messages;
    }
}
