package org.benaya.ai.rag.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
@Getter
public class ChatGeneratorService {
    private final OllamaChatClient ollamaChatClient;
    public String generate(String message) {
        return getOllamaChatClient().call(message);
    }
    public Flux<String> generateStream(String message) {
        return getOllamaChatClient().stream(message);
    }
}
