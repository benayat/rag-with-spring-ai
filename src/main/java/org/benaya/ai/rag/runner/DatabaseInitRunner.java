package org.benaya.ai.rag.runner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.benaya.ai.rag.service.CsvParserService;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.MilvusVectorStore;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@ConditionalOnProperty(value = {"init.database"}, havingValue = "true")
public class DatabaseInitRunner implements ApplicationRunner {
    private final MilvusVectorStore milvusVectorStore;
    private final CsvParserService csvParserService;

    @Override
    public void run(ApplicationArguments args) {
        List<Document> documents = csvParserService.getContentFromCsv();
        log.info("Adding documents to vector store");
        documents.forEach(doc -> log.info("Document: {}", doc));
        milvusVectorStore.add(documents);
        log.info("done!");
    }
}
