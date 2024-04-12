/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. Licensed under a proprietary license.
 * See the License.txt file for more information. You may not use this file
 * except in compliance with the proprietary license.
 */
package io.camunda.connector.gbooks.operation.impl;

import com.google.gson.JsonObject;
import io.camunda.connector.gbooks.config.GoogleConfig;
import io.camunda.connector.gbooks.model.auth.Authentication;
import io.camunda.connector.gbooks.model.google.Bookshelves;
import io.camunda.connector.gbooks.model.request.input.GetMyBookshelf;
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

public class GetMyBookshelfOperation extends GoogleBooksOperation {

    private final GetMyBookshelf model;
    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    GoogleConfig googleConfig = new GoogleConfig();

    @Autowired
    ImplementationService implementationService = new ImplementationService();

    @Autowired
    GoogleObjectsMock googleObjectsMock = new GoogleObjectsMock();

    private static final Logger LOGGER = LoggerFactory.getLogger(GetMyBookshelfOperation.class);

    public GetMyBookshelfOperation(GetMyBookshelf model) {
        this.model = model;
    }

    @Override
    public Object execute(Authentication auth) {
        LOGGER.info("###########  GOOGLE BOOKS - GOT TO OPERATIONS - GetMyBookshelfOperation.");


        // HERE USING NATIVE GOOGLE API
        /*
        LOGGER.info("###########  GOOGLE BOOKS - Auth = "+auth.toString());
        Books service = GoogleBooksServiceSupplier.getGoogleBooksService(auth);
        LOGGER.info("###########  GOOGLE BOOKS - Authenticated.");
        return service.mylibrary().bookshelves().get(model.getBookshelfId());
         */

        //HERE USING REST TEMPLATE

        String url = format("https://www.googleapis.com/books/v1/mylibrary/bookshelves/"+model.getBookshelfId());
//        String url = format(googleConfig.getUrl()+"mylibrary/bookshelves/"+model.getBookshelfId());

        LOGGER.info("GETTING BOOKSHELVES - URL: "+url);

        var body = new JsonObject();
        var entity = new HttpEntity<>(body.toString(), implementationService.getHeaders(auth.getBearerToken()));

        LOGGER.info("GETTING BOOKSHELVES - Entity:" + entity.toString());

        var responseEntity = restTemplate.exchange(url, GET, entity, Bookshelves.class);
        LOGGER.info("GOT BOOKSHELVES SUCCESSFULLY: "+ responseEntity.getBody());
        return responseEntity.getBody();


        //HERE MOCKING DATA
        /*
        Bookshelf result = googleObjectsMock.getBookshelf(1001);
        return result;
         */

    }
}
