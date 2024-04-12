package io.camunda.connector.gbooks;

import io.camunda.connector.gbooks.model.auth.Authentication;
import io.camunda.connector.gbooks.model.auth.AuthenticationType;
import io.camunda.connector.gbooks.model.request.GoogleBooksRequest;
import io.camunda.connector.gbooks.model.request.input.OperationInput;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {

    @Autowired
    private static GoogleBooksFunction function = new GoogleBooksFunction();

    public static void main(String[] args) {
        var operation = new OperationInput();
        operation.setBookshelfId("1001");

        var auth = new Authentication();
        auth.setAuthType(AuthenticationType.BEARER);
        auth.setBearerToken("ya29.a0Ad52N3_cY8j36pmAV5mL80rH4mqlKeDDVh1niUrRADlZROK4xgOrJUl26XYO0QvbAbYUVsMxI_XuY704wgt2EIjkusl0cvOBFCvNmEbb7nnYkRs3HrnqtyCu4k2POTzaKCi3kdg-rr-SU7WqHBQuvD_dbBKRmAvOGNKgaCgYKAYASARESFQHGX2Mi3d9GVDFQgxC1GoVXCMgr0w0171");

        var request = new GoogleBooksRequest();
        request.setOperation(operation);
        request.setAuthentication(auth);

        function.executeOperation(request);

    }
}
