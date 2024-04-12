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
public final class ReadingPosition {
    
    private String epubCfiPosition;
    
    private String gbImagePosition;
    
    private String gbTextPosition;
    
    private String kind;
    
    private String pdfPosition;
    
    private DateTime updated;
    
    private String volumeId;

}
