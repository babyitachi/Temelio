package com.example.temeliobe.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.temeliobe.entities.NonProfitCSV;
import com.example.temeliobe.repositories.FilesRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FilesServices {
    private final FilesRepo filesRepo;

    public boolean addNpCSV(List<String[]> csvData) {
        this.filesRepo.addNpData(csvData);
        return true;
    }

    public List<NonProfitCSV> getNpCSVData() {
        List<NonProfitCSV> data = this.filesRepo.getNpCSVData();
        return data;
    }

}
