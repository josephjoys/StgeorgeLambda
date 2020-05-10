package stgeorge.validator;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestValidate {
    private Map<String, String> data;
    private int minLength = 1;

    public RequestValidate(Map<String, String> data) {
        this.data = data;
    }

    public RequestValidationResult validateRequest() {

        if (data.isEmpty()) {
            String message = "Request is Empty";
            RequestValidationResult result = new RequestValidationResult(false, message);
            return result;
        }
        if (!IsRequiredFieldPresent(data)) {
            String message = "Required field for Request is missing";
            RequestValidationResult result = new RequestValidationResult(false, message);
            return result;
        }

        if (data.containsKey("firstname")) {
            if (data.get("firstname").length() <= minLength) {
                String message = "FirstName is in valid";
                RequestValidationResult result = new RequestValidationResult(false, message);
                return result;
            }
        }

        if (data.containsKey("lastname")) {
            if (data.get("lastname").length() <= minLength) {
                String message = "LastName is in valid";
                RequestValidationResult result = new RequestValidationResult(false, message);
                return result;
            }
        }

        if (data.containsKey("emailaddress")) {
            {
                String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(data.get("emailaddress"));
                if (!matcher.matches()) {
                    String message = "EmailAddress is invalid";
                    RequestValidationResult result = new RequestValidationResult(false, message);
                    return result;
                }
            }
        }

        if (data.containsKey("phonenumber")) {
            {
                String regex = "^(\\+\\d{1,2}\\s?)?1?\\-?\\.?\\s?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(data.get("phonenumber"));
                if (!matcher.matches()) {
                    String message = "PhoneNumber is invalid";
                    RequestValidationResult result = new RequestValidationResult(false, message);
                    return result;
                }
            }
        }

        if (data.containsKey("requestfor")) {
            String caller = data.get("requestfor");
            switch (caller) {
                case "contactus":
                    return ValidRequest("ContactUs");
                case "qurbananominations":
                    return ValidateQurbanaNomination(data);
                case "perunnalshare":
                    return ValidatePerunnalShare(data);
                case "prayerrequest":
                    return ValidRequest("Prayer Request");
                case "onlinegiving":
                    return ValidateOnlineGiving(data);

            }
        }
        RequestValidationResult result = new RequestValidationResult(false, "The Request is for specified case ");
        return result;
    }

    private RequestValidationResult ValidRequest(String requestFor){
        RequestValidationResult result = new RequestValidationResult(true, requestFor);
        return result;
    }
    private RequestValidationResult ValidateOnlineGiving(Map<String , String> data){
        boolean isValid = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ");
        if (data.containsKey("amount")) {
                if (data.get("amount").length() < 1) {
                    isValid = false;
                    stringBuilder.append(" Amount is missing for Online Giving, ");
                }
            }
            else {
                isValid = false;
                stringBuilder.append(" Amount is missing for Online Giving, ");
            }

        RequestValidationResult result = new RequestValidationResult(isValid, stringBuilder.toString());
        return result;
    }

    private RequestValidationResult ValidatePerunnalShare(Map<String, String> data){
        boolean isValid = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ");
            if (data.containsKey("perunnal")) {
                if (data.get("perunnal").length() < 1) {
                    isValid = false;
                    stringBuilder.append(" Perunnal is missing for Perunnal Share request, ");
                }

            } else {
                isValid = false;
                stringBuilder.append(" Perunnal is missing for Perunnal Share request, ");
            }
            RequestValidationResult result = new RequestValidationResult(isValid, stringBuilder.toString());
            return result;
    }

    private  RequestValidationResult ValidateQurbanaNomination(Map<String,String> data)
    {
        boolean isValid = true;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ");

            if (data.containsKey("services")) {
                if (data.get("services").length() < 1) {
                    isValid = false;
                    stringBuilder.append(" Service is missing for qurbana nominations, ");
                }
            } else {
                isValid = false;
                stringBuilder.append(" Service is missing for qurbana nominations, ");
            }
            RequestValidationResult result = new RequestValidationResult(isValid, stringBuilder.toString());
            return result;
    }

    private boolean IsRequiredFieldPresent(Map<String, String> data) {
        if(data.containsKey("firstname") && data.containsKey("lastname") && data.containsKey("emailaddress") &&data.containsKey("phonenumber"))
            return true;
        return  false;
    }


}

