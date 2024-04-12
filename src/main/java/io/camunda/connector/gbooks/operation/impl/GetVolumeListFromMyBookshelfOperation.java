package io.camunda.connector.gbooks.operation.impl;

import com.google.gson.JsonObject;
import io.camunda.connector.gbooks.mapper.VolumeMapper;
import io.camunda.connector.gbooks.model.request.input.GetVolumesListFromMyBookshelf;
import io.camunda.connector.gbooks.model.auth.Authentication;
import io.camunda.connector.gbooks.model.google.Volumes;
import io.camunda.connector.gbooks.operation.GoogleBooksOperation;
import io.camunda.connector.gbooks.service.ImplementationService;
import io.camunda.connector.gbooks.supplier.GoogleObjectsMock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;
import static org.springframework.http.HttpMethod.GET;

public class GetVolumeListFromMyBookshelfOperation extends GoogleBooksOperation {

    private final GetVolumesListFromMyBookshelf model;

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    GoogleObjectsMock googleObjectsMock = new GoogleObjectsMock();

    @Autowired
    ImplementationService implementationService = new ImplementationService();

    @Autowired
    VolumeMapper volumeMapper = new VolumeMapper();

    private static final Logger LOGGER = LoggerFactory.getLogger(GetVolumeListFromMyBookshelfOperation.class);

    public GetVolumeListFromMyBookshelfOperation(GetVolumesListFromMyBookshelf model) {
        this.model = model;
    }

    @Override
    public Object execute(Authentication auth) {
        LOGGER.info("###########  GOOGLE BOOKS - GOT TO OPERATIONS - GetVolumeListFromMyBookshelfOperation.");


        //HERE USING REST TEMPLATE

        String url = format("https://www.googleapis.com/books/v1/mylibrary/bookshelves/"+model.getBookshelfId()+"/volumes");

        LOGGER.info("GETTING VOLUMES FROM BOOKSHELF - URL: "+url);

        var body = new JsonObject();
        var entity = new HttpEntity<>(body.toString(), implementationService.getHeaders(auth.getBearerToken()));

        LOGGER.info("GETTING VOLUMES FROM BOOKSHELF - Entity:" + entity.toString());

        var responseEntity = restTemplate.exchange(url, GET, entity, Volumes.class);
//        LOGGER.info("GOT BOOKSHELVES SUCCESSFULLY: "+ responseEntity.getBody());

        var response = volumeMapper.toVolumeResponseList(responseEntity.getBody());

        return response;

        //HERE MOCKING DATA
//        Volumes result = googleObjectsMock.getVolumes();
//
//        LOGGER.info("Volumes: List count "+ result.getItems().size());
//
//        return result;
    }
}
