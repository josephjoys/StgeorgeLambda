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
        if ((inputData.get("requestfor") != null) && inputData.containsKey("requestfor")){
            switch (inputData.get("requestfor")) {
                case "contactus":
                    setContactUs();
                    break;
                case "qurbananominations":
                    setQurbanaNomination();
                    break;
                case "perunnalshare":
                    setPerunnalshare();
                    break;
                case "prayerrequest":
                    setPrayerRequest();
                    break;
                case "onlinegiving":
                    setOnlineGiving();
                    break;
            }
        } else {
            throw new InvalidParameterException("Invalid RequestFor :" + inputData.get("RequestFor"));
        }
    }
    private void setOnlineGiving() {
        trigger = Trigger.EMAIL;
        toAddress = System.getenv("OnlineGivingToAddress");
        subject = CreateSubject("Online Giving Request");
        StringBuilder sb = new StringBuilder("Hi \n \n  You have a new Online Giving request from StGeorge website. Please see the details below.\n");
        sb.append(CreateEmailMessageBody(sb));
        if(!StringUtils.isEmpty(inputData.get("amount"))) sb.append("\nAmount : "+inputData.get("amount"));
        sb.append("\n\nThanks\nwww.stgeorgechurchseattle.org");
        message = sb.toString();
    }

    private void setContactUs() {
        trigger = Trigger.EMAIL;
        toAddress = System.getenv("ContactUsToAddress");
        subject = CreateSubject("New Contact Request");
        StringBuilder sb = new StringBuilder("Hi \n \n  You have a new contact request from StGeorge website. Please see the details below.\n");
        sb.append(CreateEmailMessageBody(sb));
        if(!StringUtils.isEmpty(inputData.get("message"))) sb.append("\nMessage : "+inputData.get("message"));
        sb.append("\n\nThanks\nwww.stgeorgechurchseattle.org");
        message = sb.toString();
    }

    private void setPrayerRequest() {
        trigger = Trigger.EMAIL;
        toAddress = System.getenv("ContactUsToAddress");
        subject = CreateSubject("Prayer Request");
        StringBuilder sb = new StringBuilder("Hi \n \n  You have a new Prayer Request from StGeorge website. Please see the details below.\n");
        sb.append(CreateEmailMessageBody(sb));
        if(!StringUtils.isEmpty(inputData.get("message"))) sb.append("\nPrayer request message : "+inputData.get("message"));
        sb.append("\n\nThanks\nwww.stgeorgechurchseattle.org");
        message = sb.toString();
    }
    private void setQurbanaNomination() {
        trigger = Trigger.EMAIL;
        toAddress = System.getenv("QurbanaNominationToAddress");
        subject = CreateSubject("Qurbana Nomination Request");
        StringBuilder sb = new StringBuilder("Hi \n \n  You have a new Qurbana Nomination Request from StGeorge website. Please see the details below.\n");
        sb.append(CreateEmailMessageBody(sb));
        if(!StringUtils.isEmpty(inputData.get("services"))) sb.append("\nQurbana services : "+inputData.get("services"));
        if(!StringUtils.isEmpty(inputData.get("message"))) sb.append("\nMessage : "+inputData.get("message"));
        sb.append("\n\nThanks\nwww.stgeorgechurchseattle.org");
        message = sb.toString();
    }
    private void setPerunnalshare() {
        trigger = Trigger.EMAIL;
        toAddress = System.getenv("perunnalshareToAddress");
        subject = CreateSubject("Perunnal Share Request");
        StringBuilder sb = new StringBuilder("Hi \n \n  You have a new Perunnal Share Request from StGeorge website. Please see the details below.\n");
        sb.append(CreateEmailMessageBody(sb));
        if(!StringUtils.isEmpty(inputData.get("perunnal"))) sb.append("\nPerunnal : "+inputData.get("perunnal"));
        if(!StringUtils.isEmpty(inputData.get("message"))) sb.append("\nMessage : "+inputData.get("message"));
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

    private String CreateSubject(String subjectLine)
    {
        StringBuilder sub = new StringBuilder(subjectLine);
        if(!StringUtils.isEmpty(inputData.get("firstname"))) sub.append(" "+inputData.get("firstname"));
        if(!StringUtils.isEmpty(inputData.get("firstname")))  sub.append(" "+inputData.get("lastname"));
        return sub.toString();
    }
    private StringBuilder CreateEmailMessageBody(StringBuilder sb) {
        if(!StringUtils.isEmpty(inputData.get("firstname"))) sb.append("\nFirst Name : "+inputData.get("firstname"));
        if(!StringUtils.isEmpty(inputData.get("lastname")))  sb.append("\nLast Name : "+inputData.get("lastname"));
        if(!StringUtils.isEmpty(inputData.get("emailaddress"))) sb.append("\nEmail Address : "+inputData.get("emailaddress"));
        if(!StringUtils.isEmpty(inputData.get("phonenumber"))) sb.append("\nPhoneNumber : "+inputData.get("phonenumber"));
        return sb;
    }
}
