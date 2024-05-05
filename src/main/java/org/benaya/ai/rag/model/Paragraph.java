package org.benaya.ai.rag.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.ai.document.Document;

import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class Paragraph {
    private long id;
    private int page;
    private String title;
    private String content;

    public Document toDocument(@NotNull Paragraph paragraph) {
        return new Document(paragraph.getContent(), Map.of("title", paragraph.getTitle(), "page", paragraph.getPage(), "id", paragraph.getId()));
    }
}
