package org.benaya.ai.rag.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.ollama.OllamaEmbeddingClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@RequiredArgsConstructor
public class EmbeddingsGeneratorService {

    private final OllamaEmbeddingClient embeddingClient;

    public List<Double> getEmbeddings(String prompt) {
        return getEmbeddingClient().embed(prompt);
    }

}
