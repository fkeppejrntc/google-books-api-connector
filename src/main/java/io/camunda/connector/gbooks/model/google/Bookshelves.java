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
public final class Bookshelves {
    
    private List<Bookshelf> items;
    private String kind;


}
