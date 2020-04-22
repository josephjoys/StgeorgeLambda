package stgeorge.validator;

public class RequestValidationResult {
    private boolean requestValid;
    private String message ;
    protected  RequestValidationResult(){

    }

    public  RequestValidationResult (boolean requestValid, String message) {
        super();
        this.requestValid = requestValid;
        this.message = message;

    }
    public boolean getrequestValid() {
        return requestValid;
    }

    public void setrequestValid(boolean requestValid) {
        this.requestValid = requestValid;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
