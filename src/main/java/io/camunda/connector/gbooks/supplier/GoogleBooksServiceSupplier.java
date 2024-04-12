/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. Licensed under a proprietary license.
 * See the License.txt file for more information. You may not use this file
 * except in compliance with the proprietary license.
 */
package io.camunda.connector.gbooks.supplier;

//import static io.camunda.google.supplier.util.GoogleServiceSupplierUtil.getHttpHttpCredentialsAdapter;
//import static io.camunda.google.supplier.util.GoogleServiceSupplierUtil.getNetHttpTransport;
//
//import com.google.api.client.json.gson.GsonFactory;
//import com.google.api.services.books.Books;
//import io.camunda.connector.gbooks.model.auth.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class GoogleBooksServiceSupplier {

  private static final Logger LOGGER = LoggerFactory.getLogger(GoogleBooksServiceSupplier.class);

  private GoogleBooksServiceSupplier() {}

//  public static Books getGoogleBooksService(final Authentication auth) {
//    LOGGER.info("Google books trying to authenticate.");
//    Books books =
//        new Books.Builder(
//                getNetHttpTransport(),
//                GsonFactory.getDefaultInstance(),
//                getHttpHttpCredentialsAdapter(auth))
//            .build();
//
//    LOGGER.info("Google books service was successfully initialized.");
//    return books;
//  }
}
