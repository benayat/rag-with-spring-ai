package org.benaya.ai.rag.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.messages.Message;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.MilvusVectorStore;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RagService {
    @Value("classpath:prompts/system-qa.st")
    private Resource systemNdaPrompt;
    @Value("${spring.ai.ollama.embedding.options.top-k}")
    private int topK;

    private final MilvusVectorStore milvusVectorStore;

    public Prompt generatePromptFromClientPrompt(String clientPrompt) {
        SearchRequest searchRequest = SearchRequest.query(clientPrompt).withTopK(topK);
        List<Document> docs = milvusVectorStore.similaritySearch(searchRequest);
        Message systemMessage = getSystemMessage(docs);
        log.info("System message: {}", systemMessage.getContent());
        UserMessage userMessage = new UserMessage(clientPrompt);
        return new Prompt(List.of(systemMessage, userMessage));
    }
    private Message getSystemMessage(List<Document> similarDocuments) {
        String documents = similarDocuments.stream().map(Document::getContent).collect(Collectors.joining("\n"));
        SystemPromptTemplate systemPromptTemplate = new SystemPromptTemplate(systemNdaPrompt);
        return systemPromptTemplate.createMessage(Map.of("documents", documents));
    }
}