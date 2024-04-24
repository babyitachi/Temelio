package com.example.temeliobe.controllers;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.temeliobe.entities.NonProfit;
import com.example.temeliobe.services.NonProfitService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("/nonprofit")
@RestController
public class NonProfitController {
    private final NonProfitService nonProfitService;

    @PostMapping("/add")
    public ResponseEntity<NonProfit> getEmails(@RequestBody NonProfit nonProfit) {
        NonProfit nonProfitOrg = this.nonProfitService.addNonProfit(nonProfit);
        return ResponseEntity.ok(nonProfitOrg);
    }

    @GetMapping("/all")
    public ResponseEntity<Set<String>> getAllEmails() {
        Set<String> nonProfitOrg = this.nonProfitService.getAllNonProfit();
        return ResponseEntity.ok(nonProfitOrg);
    }

}
