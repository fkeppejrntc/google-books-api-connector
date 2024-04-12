/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. Licensed under a proprietary license.
 * See the License.txt file for more information. You may not use this file
 * except in compliance with the proprietary license.
 */
package io.camunda.connector.gbooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;
import io.camunda.connector.gbooks.model.request.GoogleBooksRequest;
import io.camunda.connector.gbooks.operation.GoogleBooksOperation;
import io.camunda.connector.generator.java.annotation.ElementTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@OutboundConnector(
        name = "Google Books",
        inputVariables = {"authentication", "operation"},
        type = "io.camunda:google-books:1")
@ElementTemplate(
        id = "io.camunda.connectors.GoogleBooks.v1",
        name = "Google Books Outbound Connector",
        description = "Work with Google Books Library",
        inputDataClass = GoogleBooksRequest.class,
        version = 1)
public class GoogleBooksFunction implements OutboundConnectorFunction {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleBooksFunction.class);

    private final GoogleBooksOperationFactory operationFactory;

    public GoogleBooksFunction() {
        operationFactory = GoogleBooksOperationFactory.getInstance();
    }

    @Override
    public Object execute(OutboundConnectorContext context) throws JsonProcessingException {
        LOGGER.info("###########  GOOGLE BOOKS API STARTED.");

        var request = context.bindVariables(GoogleBooksRequest.class);
        LOGGER.info("Request verified successfully and all required secrets replaced");

        return executeOperation(request);
    }

    public Object executeOperation (GoogleBooksRequest request){
        LOGGER.info("###########  GOOGLE BOOKS - EXECUTE OPERATION.");

        GoogleBooksOperation operation = operationFactory.createOperation(request.getOperation());
        LOGGER.info("Var operation = "+ operation.toString());
        var result = operation.execute(request.getAuthentication());
        LOGGER.info("Var result = "+ result.toString());
        return result;
    }

}
