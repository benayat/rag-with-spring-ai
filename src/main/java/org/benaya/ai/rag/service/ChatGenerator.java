package org.benaya.ai.rag.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
public class ChatGenerator {
    OpenAiChatClient openAiChatClient;

    public String generate(String message) {
        return getOpenAiChatClient().call(message);
    }
}
