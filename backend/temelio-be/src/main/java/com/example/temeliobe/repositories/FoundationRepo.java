package com.example.temeliobe.repositories;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.temeliobe.entities.Foundation;

@Repository
public class FoundationRepo {

    private final Map<String, Foundation> foundations;

    public FoundationRepo() {
        this.foundations = new HashMap<>();
    }

    public void addFoundation(Foundation foundation) {
        this.foundations.put(foundation.getEmail(), foundation);
    }

    public Foundation getFoundation(String email) {
        return this.foundations.get(email);
    }

}
