package io.camunda.connector.gbooks.model.google;

import com.google.api.client.util.DateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Bookshelf {
    
    private String access;
    
    private DateTime created;
    
    private String description;
    
    private Integer id;
    
    private String kind;
    
    private String selfLink;
    
    private String title;
    
    private DateTime updated;
    
    private Integer volumeCount;
    
    private DateTime volumesLastUpdated;

}
