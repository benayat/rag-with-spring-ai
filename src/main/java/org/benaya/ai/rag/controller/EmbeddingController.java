package org.benaya.ai.rag.controller;

import lombok.RequiredArgsConstructor;
import org.benaya.ai.rag.service.EmbeddingsGeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/embedding")
public class EmbeddingController {
    private final EmbeddingsGeneratorService embeddingsGeneratorService;

    @GetMapping(path = "/embedding")
    public List<Double> embedding(@RequestParam String prompt) {
        return this.embeddingsGeneratorService.getEmbeddings(prompt);
    }

}
