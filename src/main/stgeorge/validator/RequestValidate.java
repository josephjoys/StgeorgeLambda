package stgeorge.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RequestValidate {
    private Map<String, String> data;

    public RequestValidate(Map<String, String> data) {
        this.data = data;
    }

    public  List<RequestValidationResult> validateRequest()
    {
        List<RequestValidationResult> results = new ArrayList<RequestValidationResult>();
        if(data.isEmpty())
        {
            RequestValidationResult result = new RequestValidationResult(false,"Request is Empty");
            results.add(result);
            return  results;
        }
        if(data.get("firstname").length() <=1)
        {
            RequestValidationResult result = new RequestValidationResult(false,"FirstName is in valid");
            results.add(result);

        }
        if(data.get("lastname").length() <=1)
        {
            RequestValidationResult result = new RequestValidationResult(false, "LastName is in valid");
            results.add(result);
        }
        if(data.get("emailaddress").length() <=4)
        {
            RequestValidationResult result = new RequestValidationResult(false,"emailaddress is in valid");
            result.setMessage("emailaddress is in valid");
            results.add(result);
        }
        if(data.get("phonenumber").length() <10)
        {
            RequestValidationResult result = new RequestValidationResult(false,"phonenumber is invalid");
            results.add(result);
        }
        if(data.get("case")=="contactus")
        {
            if(data.get("message").length()<1)
            {
                RequestValidationResult result = new RequestValidationResult(false,"Message  is empty from Contact Us request");
                results.add(result);
            }
        }
        if(data.get("case")=="qurbana nominations")
        {
            if(data.get("services").length()<1 )
            {
                RequestValidationResult result = new RequestValidationResult(false,"Service is missing for qurbana nominations");
                results.add(result);
            }
            if(data.get("message").length()<1)
            {
                RequestValidationResult result = new RequestValidationResult(false,"Message is missing for qurbana nominations ");
                results.add(result);
            }

        }
        if(data.get("case")=="perunnal share")
        {
            if(data.get("perunnal").length()<1 )
            {
                RequestValidationResult result = new RequestValidationResult(false,"Perunnal is missing");
                results.add(result);
            }
            if(data.get("message").length()<1)
            {
                RequestValidationResult result = new RequestValidationResult(false,"Message is missing for Perunnal ");
                results.add(result);
            }

        }
        if(data.get("case")=="prayer requests")
        {
            if(data.get("message").length()<1)
            {
                RequestValidationResult result = new RequestValidationResult(false,"Message is missing for Prayer Request ");
                results.add(result);
            }

        }
        if(data.get("case")=="online giving")
        {
            if(data.get("amount").length()<1)
            {
                RequestValidationResult result = new RequestValidationResult(false,"Amount is missing for Online Giving ");
                results.add(result);
            }

        }

        return results;
    }
}
