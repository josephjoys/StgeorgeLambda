package stgeorge.validator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import stgeorge.util.Trigger;
import utils.TestUtils;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestValidationResultTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }
    @Test
    public void testPeunnalRequest(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("case","perunnalshare");
        d.put("perunnal","perunnalshare");
        d.put("message","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void testPeunnalRequestIsMissingPerunnal(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("case","perunnalshare");
        d.put("message","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void testPeunnalRequestIsMissingMessage(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("case","perunnalshare");
        d.put("perunnal","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void testFirstNameFieldIsMissingRequest(){
        Map<String, String> mapping = new HashMap<>();
        mapping.put("lastname", "smith");
        mapping.put("emailaddress","Johnsmith@aol.com");
        mapping.put("phonenumber", "4254564561");
        RequestValidate validate = new RequestValidate(mapping);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void testLastNameFieldIsMissingRequest(){
        Map<String, String> mapping = new HashMap<>();
        mapping.put("firstname", "smith");
        mapping.put("emailaddress","Johnsmith@aol.com");
        mapping.put("phonenumber", "4254564561");
        RequestValidate validate = new RequestValidate(mapping);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void testEmailaddressFieldIsMissingRequest(){
        Map<String, String> mapping = new HashMap<>();
        mapping.put("firstname", "smith");
        mapping.put("lastname","Johnsmith@aol.com");
        mapping.put("phonenumber", "4254564561");
        RequestValidate validate = new RequestValidate(mapping);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void testPhonenumberFieldIsMissingRequest(){
        Map<String, String> mapping = new HashMap<>();
        mapping.put("firstname", "smith");
        mapping.put("lastname","Johnsmith@aol.com");
        mapping.put("phonenumber", "4254564561");
        RequestValidate validate = new RequestValidate(mapping);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }

    @Test
    public void testContactUsRequest(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("case","contactus");
        d.put("message","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void testContactUsRequestIsMissingMessage(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("case","contactus");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void testQurbanaNominationsRequest(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("case","qurbananominations");
        d.put("service","perunnalshare");
        d.put("message","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void testQurbanaNominationsRequestIsMissingService(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("case","qurbananominations");
        d.put("service","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void testQurbanaNominationsRequestIsMissingMessage(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("case","qurbananominations");
        d.put("service","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void testPrayerRequest(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("case","prayerrequest");
        d.put("message","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void testPrayerRequestIsMissingMessage(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("case","prayerrequests");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void testOnlineGiving(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("case","onlinegiving");
        d.put("amount","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void testOnlineGivingIsMissingAmount(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("case","onlinegiving");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }

}