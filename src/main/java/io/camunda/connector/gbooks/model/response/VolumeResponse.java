package io.camunda.connector.gbooks.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VolumeResponse {

    private String id;
    private String authors;
    private Integer pageCount;
    private String title;
    private String subtitle;
    private String description;
    private String genre;
    private String link;
    private Boolean selected;
    private Boolean isBestSeller;
}
