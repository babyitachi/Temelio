package com.example.temeliobe.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.temeliobe.entities.NonProfitCSV;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class FilesRepo {
    private final List<NonProfitCSV> NonProfits;

    public FilesRepo() {
        this.NonProfits = new ArrayList<>();
    }

    public void addNpData(List<String[]> nonProfits) {
        nonProfits.forEach(nonProfit -> {
            NonProfitCSV nonProfitCSV = new NonProfitCSV();
            nonProfitCSV.setNonprofitLegalName(nonProfit[0]);
            nonProfitCSV.setGrantSubmissionName(nonProfit[1]);
            nonProfitCSV.setStage(nonProfit[2]);
            nonProfitCSV.setFoundationOwner(nonProfit[3]);
            nonProfitCSV.setRequestedAmount(nonProfit[4]);
            nonProfitCSV.setAwardedAmount(nonProfit[5]);
            nonProfitCSV.setGrantType(nonProfit[6]);
            nonProfitCSV.setTags(nonProfit[7]);
            nonProfitCSV.setDurationStart(nonProfit[8]);
            nonProfitCSV.setDurationEnd(nonProfit[9]);
            nonProfitCSV.setAdditionalFileFolderPath(nonProfit[10]);
            nonProfitCSV.setGrantSubmissionId(nonProfit[11]);
            this.NonProfits.add(nonProfitCSV);
        });
    }

    public List<NonProfitCSV> getNpCSVData() {
        return this.NonProfits;
    }

}
