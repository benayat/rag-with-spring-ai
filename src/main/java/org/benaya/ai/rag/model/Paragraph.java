package org.benaya.ai.rag.model;

import lombok.*;
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

    public Document toDocument(@NonNull Paragraph paragraph) {
        return new Document(paragraph.getContent(), Map.of("title", paragraph.getTitle(), "page", paragraph.getPage(), "id", paragraph.getId()));
    }
}
