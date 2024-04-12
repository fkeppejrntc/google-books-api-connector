package io.camunda.connector.gbooks.model.google;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Volumeseriesinfo {
    
    private String bookDisplayNumber;
    
    private String kind;
    
    private String shortSeriesBookTitle;
    
    private List<VolumeSeries> volumeSeries;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class VolumeSeries {
        
        private List<Issue> issue;
        
        private Integer orderNumber;
        
        private String seriesBookType;
        
        private String seriesId;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class Issue {
            
            private String issueDisplayNumber;
            
            private Integer issueOrderNumber;
        }
    }
}
