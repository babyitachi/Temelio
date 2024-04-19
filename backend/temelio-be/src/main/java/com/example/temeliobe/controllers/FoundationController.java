package com.example.temeliobe.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.temeliobe.entities.Foundation;
import com.example.temeliobe.services.FoundationService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/foundation")
@RestController
public class FoundationController {

    private final FoundationService foundationService;

    @PostMapping("/add")
    public ResponseEntity<Foundation> getEmails(@RequestBody Foundation foundation) {
        Foundation foundationOrg = this.foundationService.addFoundation(foundation);
        return ResponseEntity.ok(foundationOrg);
    }

}
