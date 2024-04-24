package com.example.temeliobe.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.temeliobe.dtos.EmailDto;
import com.example.temeliobe.services.EmailService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/email")
@RestController
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/get")
    public ResponseEntity<List<String>> getEmails(@RequestParam String nonProfitEmail) {
        List<String> emails = emailService.getEmails(nonProfitEmail);
        if (emails == null) {
            return ResponseEntity.ok(new ArrayList<>());
        }
        return ResponseEntity.ok(emails);
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmails(@RequestBody EmailDto emailBody) {
        Boolean sentStatus = this.emailService.addEmails(emailBody.getSenderEmailId(), emailBody.getSenderEmailCCId(), emailBody.getSenderEmailBCCId(), emailBody.getNonProfitEmailIds());
        if(sentStatus){
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.ok("NotReg");
    }

}
