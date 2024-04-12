/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. Licensed under a proprietary license.
 * See the License.txt file for more information. You may not use this file
 * except in compliance with the proprietary license.
 */
package io.camunda.connector.gbooks.model.request.input;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public final class SearchVolumes {

    @NotBlank
    private String searchParameters;

    public SearchVolumes(String searchParameters) {
        this.searchParameters = searchParameters;
    }

    public String getSearchParameters() {
        return searchParameters;
    }

    public void setSearchParameters(String searchParameters) {
        this.searchParameters = searchParameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchVolumes that)) return false;
        return Objects.equals(getSearchParameters(), that.getSearchParameters());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSearchParameters());
    }

    @Override
    public String toString() {
        return "SearchVolumes{" +
                "searchParameters='" + searchParameters + '\'' +
                '}';
    }
}
