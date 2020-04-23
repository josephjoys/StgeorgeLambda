package utils;

import java.util.HashMap;
import java.util.Map;

public class TestUtils {
    public static Map<String,String> event = new HashMap<>();
    public static Map<String,String> getTesEvent(){
        event.put("FirstName","John");
        event.put("LastName","Smith");
        event.put("EmailAddress","john.smith@happy.com");
        event.put("PhoneNumber","4254581210");
        event.put("RequestFor","ContactUs");
        event.put("EMAIL","email@email.com");
        return event;
    }

}
