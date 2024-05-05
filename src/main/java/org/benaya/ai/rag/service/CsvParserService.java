package org.benaya.ai.rag.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.benaya.ai.rag.model.Paragraph;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CsvParserService {
    public List<Document> getContentFromCsv(){
        try (Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/sample_nda.csv"))
             ; CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .builder()
                .setHeader().setSkipHeaderRecord(true)
                .setTrim(true)
                .setIgnoreEmptyLines(true)
                .setIgnoreHeaderCase(true)
                .build())) {
            List<Document> documentsToAdd = new ArrayList<>();
            for (CSVRecord csvRecord : csvParser) {
                Paragraph paragraph = Paragraph.builder()
                        .id(Long.parseLong(csvRecord.get("DOC_ID")))
                        .page(Integer.parseInt(csvRecord.get("page")))
                        .title(Arrays.stream(csvRecord.get("display").split(" ")).filter(s -> s.equals(s.toUpperCase())).collect(Collectors.joining(" ")))
                        .content(csvRecord.get("passage"))
                        .build();
                documentsToAdd.add(paragraph.toDocument(paragraph));
            }
            return documentsToAdd;
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}
