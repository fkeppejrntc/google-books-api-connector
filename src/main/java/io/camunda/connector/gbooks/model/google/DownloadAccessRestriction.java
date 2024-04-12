package io.camunda.connector.gbooks.model.google;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class DownloadAccessRestriction {
    
    private Boolean deviceAllowed;
    
    private Integer downloadsAcquired;
    
    private Boolean justAcquired;
    
    private String kind;
    
    private Integer maxDownloadDevices;
    
    private String message;
    
    private String nonce;
    
    private String reasonCode;
    
    private Boolean restricted;
    
    private String signature;
    
    private String source;
    
    private String volumeId;

}