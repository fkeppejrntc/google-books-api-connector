/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. Licensed under a proprietary license.
 * See the License.txt file for more information. You may not use this file
 * except in compliance with the proprietary license.
 */
package io.camunda.connector.gbooks.model.request;

import com.google.api.client.util.Key;
import io.camunda.connector.gbooks.model.auth.GoogleBaseRequest;
import io.camunda.connector.gbooks.model.request.input.OperationInput;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class GoogleBooksRequest extends GoogleBaseRequest {

    @Key
    @Valid
    @NotNull
    private OperationInput operation;

    public OperationInput getOperation() {
        return operation;
    }

    public void setOperation(OperationInput operation) {
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GoogleBooksRequest that)) return false;
        return Objects.equals(getOperation(), that.getOperation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOperation());
    }

    @Override
    public String toString() {
        return "GoogleBooksRequest{" +
                "operation=" + operation +
                ", authentication=" + authentication +
                '}';
    }
}
