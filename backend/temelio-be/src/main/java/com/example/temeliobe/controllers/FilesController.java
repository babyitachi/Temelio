package com.example.temeliobe.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.temeliobe.entities.NonProfitCSV;
import com.example.temeliobe.services.FilesServices;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/files")
@RestController
public class FilesController {
    private final FilesServices filesServices;

    @PostMapping("/uploadNpCSV")
    public ResponseEntity<String> uploadNpCSV(@RequestParam("file") MultipartFile file) {
        List<String[]> csvData = new ArrayList();

        if (!file.isEmpty()) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                int li = 0;
                while ((line = reader.readLine()) != null) {
                    if (li == 0) {
                        li += 1;
                        continue;
                    }
                    CSVParser csvParser = new CSVParserBuilder().withQuoteChar('"').build();

                    String[] fields = csvParser.parseLine(line);
                    csvData.add(fields);
                }
                this.filesServices.addNpCSV(csvData);
                return ResponseEntity.ok().build();

            } catch (IOException e) {
                // Handle file reading or parsing errors
                e.printStackTrace();
                return ResponseEntity.internalServerError().build();
            }
        }
        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/getNpCSVData")
    public ResponseEntity<List<NonProfitCSV>> getNpCSVData() {
        List<NonProfitCSV> data = this.filesServices.getNpCSVData();
        return ResponseEntity.ok(data);

    }
}
