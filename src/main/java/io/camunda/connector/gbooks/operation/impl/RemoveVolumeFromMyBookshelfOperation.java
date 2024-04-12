package io.camunda.connector.gbooks.operation.impl;

import com.google.gson.JsonObject;
import io.camunda.connector.gbooks.mapper.VolumeMapper;
import io.camunda.connector.gbooks.model.auth.Authentication;
import io.camunda.connector.gbooks.model.request.input.AddVolumeToMyBookshelf;
import io.camunda.connector.gbooks.model.request.input.RemoveVolumeFromMyBookshelf;
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

public class RemoveVolumeFromMyBookshelfOperation extends GoogleBooksOperation {

    private final RemoveVolumeFromMyBookshelf model;

    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    GoogleObjectsMock googleObjectsMock = new GoogleObjectsMock();

    @Autowired
    ImplementationService implementationService = new ImplementationService();

    @Autowired
    VolumeMapper volumeMapper = new VolumeMapper();

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoveVolumeFromMyBookshelfOperation.class);

    public RemoveVolumeFromMyBookshelfOperation(RemoveVolumeFromMyBookshelf model) {
        this.model = model;
    }

    @Override
    public Object execute(Authentication auth) {
        LOGGER.info("###########  GOOGLE BOOKS - GOT TO OPERATIONS - RemoveVolumeFromMyBookshelf.");

        //HERE USING REST TEMPLATE

        String url = format("https://www.googleapis.com/books/v1/mylibrary/bookshelves/"+model.getBookshelfId()+"/removeVolume");

        LOGGER.info("REMOVING BOOK FROM BOOKSHELF - URL: "+url);

        var body = new JsonObject();
        body.addProperty("volumeId", model.getVolumeId());
        var entity = new HttpEntity<>(body.toString(), implementationService.getHeaders(auth.getBearerToken()));

        LOGGER.info("REMOVING BOOK FROM BOOKSHELF - Entity:" + entity.toString());

        var responseEntity = restTemplate.exchange(url, POST, entity, Object.class);
        LOGGER.info("REMOVING BOOK FROM BOOKSHELF - Response: "+ responseEntity.getBody());
        LOGGER.info("REMOVING BOOK FROM BOOKSHELF - StatusCode: "+ responseEntity.getStatusCode().toString());

        GoogleBooksResult response;
        if (responseEntity.getStatusCode() == HttpStatusCode.valueOf(200))
            response = new GoogleBooksResult("Book removed from bookshelf","200");
        else
            response = new GoogleBooksResult("Book NOT removed from bookshelf",responseEntity.getStatusCode().toString());

        return response;
    }
}
