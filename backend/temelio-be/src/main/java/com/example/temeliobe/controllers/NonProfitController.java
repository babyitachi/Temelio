package com.example.temeliobe.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.temeliobe.entities.NonProfit;
import com.example.temeliobe.repositories.NonProfitRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RequiredArgsConstructor
@RequestMapping("/nonprofit")
@RestController
public class NonProfitController {
    private final NonProfitRepo nonProfitRepo;

    @PostMapping("/add")
    public ResponseEntity<NonProfit> getEmails(@RequestBody NonProfit nonProfit) {
        NonProfit nonProfitOrg = this.nonProfitRepo.addNonProfit(nonProfit);
        return ResponseEntity.ok(nonProfitOrg);
    }
}
