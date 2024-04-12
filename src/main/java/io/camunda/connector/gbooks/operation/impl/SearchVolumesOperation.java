/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. Licensed under a proprietary license.
 * See the License.txt file for more information. You may not use this file
 * except in compliance with the proprietary license.
 */
package io.camunda.connector.gbooks.operation.impl;

import io.camunda.connector.gbooks.model.request.input.SearchVolumes;
import io.camunda.connector.gbooks.model.auth.Authentication;
import io.camunda.connector.gbooks.operation.GoogleBooksOperation;

public class SearchVolumesOperation extends GoogleBooksOperation {

    private final SearchVolumes model;

    public SearchVolumesOperation(SearchVolumes model) {
        this.model = model;
    }

    @Override
    public Object execute(Authentication auth) {
//        Books service = GoogleBooksServiceSupplier.getGoogleBooksService(auth);
//        return service.volumes().get(model.getSearchParameters());
        return true;
    }
}
