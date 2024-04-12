/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. Licensed under a proprietary license.
 * See the License.txt file for more information. You may not use this file
 * except in compliance with the proprietary license.
 */
package io.camunda.connector.gbooks.model.request.input;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public final class RemoveAllVolumesFromMyBookshelf {
    @NotBlank
    private String bookshelfId;

    public RemoveAllVolumesFromMyBookshelf(String bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    public String getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(String bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RemoveAllVolumesFromMyBookshelf that)) return false;
        return Objects.equals(getBookshelfId(), that.getBookshelfId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookshelfId());
    }

    @Override
    public String toString() {
        return "RemoveAllVolumesFromMyBookshelf{" +
                "bookshelfId='" + bookshelfId + '\'' +
                '}';
    }
}