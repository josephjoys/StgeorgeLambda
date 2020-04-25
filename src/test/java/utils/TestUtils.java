package utils;

import java.util.HashMap;
import java.util.Map;

public class TestUtils {
    public static Map<String,String> event = new HashMap<>();
    public static Map<String,String> getTesEvent(){
        event.put("firstname","John");
        event.put("lastname","Smith");
        event.put("emailaddress","john.smith@happy.com");
        event.put("phonenumber","4254581210");
        event.put("message","email@email.com");
        event.put("requestfor","contactus");
        return event;
    }

}
