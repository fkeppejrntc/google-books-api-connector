package io.camunda.connector.gbooks.operation.impl;

import com.google.gson.JsonObject;
import io.camunda.connector.gbooks.mapper.VolumeMapper;
import io.camunda.connector.gbooks.model.auth.Authentication;
import io.camunda.connector.gbooks.model.request.input.AddVolumeToMyBookshelf;
import io.camunda.connector.gbooks.model.response.GoogleBooksResult;
import io.camunda.connector.gbooks.operation.GoogleBooksOperation;
import io.camunda.connector.gbooks.service.ImplementationService;
import io.camunda.connector.gbooks.supplier.GoogleObjectsMock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;
import static org.springframework.http.HttpMethod.POST;

public class AddVolumeToMyBookshelfOperation extends GoogleBooksOperation {

    private final AddVolumeToMyBookshelf model;

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    GoogleObjectsMock googleObjectsMock = new GoogleObjectsMock();

    @Autowired
    ImplementationService implementationService = new ImplementationService();

    @Autowired
    VolumeMapper volumeMapper = new VolumeMapper();

    private static final Logger LOGGER = LoggerFactory.getLogger(AddVolumeToMyBookshelfOperation.class);

    public AddVolumeToMyBookshelfOperation(AddVolumeToMyBookshelf model) {
        this.model = model;
    }

    @Override
    public Object execute(Authentication auth) {
        LOGGER.info("###########  GOOGLE BOOKS - GOT TO OPERATIONS - AddVolumeToMyBookshelfOperation.");

        //HERE USING REST TEMPLATE

        String url = format("https://www.googleapis.com/books/v1/mylibrary/bookshelves/"+model.getBookshelfId()+"/addVolume");

        LOGGER.info("ADDING BOOK TO BOOKSHELF - URL: "+url);

        var body = new JsonObject();
        body.addProperty("volumeId", model.getVolumeId());
        var entity = new HttpEntity<>(body.toString(), implementationService.getHeaders(auth.getBearerToken()));

        LOGGER.info("ADDING BOOK TO BOOKSHELF - Entity:" + entity.toString());

        var responseEntity = restTemplate.exchange(url, POST, entity, Object.class);
        LOGGER.info("ADDING BOOK TO BOOKSHELF - Response: "+ responseEntity.getBody());
        LOGGER.info("ADDING BOOK TO BOOKSHELF - StatusCode: "+ responseEntity.getStatusCode().toString());

        GoogleBooksResult response;
        if (responseEntity.getStatusCode() == HttpStatusCode.valueOf(200))
            response = new GoogleBooksResult("Book added to bookshelf","200");
        else
            response = new GoogleBooksResult("Book NOT added to bookshelf",responseEntity.getStatusCode().toString());

        return response;
    }
}
