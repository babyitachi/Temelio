package com.example.temeliobe.repositories;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.temeliobe.entities.Email;
import com.example.temeliobe.entities.NonProfit;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class EmailRepo {
    private final NonProfitRepo nonProfitRepo;

    public void addEmails(String senderEmailId, String senderEmailCCId, String senderEmailBCCId,
            List<String> nonProfitEmailIds) {
        Email senderEmail = new Email(senderEmailId, senderEmailCCId, senderEmailBCCId);
        nonProfitEmailIds.forEach(nonProfitEmailId -> {
            NonProfit npo = this.nonProfitRepo.getNonProfit(nonProfitEmailId);
            if (npo != null) {
                Set<Email> emailsRecieved = npo.getEmailsRecieved();
                if (emailsRecieved == null) {
                    emailsRecieved = new HashSet<>();
                }
                emailsRecieved.add(senderEmail);
                npo.setEmailsRecieved(emailsRecieved);
            }
        });
    }

    public Set<Email> getEmails(String nonProfitEmailId) {
        return this.nonProfitRepo.getNonProfit(nonProfitEmailId).getEmailsRecieved();
    }

}
