package org.benaya.ai.rag.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.vectorstore.MilvusVectorStore;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.stereotype.Component;

import org.springframework.ai.document.Document;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MilvusRepository {

    private final MilvusVectorStore milvusVectorStore;

    public void addDocuments(List<Document> docsToAdd) {
        milvusVectorStore.add(docsToAdd);
    }
    public List<Document> similaritySearchWithTopK(String prompt, int topK) {
        SearchRequest searchRequest = SearchRequest.query(prompt).withTopK(topK);
        return milvusVectorStore.similaritySearch(searchRequest);

    }

}
