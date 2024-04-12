/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. Licensed under a proprietary license.
 * See the License.txt file for more information. You may not use this file
 * except in compliance with the proprietary license.
 */
package io.camunda.connector.gbooks;

import io.camunda.connector.gbooks.model.request.input.GetMyBookshelf;
import io.camunda.connector.gbooks.model.request.input.GetVolumesListFromMyBookshelf;
import io.camunda.connector.gbooks.model.request.input.SearchVolumes;
import io.camunda.connector.gbooks.model.request.input.*;
import io.camunda.connector.gbooks.operation.GoogleBooksOperation;
import io.camunda.connector.gbooks.operation.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleBooksOperationFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleBooksOperationFactory.class);
    private static final GoogleBooksOperationFactory instance = new GoogleBooksOperationFactory();

    private GoogleBooksOperationFactory() {
    }

    public static GoogleBooksOperationFactory getInstance() {
        return instance;
    }

    public GoogleBooksOperation createOperation(OperationInput input) {
        GoogleBooksOperation operation;
        if (input.getType().equals("searchVolumes")) {
            LOGGER.info("Operation Selected - searchVolumes");
            var in = new SearchVolumes(input.getSearchParams());
            operation = new SearchVolumesOperation(in);
        } else if (input.getType().equals("getMyBookshelf")) {
            LOGGER.info("Operation Selected - getMyBookshelf");
            var in = new GetMyBookshelf(input.getBookshelfId());
            operation = new GetMyBookshelfOperation(in);
        } else if (input.getType().equals("getVolumesListFromMyBookshelf")) {
            LOGGER.info("Operation Selected - getVolumesListFromMyBookshelf");
            var in = new GetVolumesListFromMyBookshelf(input.getBookshelfId());
            operation = new GetVolumeListFromMyBookshelfOperation(in);
        } else if (input.getType().equals("addVolumeToMyBookshelf")) {
            LOGGER.info("Operation Selected - addVolumeToMyBookshelf");
            var in = new AddVolumeToMyBookshelf(input.getBookshelfId(), input.getVolumeId());
            operation = new AddVolumeToMyBookshelfOperation(in);
        } else if (input.getType().equals("removeVolumeFromMyBookshelf")) {
            LOGGER.info("Operation Selected - removeVolumeFromMyBookshelf");
            var in = new RemoveVolumeFromMyBookshelf(input.getBookshelfId(), input.getVolumeId());
            operation = new RemoveVolumeFromMyBookshelfOperation(in);
        } else {
            throw new UnsupportedOperationException("Unsupported operation : [" + input.getClass() + "]");
        }

        return operation;
    }
}
