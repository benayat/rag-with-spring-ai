package org.benaya.ai.rag.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.benaya.ai.rag.model.Payload;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Getter
@RequiredArgsConstructor
public class EmbeddingsGenerator {

    private final EmbeddingClient embeddingClient;

    public EmbeddingResponse getEmbeddings(Payload payload){
        return getEmbeddingClient().embedForResponse(payload.strings());
    }

}
