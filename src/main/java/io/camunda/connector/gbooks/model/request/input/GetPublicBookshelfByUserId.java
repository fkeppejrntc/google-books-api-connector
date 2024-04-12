/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. Licensed under a proprietary license.
 * See the License.txt file for more information. You may not use this file
 * except in compliance with the proprietary license.
 */
package io.camunda.connector.gbooks.model.request.input;

import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

public final class GetPublicBookshelfByUserId {
    @NotBlank
    private String userId;
    @NotBlank
    private String bookshelfId;

    public GetPublicBookshelfByUserId(String userId, String bookshelfId) {
        this.userId = userId;
        this.bookshelfId = bookshelfId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
        if (!(o instanceof GetPublicBookshelfByUserId that)) return false;
        return Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getBookshelfId(), that.getBookshelfId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getBookshelfId());
    }

    @Override
    public String toString() {
        return "GetPublicBookshelfByUserId{" +
                "userId='" + userId + '\'' +
                ", bookshelfId='" + bookshelfId + '\'' +
                '}';
    }
}