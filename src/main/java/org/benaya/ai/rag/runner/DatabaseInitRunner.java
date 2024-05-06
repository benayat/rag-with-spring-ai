package org.benaya.ai.rag.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.benaya.ai.rag.repository.DocumentRepository;
import org.benaya.ai.rag.service.CsvParserService;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@ConditionalOnProperty(value = {"database.init"}, havingValue = "true")
public class DatabaseInitRunner implements ApplicationRunner {
    private final DocumentRepository documentRepository;
    private final CsvParserService csvParserService;
    @Value("classpath:sample_nda.csv")
    private Resource ndaResource;

    @Override
    public void run(ApplicationArguments args) {
        List<Document> documents = csvParserService.getContentFromCsv(ndaResource);
        log.info("Adding documents to vector store");
        documents.forEach(doc -> log.debug("Document: {}", doc));
        documentRepository.addDocuments(documents);
        log.info("done!");
    }
}
