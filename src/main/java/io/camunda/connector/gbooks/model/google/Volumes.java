package io.camunda.connector.gbooks.model.google;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public final class Volumes {
    private List<Volume> items;
    private String kind;
    private Integer totalItems;


}
