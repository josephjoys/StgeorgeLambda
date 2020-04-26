package stgeorge.validator;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RequestValidationResultTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void test_validateRequest_RequestFor_Perunnal_Returns_True(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","perunnalshare");
        d.put("perunnal","perunnalshare");
        d.put("message","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_RequestFor_Perunnal_Is_Missing_Perunnal_Field_Returs_False(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","perunnalshare");
        d.put("message","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_RequestFor_Perunnal_Is_Missing_Message_Returns_True(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","perunnalshare");
        d.put("perunnal","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_FirstName_Field_Is_Missing_Returns_False(){
        Map<String, String> mapping = new HashMap<>();
        mapping.put("lastname", "smith");
        mapping.put("emailaddress","Johnsmith@aol.com");
        mapping.put("phonenumber", "4254564561");
        RequestValidate validate = new RequestValidate(mapping);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_LastName_Field_Is_Missing_Request_Returns_False(){
        Map<String, String> mapping = new HashMap<>();
        mapping.put("firstname", "smith");
        mapping.put("emailaddress","Johnsmith@aol.com");
        mapping.put("phonenumber", "4254564561");
        RequestValidate validate = new RequestValidate(mapping);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_EmailAddress_Field_Is_Missing_Request_Returns_False(){
        Map<String, String> mapping = new HashMap<>();
        mapping.put("firstname", "smith");
        mapping.put("lastname","Johnsmith@aol.com");
        mapping.put("phonenumber", "4254564561");
        RequestValidate validate = new RequestValidate(mapping);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_PhoneNumber_Field_Is_Missing_Request_Returns_False(){
        Map<String, String> mapping = new HashMap<>();
        mapping.put("firstname", "smith");
        mapping.put("lastname","Johnsmith@aol.com");
        mapping.put("phonenumber", "4254564561");
        RequestValidate validate = new RequestValidate(mapping);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }

    @Test
    public void test_validateRequest_RequestFor_ContactUs_Returns_True(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","contactus");
        d.put("message","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_RequestFor_ContactUs_Is_Missing_Message_Returns_True(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","contactus");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_RequestFor_QurbanaNominations_Returns_True(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","qurbananominations");
        d.put("service","perunnalshare");
        d.put("message","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_RequestFor_QurbanaNominations_Is_Missing_Service_Returns_False(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","qurbananominations");
              RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_RequestFor_QurbanaNominations_Is_Missing_Message_Returns_True(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","qurbananominations");
        d.put("service","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_RequestFor_PrayerRequest_Is_Returns_True(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","prayerrequest");
        d.put("message","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_RequestFor_PrayerRequest_Is_Missing_Message_Returns_True(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","prayerrequest");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_RequestFor_OnlineGiving_Returns_True(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","onlinegiving");
        d.put("amount","perunnalshare");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertTrue(results.getrequestValid());
    }
    @Test
    public void test_validateRequest_RequestFor_OnlineGiving_Is_Missing_Amount_Returns_False(){
        Map<String, String> d = new HashMap<>();
        d.put("firstname", "John");
        d.put("lastname", "smith");
        d.put("emailaddress","Johnsmith@aol.com");
        d.put("phonenumber", "4254564561");
        d.put("requestfor","onlinegiving");
        RequestValidate validate = new RequestValidate(d);
        RequestValidationResult results = validate.validateRequest();
        Assert.assertFalse(results.getrequestValid());
    }

}