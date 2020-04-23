package stgeorge.validator;

import com.google.gson.internal.$Gson$Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RequestValidate {
    private Map<String, String> data;

    public RequestValidate(Map<String, String> data) {
        this.data = data;
    }

    public RequestValidationResult validateRequest() {
        boolean isValid = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ");

        if (data.isEmpty()) {
            isValid = false;
            stringBuilder.append(" Request is Empty, ");
        }
        if (data.containsKey("firstname")) {
            if (data.get("firstname").length() <= 1) {
                isValid = false;
                stringBuilder.append(" FirstName is in valid, ");
            }
        } else {
            isValid = false;
            stringBuilder.append(" FirstName is missing, ");
        }


        if (data.containsKey("lastname")) {
            if (data.get("lastname").length() <= 1) {
                isValid = false;
                stringBuilder.append(" LastName is in valid, ");
            }
        } else {
            isValid = false;
            stringBuilder.append(" LastName is missing, ");
        }

        if (data.containsKey("emailaddress")) {
            if (data.get("emailaddress").length() <= 4) {
                isValid = false;
                stringBuilder.append(" EmailAddress is invalid, ");
            }
        } else {
            isValid = false;
            stringBuilder.append(" EmailAddress is missing, ");
        }
        if (data.containsKey("phonenumber")) {
            if (data.get("phonenumber").length() < 10) {
                isValid = false;
                stringBuilder.append(" PhoneNumber is invalid, ");
            }
        } else {
            isValid = false;
            stringBuilder.append(" PhoneNumber is missing, ");
        }

        if (data.containsKey("case") && data.get("case").equals("contactus")) {

            RequestValidationResult validationResult = MessageValidation(data, "ContactUs");
            isValid = validationResult.getrequestValid();
            stringBuilder.append(validationResult.getMessage());


        }

        if (data.containsKey("case") && data.get("case").equals("qurbananominations")) {
            if (data.containsKey("services")) {
                if (data.get("services").length() < 1) {
                    isValid = false;
                    stringBuilder.append(" Service is missing for qurbana nominations, ");
                }
            } else {
                isValid = false;
                stringBuilder.append(" Service is missing for qurbana nominations, ");
            }

            RequestValidationResult validationResult = MessageValidation(data, "Qurbana Nominations");
            isValid = validationResult.getrequestValid();
            stringBuilder.append(validationResult.getMessage());


        }
        if (data.containsKey("case") && data.get("case").equals("perunnalshare")) {
            if (data.containsKey("perunnal")) {
                if (data.get("perunnal").length() < 1) {
                    isValid = false;
                    stringBuilder.append(" Perunnal is missing for Perunnal Share request, ");
                }

            } else {
                isValid = false;
                stringBuilder.append(" Perunnal is missing for Perunnal Share request, ");
            }
            RequestValidationResult validationResult = MessageValidation(data, "Perunnal Share");
            isValid = validationResult.getrequestValid();
            stringBuilder.append(validationResult.getMessage());


        }

        if (data.containsKey("case") && data.get("case").equals("prayerrequests")) {

            RequestValidationResult validationResult = MessageValidation(data, "Prayer Requests");
            isValid = validationResult.getrequestValid();
            stringBuilder.append(validationResult.getMessage());


        }
        if (data.containsKey("case") && data.get("case").equals("onlinegiving")) {
            if (data.containsKey("amount")) {
                if (data.get("amount").length() < 1) {
                    isValid = false;
                    stringBuilder.append(" Amount is missing for Online Giving, ");
                }
            } else {
                isValid = false;
                stringBuilder.append(" Amount is missing for Online Giving, ");
            }
        }

        RequestValidationResult result = new RequestValidationResult(isValid, stringBuilder.toString());
        return result;
    }


    private RequestValidationResult MessageValidation(Map<String, String> data, String Case) {
        boolean isValid = true;
        String message = "";
        if (data.containsKey("message")) {
            if (data.get("message").length() < 1) {
                isValid = false;
                message = String.format(" Message is invalid from {s} request, ", Case);
            }
        } else {
            isValid = false;
            message = String.format(" Message is empty from {s} request, ", Case);

        }
        RequestValidationResult result = new RequestValidationResult(isValid, message);
        return result;
    }


}

