package stgeorge.orchestrator;

import stgeorge.util.StringUtils;
import stgeorge.util.Trigger;

import java.security.InvalidParameterException;
import java.util.Map;

public class Orchestrator {

    private Map<String, String> inputData;
    private String toAddress = null;
    private String subject = null;
    private Trigger trigger;
    private String message = null;

    public Orchestrator(Map<String, String> data) {

        inputData = data;
    }

    public void orchestrate() {
        if (inputData.get("RequestFor") != null) {
            switch (inputData.get("RequestFor")) {
                case "contactus":
                    setContactUs();
                    break;
            }
        } else {
            throw new InvalidParameterException("Invalid RequestFor :" + inputData.get("RequestFor"));
        }
    }

    private void setContactUs() {
        trigger = Trigger.EMAIL;
        toAddress = System.getenv("ContactUsToAddress");
        subject = "New Contact Request";
        StringBuilder sb = new StringBuilder("Hi \n \n  You have a new contact request from stgeorge website. Please see the details below.\n");
        if(!StringUtils.isEmpty(inputData.get("FirstName"))) sb.append("\nFirst Name : "+inputData.get("FirstName"));
        if(!StringUtils.isEmpty(inputData.get("LastName")))  sb.append("\nLast Name : "+inputData.get("LastName"));
        if(!StringUtils.isEmpty(inputData.get("EmailAddress"))) sb.append("\nEmail Address : "+inputData.get("EmailAddress"));
        if(!StringUtils.isEmpty(inputData.get("PhoneNumber"))) sb.append("\nPhoneNumber : "+inputData.get("PhoneNumber"));
        if(!StringUtils.isEmpty(inputData.get("Message"))) sb.append("\nMessage : "+inputData.get("Message"));
        sb.append("\n\nThanks\nwww.stgeorgechurchseattle.org");
        message = sb.toString();
    }

    public String getToAddress() {
        return toAddress;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }
}
