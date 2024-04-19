package com.example.temeliobe.repositories;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.example.temeliobe.entities.NonProfit;

@Repository
public class NonProfitRepo {
    private final Map<String, NonProfit> nonProfit;

    public NonProfitRepo() {
        this.nonProfit = new HashMap<>();
    }

    public NonProfit addNonProfit(NonProfit nonProfit) {
        this.nonProfit.put(nonProfit.getEmail(), nonProfit);
        return nonProfit;
    }

    public NonProfit getNonProfit(String email) {
        return this.nonProfit.get(email);
    }    
}
