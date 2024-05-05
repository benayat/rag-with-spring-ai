package org.benaya.ai.rag.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final ChatClient chatClient;
    @GetMapping(path = "/prompt")
    public String prompt(@RequestParam String prompt) {
        return this.chatClient.call(prompt);
    }
}
