package org.benaya.ai.rag.controller;

import lombok.RequiredArgsConstructor;
import org.benaya.ai.rag.service.ChatGeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/chat")
public class ChatController {
    private final ChatGeneratorService chatGeneratorService;

    @GetMapping(path = "/prompt")
    public String prompt(@RequestParam String prompt) {
        return chatGeneratorService.generate(prompt);
    }

    @GetMapping(path = "/prompt-stream", produces = "text/event-stream")
    public Flux<String> promptStream(@RequestParam String prompt) {
        return chatGeneratorService.generateStream(prompt);
    }
}
