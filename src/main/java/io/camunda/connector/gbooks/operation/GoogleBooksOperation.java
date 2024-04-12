/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. Licensed under a proprietary license.
 * See the License.txt file for more information. You may not use this file
 * except in compliance with the proprietary license.
 */
package io.camunda.connector.gbooks.operation;

import io.camunda.connector.gbooks.model.auth.Authentication;

public abstract class GoogleBooksOperation {

    protected static final String SPREADSHEET_ID_FIELD = "spreadsheetId";
    protected static final String SPREADSHEET_URL_FIELD = "spreadsheetUrl";
    protected static final String VALUE_INPUT_OPTION = "USER_ENTERED";

    public abstract Object execute(final Authentication auth);

    //  protected final void batchUpdate(
    //      final Authentication auth, final String spreadsheetId, BatchUpdateSpreadsheetRequest
    // request)
    //      throws IOException {
    //    Sheets service = GoogleBooksServiceSupplier.getGoogleBooksService(auth);
    //
    //    service
    //        .spreadsheets()
    //        .batchUpdate(spreadsheetId, request)
    //        .setFields(buildFields(SPREADSHEET_ID_FIELD))
    //        .execute();
    //  }
    //
    //  protected final void update(
    //      final Authentication auth,
    //      final String spreadsheetId,
    //      final String range,
    //      final ValueRange valueRange)
    //      throws IOException {
    //    Sheets service = GoogleBooksServiceSupplier.getGoogleBooksService(auth);
    //
    //    service
    //        .spreadsheets()
    //        .values()
    //        .update(spreadsheetId, range, valueRange)
    //        .setValueInputOption(VALUE_INPUT_OPTION)
    //        .execute();
    //  }
    //
    //  protected final List<List<Object>> get(
    //      final Authentication auth, final String spreadsheetId, final String range)
    //      throws IOException {
    //    Sheets service = GoogleBooksServiceSupplier.getGoogleBooksService(auth);
    //
    //    ValueRange result = service.spreadsheets().values().get(spreadsheetId, range).execute();
    //
    //    return result.getValues();
    //  }
    //
    //  protected final String buildRange(String worksheetName, String range) {
    //    if (worksheetName != null) {
    //      return worksheetName + "!" + range;
    //    }
    //
    //    return range;
    //  }
    //
    //  protected final String buildRowRange(Integer rowIndex) {
    //    return rowIndex + ":" + rowIndex;
    //  }
    //
    //  protected String buildFields(String... fields) {
    //    return String.join(",", fields);
    //  }
}
