package io.camunda.connector.gbooks.model.google;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Review {
    
    private Author author;
    
    private String content;
    
    private String date;
    
    private String fullTextUrl;
    
    private String kind;
    
    private String rating;
    
    private Source source;
    
    private String title;
    
    private String type;
    
    private String volumeId;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class Source {
        
        private String description;
        
        private String extraDescription;
        
        private String url;

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class Author {
        
        private String displayName;

    }
}
