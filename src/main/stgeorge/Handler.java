package stgeorge;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import stgeorge.mail.Emailer;
import stgeorge.orchestrator.Orchestrator;
import stgeorge.validator.LambdaValidator;
import stgeorge.validator.RequestValidate;
import stgeorge.validator.RequestValidationResult;

import java.util.*;

public class Handler implements RequestHandler<Map<String, String>, String> {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String handleRequest(Map<String, String> event, Context context) {
        System.out.println(gson.toJson(event));
        RequestValidate validator = new RequestValidate(event);
        RequestValidationResult result = validator.validateRequest();
        if (result.getrequestValid()) {
            Orchestrator orchestrator = new Orchestrator(event);
            orchestrator.orchestrate();
            switch (orchestrator.getTrigger()){
                case EMAIL: sendEmail(orchestrator);
                break;
            }
        }
        return result.getMessage();
    }

    private void sendEmail(Orchestrator orchestrator) {
        Emailer emailer = new Emailer();
        emailer.send(orchestrator.getToAddress(), orchestrator.getSubject(), orchestrator.getMessage());
    }

}
