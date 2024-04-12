/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. Licensed under a proprietary license.
 * See the License.txt file for more information. You may not use this file
 * except in compliance with the proprietary license.
 */
package io.camunda.connector.gbooks.model.request.input;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public final class RemoveVolumeFromMyBookshelf {
    @NotBlank
    private String bookshelfId;
    @NotBlank
    private String volumeId;

    public RemoveVolumeFromMyBookshelf(String bookshelfId, String volumeId) {
        this.bookshelfId = bookshelfId;
        this.volumeId = volumeId;
    }

    public String getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(String bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RemoveVolumeFromMyBookshelf that)) return false;
        return Objects.equals(getBookshelfId(), that.getBookshelfId()) && Objects.equals(getVolumeId(), that.getVolumeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookshelfId(), getVolumeId());
    }

    @Override
    public String toString() {
        return "RemoveVolumeFromMyBookshelf{" +
                "bookshelfId='" + bookshelfId + '\'' +
                ", volumeId='" + volumeId + '\'' +
                '}';
    }
}