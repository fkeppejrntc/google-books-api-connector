package io.camunda.connector.gbooks.model.google;

import com.google.api.client.json.JsonString;
import com.google.api.client.util.DateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class Volume {

    private AccessInfo accessInfo;

    private String etag;

    private String id;

    private String kind;

    private LayerInfo layerInfo;

    private RecommendedInfo recommendedInfo;

    private SaleInfo saleInfo;

    private SearchInfo searchInfo;

    private String selfLink;

    private UserInfo userInfo;

    private VolumeInfo volumeInfo;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class VolumeInfo {

        private Boolean allowAnonLogging;

        private List<String> authors;

        private Double averageRating;

        private String canonicalVolumeLink;

        private List<String> categories;

        private Boolean comicsContent;

        private String contentVersion;

        private String description;

        private VolumeInfo.Dimensions dimensions;

        private VolumeInfo.ImageLinks imageLinks;

        private List<VolumeInfo.IndustryIdentifiers> industryIdentifiers;

        private String infoLink;

        private String language;

        private String mainCategory;

        private String maturityRating;

        private Integer pageCount;

        private VolumeInfo.PanelizationSummary panelizationSummary;

        private String previewLink;

        private String printType;

        private Integer printedPageCount;

        private String publishedDate;

        private String publisher;

        private Integer ratingsCount;

        private Object readingModes;

        private Integer samplePageCount;

        private Volumeseriesinfo seriesInfo;

        private String subtitle;

        private String title;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class PanelizationSummary {

            private Boolean containsEpubBubbles;

            private Boolean containsImageBubbles;

            private String epubBubbleVersion;

            private String imageBubbleVersion;

        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class IndustryIdentifiers {

            private String identifier;

            private String type;

        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class ImageLinks {

            private String extraLarge;

            private String large;

            private String medium;

            private String small;

            private String smallThumbnail;

            private String thumbnail;

        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class Dimensions {

            private String height;

            private String thickness;

            private String width;

        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class UserInfo {

        private DateTime acquiredTime;

        private Integer acquisitionType;

        private Copy copy;

        private Integer entitlementType;

        private FamilySharing familySharing;

        private Boolean isFamilySharedFromUser;

        private Boolean isFamilySharedToUser;

        private Boolean isFamilySharingAllowed;

        private Boolean isFamilySharingDisabledByFop;

        private Boolean isInMyBooks;

        private Boolean isPreordered;

        private Boolean isPurchased;

        private Boolean isUploaded;

        private ReadingPosition readingPosition;

        private RentalPeriod rentalPeriod;

        private String rentalState;

        private Review review;

        private DateTime updated;

        private UserUploadedVolumeInfo userUploadedVolumeInfo;


        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class UserUploadedVolumeInfo {

            private String processingState;

        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class RentalPeriod {

            @JsonString
            private Long endUtcSec;

            @JsonString
            private Long startUtcSec;

        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class FamilySharing {

            private String familyRole;

            private Boolean isSharingAllowed;

            private Boolean isSharingDisabledByFop;

        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class Copy {

            private Integer allowedCharacterCount;

            private String limitType;

            private Integer remainingCharacterCount;

            private DateTime updated;

        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class SearchInfo {

        private String textSnippet;

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class SaleInfo {

        private String buyLink;

        private String country;

        private Boolean isEbook;

        private ListPrice listPrice;

        private List<Offers> offers;

        private DateTime onSaleDate;

        private RetailPrice retailPrice;

        private String saleability;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class RetailPrice {

            private Double amount;

            private String currencyCode;

        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class Offers {

            private Integer finskyOfferType;

            private Boolean giftable;

            private ListPrice listPrice;

            private RentalDuration rentalDuration;

            private RetailPrice retailPrice;


            @Data
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            public static final class RetailPrice {

                private Double amountInMicros;

                private String currencyCode;

            }

            @Data
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            public static final class RentalDuration {

                private Double count;

                private String unit;

            }

            @Data
            @Builder
            @NoArgsConstructor
            @AllArgsConstructor
            public static final class ListPrice {

                private Double amountInMicros;

                private String currencyCode;

            }
        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class ListPrice {

            private Double amount;

            private String currencyCode;

        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class RecommendedInfo {

        private String explanation;

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class LayerInfo {

        private List<Layers> layers;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class Layers {

            private String layerId;

            private String volumeAnnotationsVersion;

        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static final class AccessInfo {

        private String accessViewStatus;

        private String country;

        private DownloadAccessRestriction downloadAccess;

        private String driveImportedContentLink;

        private Boolean embeddable;

        private Epub epub;

        private Boolean explicitOfflineLicenseManagement;

        private Pdf pdf;

        private Boolean publicDomain;

        private Boolean quoteSharingAllowed;

        private String textToSpeechPermission;

        private String viewOrderUrl;

        private String viewability;

        private String webReaderLink;


        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class Pdf {

            private String acsTokenLink;

            private String downloadLink;

            private Boolean isAvailable;

        }

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static final class Epub {

            private String acsTokenLink;

            private String downloadLink;

            private Boolean isAvailable;

        }
    }
}
