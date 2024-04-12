package io.camunda.connector.gbooks.model.request.input;

public class OperationInput {

    private String type;
    private String searchParams;
    private String volumeId;
    private String bookshelfId;
    private String userId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSearchParams() {
        return searchParams;
    }

    public void setSearchParams(String searchParams) {
        this.searchParams = searchParams;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    public String getBookshelfId() {
        return bookshelfId;
    }

    public void setBookshelfId(String bookshelfId) {
        this.bookshelfId = bookshelfId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
