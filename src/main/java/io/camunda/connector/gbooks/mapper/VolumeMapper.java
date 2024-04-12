package io.camunda.connector.gbooks.mapper;

import io.camunda.connector.gbooks.model.google.Volume;
import io.camunda.connector.gbooks.model.google.Volumes;
import io.camunda.connector.gbooks.model.response.VolumeResponse;
import io.camunda.connector.gbooks.model.response.VolumesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class VolumeMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(VolumeMapper.class);
    public VolumeResponse toVolumeResponse(Volume volume){
        LOGGER.info("inside toVolumeResponse");

        String authors = "";
        if (volume.getVolumeInfo().getAuthors().size() > 0){
            for (String author : volume.getVolumeInfo().getAuthors()){
                if (!authors.isBlank()){
                    authors+=", ";
                }
                authors+=author;
            }
        }

        VolumeResponse volumeResponse = VolumeResponse.builder()
                .id(volume.getId())
                .authors(authors)
                .pageCount(volume.getVolumeInfo().getPageCount())
                .title(volume.getVolumeInfo().getTitle())
                .subtitle(volume.getVolumeInfo().getSubtitle())
                .description(volume.getVolumeInfo().getDescription())
                .genre("History")
                .link(volume.getAccessInfo().getWebReaderLink())
                .selected(false)
                .isBestSeller(true)
                .build();

        return volumeResponse;
    }

    public VolumesResponse toVolumeResponseList (Volumes volumes){
        LOGGER.info("inside toVolumeResponseList");

        List<VolumeResponse> volumeList = new ArrayList<VolumeResponse>();
        if (volumes != null && volumes.getItems() != null && volumes.getItems().size() > 0) {
            for (int i = 0; i < volumes.getItems().size(); i++) {
                var volume = volumes.getItems().get(i);

                String authors = "";
                if (volume.getVolumeInfo().getAuthors().size() > 0){
                    for (String author : volume.getVolumeInfo().getAuthors()){
                        if (!authors.isBlank()){
                            authors+=", ";
                        }
                        authors+=author;
                    }
                }

                String genre = (i%2 == 0) ? "Fiction" : "History";
                Boolean isBestSeller = (i%3 != 0) ? true : false;

                VolumeResponse volumeResponse = VolumeResponse.builder()
                        .id(volume.getId())
                        .authors(authors)
                        .pageCount(volume.getVolumeInfo().getPageCount())
                        .title(volume.getVolumeInfo().getTitle())
                        .subtitle(volume.getVolumeInfo().getSubtitle())
                        .description(volume.getVolumeInfo().getDescription())
                        .genre(genre)
                        .link(volume.getAccessInfo().getWebReaderLink())
                        .selected(false)
                        .isBestSeller(isBestSeller)
                        .build();

                volumeList.add(volumeResponse);
            }
        }
        VolumesResponse volumesResponse = VolumesResponse.builder()
                .volumeList(volumeList)
                .build();
        return volumesResponse;
    }
}
