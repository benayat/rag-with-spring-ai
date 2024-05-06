package org.benaya.ai.rag.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Component;

import org.springframework.ai.document.Document;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DocumentRepository {

    private final VectorStore vectorStore;

    public void addDocuments(List<Document> docsToAdd) {
        vectorStore.add(docsToAdd);
    }
    public List<Document> similaritySearchWithTopK(String prompt, int topK) {
        SearchRequest searchRequest = SearchRequest.query(prompt).withTopK(topK);
        return vectorStore.similaritySearch(searchRequest);
    }
}
