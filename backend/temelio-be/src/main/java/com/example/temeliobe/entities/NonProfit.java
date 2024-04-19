package com.example.temeliobe.entities;
import java.util.Set;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class NonProfit {
    private String email;
    private String name;
    private String address;
    private Set<Email> emailsRecieved;
}
