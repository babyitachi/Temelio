package com.example.temeliobe.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class NonProfitCSV {
    public String NonprofitLegalName;
    public String GrantSubmissionName;
    public String Stage;
    public String FoundationOwner;
    public String RequestedAmount;
    public String AwardedAmount;
    public String GrantType;
    public String Tags;
    public String DurationStart;
    public String DurationEnd;
    public String AdditionalFileFolderPath;
    public String GrantSubmissionId;

}
